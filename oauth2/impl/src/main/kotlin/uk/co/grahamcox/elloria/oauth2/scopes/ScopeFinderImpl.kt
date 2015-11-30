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
     * Get a list of all of the known scopes
     * @return the list of scopes
     */
    override fun listScopes(): List<Scope> = scopes

    /**
     * Try to get a single scope with the given ID
     * @param id The ID of the scope to retrieve
     * @return The scope
     * @throws UnknownScopeException if the scope wasn't found
     */
    override fun getScope(id: ScopeId) =
        scopes.find { s -> s.id == id } ?: throw UnknownScopeException(id)
}