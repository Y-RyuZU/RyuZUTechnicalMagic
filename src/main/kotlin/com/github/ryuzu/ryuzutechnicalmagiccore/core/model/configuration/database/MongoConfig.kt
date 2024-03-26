package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.database

import com.mongodb.ConnectionString
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MongoConfig : KoinComponent {
    private val connectionInfo: ConfiguredMongoConnectionInfo by inject()

    @Bean
    fun mongoClient(): MongoClient {
        val connectionString = ConnectionString(connectionInfo.uri)
        return MongoClients.create(connectionString)
    }
}