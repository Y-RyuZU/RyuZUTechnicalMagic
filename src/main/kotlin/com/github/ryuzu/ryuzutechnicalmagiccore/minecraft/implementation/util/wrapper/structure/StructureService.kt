package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.structure

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.ISimpleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.structure.IStructureService
import com.onarandombox.MultiverseCore.api.MVWorldManager
import com.sk89q.worldedit.EditSession
import com.sk89q.worldedit.WorldEdit
import com.sk89q.worldedit.WorldEditException
import com.sk89q.worldedit.bukkit.BukkitAdapter
import com.sk89q.worldedit.extent.clipboard.Clipboard
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader
import com.sk89q.worldedit.function.operation.Operation
import com.sk89q.worldedit.function.operation.Operations
import com.sk89q.worldedit.math.BlockVector3
import com.sk89q.worldedit.session.ClipboardHolder
import com.sk89q.worldedit.world.World
import org.bukkit.Bukkit
import org.bukkit.WorldCreator
import org.bukkit.WorldType
import org.koin.core.annotation.Single
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import java.io.*
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.zip.ZipInputStream


@Single([IStructureService::class])
class StructureService : IStructureService {
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val dataFolder: File by inject(named("dataFolder"))
    private val worldContainer: File by inject(named("worldContainer"))
    private val mvWorldManager: MVWorldManager by inject()

    override fun read(location: ConfiguredIntLocation, structure: String): ISimpleScheduler {
        val schematicFile = File(dataFolder, "schematics/$structure")
        val format = ClipboardFormats.findByFile(schematicFile)
        require(format != null) { "Unknown format" }

        val vector = BlockVector3.at(location.vector.x, location.vector.y, location.vector.z)
        var editSession: EditSession? = null
        var clipboard: Clipboard? = null
        var operation: Operation? = null
        return schedulerFactory.createScheduler().schedule { _, _ ->
            try {
                val reader: ClipboardReader = format.getReader(FileInputStream(schematicFile))
                val world: World = BukkitAdapter.adapt(Bukkit.getWorld(location.world))!!
                editSession = WorldEdit.getInstance().newEditSessionBuilder().world(world).build()
                clipboard = reader.read()

                operation = ClipboardHolder(clipboard)
                    .createPaste(editSession)
                    .to(vector)
                    .ignoreAirBlocks(true)
                    .build()

                try {
                    Operations.complete(operation)
                    editSession?.close()
                } catch (e: WorldEditException) {
                    e.printStackTrace()
                }

//                FaweAPI.load(schematicFile).paste(BukkitAdapter.adapt(location.world)!!, vector)


            } catch (e: IOException) {
                e.printStackTrace();
            }

        }.finally { success ->
            if (!success) {
                clipboard?.cancel()
                editSession?.cancel()
                operation?.cancel()
            }
        }.runAsync()
    }

    override fun read(world: String, structure: String): ISimpleScheduler {
        return schedulerFactory.createScheduler().schedule { _, _ ->
            copySchematicWorldToWorldContainer(world, structure)
            schedulerFactory.createScheduler().schedule { _, _ ->
                mvWorldManager.isMVWorld(world) || mvWorldManager.addWorld(world, org.bukkit.World.Environment.NORMAL, null, null, null, null, false)
                mvWorldManager.getMVWorld(world).cbWorld.setGameRule(org.bukkit.GameRule.DO_MOB_SPAWNING, false)
            }.runSync()
        }.runAsync()
    }

    private fun copySchematicWorldToWorldContainer(world: String, structure: String) {
        val schematicFile = File(dataFolder, "schematics/$structure")
        try {
            ZipInputStream(FileInputStream(schematicFile)).use { zipIn ->
                var entry = zipIn.nextEntry

                while (entry != null) {
                    val filePath = Paths.get(worldContainer.path, world, entry.name)
                    if (!entry.isDirectory) {

                        Files.createDirectories(filePath.parent)

                        extractFile(zipIn, filePath)
                    } else
                        Files.createDirectories(filePath)

                    zipIn.closeEntry()
                    entry = zipIn.nextEntry
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Throws(IOException::class)
    private fun extractFile(zipIn: ZipInputStream, filePath: Path) {
        BufferedOutputStream(FileOutputStream(filePath.toFile())).use { bos ->
            val bytesIn = ByteArray(4096)
            var read: Int
            while ((zipIn.read(bytesIn).also { read = it }) != -1) {
                bos.write(bytesIn, 0, read)
            }
        }
    }

    override fun delete(world: String) {
        mvWorldManager.deleteWorld(world)
    }
}