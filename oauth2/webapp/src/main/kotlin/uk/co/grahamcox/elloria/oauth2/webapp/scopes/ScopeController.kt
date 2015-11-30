package uk.co.grahamcox.elloria.oauth2.webapp.scopes

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import uk.co.grahamcox.elloria.oauth2.scopes.ScopeFinder
import uk.co.grahamcox.elloria.oauth2.scopes.ScopeId
import uk.co.grahamcox.elloria.oauth2.scopes.UnknownScopeException
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
     * Handle a request for an unknown Scope by returning an HTTP 404
     */
    @ExceptionHandler(UnknownScopeException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleUnknownScope() {

    }

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
