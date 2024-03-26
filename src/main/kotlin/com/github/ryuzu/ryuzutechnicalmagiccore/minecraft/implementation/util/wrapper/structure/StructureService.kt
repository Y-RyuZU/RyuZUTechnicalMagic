package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.structure

import com.fastasyncworldedit.core.FaweAPI
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.ISimpleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.structure.IStructureService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory
import com.onarandombox.MultiverseCore.api.MVWorldManager
import com.sk89q.worldedit.EditSession
import com.sk89q.worldedit.bukkit.BukkitAdapter
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats
import com.sk89q.worldedit.math.BlockVector3
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.WorldType
import org.koin.core.annotation.Single
import org.koin.core.component.inject
import java.io.File

@Single
class StructureService : IStructureService {
    private val schedulerFactory: SimpleSchedulerFactory by inject()
    private val mvWorldManager: MVWorldManager by inject()
    private val file: File by inject()

    override fun read(world: String, structure: String): ISimpleScheduler {
        val format = ClipboardFormats.findByFile(File(structure))
        require(format != null) { "Unknown format" }

        mvWorldManager.addWorld(world, World.Environment.NORMAL, null, WorldType.FLAT, false, "VoidGen")
        var editSession: EditSession? = null
        return schedulerFactory.createScheduler().schedule { _, _ ->
            editSession = FaweAPI.load(File(file, structure))
                .paste(BukkitAdapter.adapt(Bukkit.getWorld(world)), BlockVector3.ZERO)
        }.finally { success ->
            if (!success) {
                editSession?.cancel()
                mvWorldManager.deleteWorld(world)
            }
        }.runAsync()
    }
}