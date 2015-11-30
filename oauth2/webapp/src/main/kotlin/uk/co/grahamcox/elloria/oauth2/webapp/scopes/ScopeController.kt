package uk.co.grahamcox.elloria.oauth2.webapp.scopes

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import uk.co.grahamcox.elloria.oauth2.scopes.ScopeFinder
import uk.co.grahamcox.elloria.oauth2.scopes.ScopeId
import uk.co.grahamcox.elloria.oauth2.scopes.Scope as InternalScope

/**
 * Map an Internal representation of a Scope onto an HTTP Representation of ne
 */
private fun toHttpScope(scope: InternalScope) = Scope(
    id = scope.id.toString(),
    namespace = scope.id.namespace,
    scope = scope.id.scope,
    description = scope.description
)

/**
 * Controller for working with scopes
 */
@Controller
@RequestMapping("/api/oauth2/scopes")
class ScopeController(private val scopeFinder: ScopeFinder) {
    /**
     * List the scopes that are available
     * @return the scopes
     */
    @RequestMapping
    @ResponseBody
    fun listScopes() = scopeFinder.listScopes().map { s -> toHttpScope(s) }

    /**
     * Get the scope with the given ID
     * @param id The ID of the scope
     * @return the scope
     */
    @RequestMapping("/{id}")
    @ResponseBody
    fun getScope(@PathVariable id: String) = toHttpScope(scopeFinder.getScope(ScopeId.parse(id)))
}
