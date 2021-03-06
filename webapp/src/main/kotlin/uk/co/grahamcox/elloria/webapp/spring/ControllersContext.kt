package uk.co.grahamcox.elloria.webapp.spring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import uk.co.grahamcox.elloria.oauth2.webapp.spring.OAuth2ControllersContext
import uk.co.grahamcox.elloria.webapp.DebugController
import java.time.Clock

/**
 * The configuration to use for the Spring MVC Controllers
 */
@Configuration
@Import(
    OAuth2ControllersContext::class
)
open class ControllersContext {
    /**
     * Create the Debug Controller
     * @param clock The clock
     * @return the debug controller
     */
    @Autowired
    @Bean
    open fun debugController(clock: Clock) = DebugController(clock)

}