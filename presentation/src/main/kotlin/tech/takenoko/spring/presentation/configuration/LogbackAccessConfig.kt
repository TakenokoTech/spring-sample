package tech.takenoko.spring.presentation.configuration

import ch.qos.logback.access.tomcat.LogbackValve
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class LogbackAccessConfig {

    @Bean
    fun servletContainer(): TomcatServletWebServerFactory {
        return TomcatServletWebServerFactory().apply {
            addContextValves(LogbackValve())
        }
    }
}
