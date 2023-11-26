package tech.takenoko.spring.presentation.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import tech.takenoko.spring.presentation.interceptor.LoggingInterceptor

@Configuration
class LogConfig(
    private val loggingInterceptor: LoggingInterceptor,
) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(loggingInterceptor)
    }
}
