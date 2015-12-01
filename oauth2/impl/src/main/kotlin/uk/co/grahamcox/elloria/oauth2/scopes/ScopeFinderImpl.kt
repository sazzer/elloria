package uk.co.grahamcox.elloria.oauth2.scopes

import uk.co.grahamcox.elloria.Page
import uk.co.grahamcox.elloria.PaginationControls

/**
 * Implementation of the Scope Finder
 */
class ScopeFinderImpl : ScopeFinder {
    private val scopes = listOf(
        Scope(ScopeId("oauth2", "read"), "Ability to read client information"),
        Scope(ScopeId("oauth2", "write"), "Ability to write client information"),
        Scope(ScopeId("oauth2", "admin"), "Ability to administer client information")
    )

    /**
     * List all of the scopes that match the given filters
     * @param filters The filters to apply to the list
     * @return the list of scopes
     */

    /**
     * List all of the scopes that match the given filters
     * @param pagination The pagination controls to use
     * @param filters The filters to apply to the list
     * @return the list of scopes
     */
    override fun listScopes(filters: Map<ScopeFinder.ScopeField, String>,
                            pagination: PaginationControls) : Page<Scope> {
        val namespaceFilter: String? = filters.get(ScopeFinder.ScopeField.NAMESPACE)
        val scopeFilter: String? = filters.get(ScopeFinder.ScopeField.SCOPE)

        val entries = scopes.filter { s -> when (namespaceFilter) {
            null -> true
            "" -> s.id.namespace == null
            else -> s.id.namespace == namespaceFilter
        } }.filter { s -> when (scopeFilter) {
            null -> true
            else -> s.id.scope == scopeFilter
        } }
            .drop(pagination.offset)
            .take(pagination.limit)


        return Page(entries, scopes.size)
    }

    /**
     * Try to get a single scope with the given ID
     * @param id The ID of the scope to retrieve
     * @return The scope
     * @throws UnknownScopeException if the scope wasn't found
     */
    override fun getScope(id: ScopeId) =
        scopes.find { s -> s.id == id } ?: throw UnknownScopeException(id)
}