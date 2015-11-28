package uk.co.grahamcox.elloria.spring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Clock

/**
 * The root configuration to use for the core webapp Spring context
 */
@Configuration
open class CoreContext {
    /**
     * Configure the clock to use
     * @return the clock
     */
    @Bean(name = arrayOf("clock"))
    open fun clock() = Clock.systemUTC()
}
