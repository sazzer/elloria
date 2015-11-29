package uk.co.grahamcox.elloria.oauth2.webapp.spring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import uk.co.grahamcox.elloria.oauth2.webapp.scopes.ScopeController

/**
 * The configuration for the OAuth2 Controllers
 */
@Configuration
open class OAuth2ControllersContext {
    /**
     * Controller for accessing scope details
     * @return the scopes controller
     */
    @Bean
    open fun scopeController() = ScopeController()
}