package uk.co.grahamcox.elloria.oauth2.scopes

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
    override fun listScopes(filters: Map<ScopeFinder.ScopeField, String>): List<Scope> {
        val namespaceFilter: String? = filters.get(ScopeFinder.ScopeField.NAMESPACE)
        val scopeFilter: String? = filters.get(ScopeFinder.ScopeField.SCOPE)

        return scopes.filter { s -> when (namespaceFilter) {
            null -> true
            "" -> s.id.namespace == null
            else -> s.id.namespace == namespaceFilter
        } }.filter { s -> when (scopeFilter) {
            null -> true
            else -> s.id.scope == scopeFilter
        } }
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