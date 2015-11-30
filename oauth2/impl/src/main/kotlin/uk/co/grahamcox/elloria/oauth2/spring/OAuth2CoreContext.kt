package uk.co.grahamcox.elloria.oauth2.spring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import uk.co.grahamcox.elloria.oauth2.scopes.ScopeFinder
import uk.co.grahamcox.elloria.oauth2.scopes.ScopeFinderImpl

/**
 * Core context for the OAuth2 Service
 */
@Configuration
open class OAuth2CoreContext {
    /**
     * The Scope Finder
     */
    @Bean
    open fun scopeFinder(): ScopeFinder = ScopeFinderImpl()
}
