package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.database

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory

@Configuration
class RedisConfig : KoinComponent {
    private val connectionInfo: ConfiguredRedisConnectionInfo by inject()

    @Bean
    fun redisConnectionFactory(): LettuceConnectionFactory {
        val redisStandaloneConfiguration = RedisStandaloneConfiguration(connectionInfo.host, connectionInfo.port)
        redisStandaloneConfiguration.password = RedisPassword.of(connectionInfo.password)
        return LettuceConnectionFactory(redisStandaloneConfiguration)
    }
}