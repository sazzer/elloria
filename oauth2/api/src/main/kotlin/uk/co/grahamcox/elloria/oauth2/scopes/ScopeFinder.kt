package uk.co.grahamcox.elloria.oauth2.scopes

/**
 * Mechanism to find Scope information
 */
interface ScopeFinder {
    /**
     * List all of the scopes
     * @return the list of scopes
     */
    fun listScopes() : List<Scope>

    /**
     * Get a single scope with the given ID
     * @param id The ID of the scope to get
     * @return the scope
     */
    fun getScope(id: ScopeId) : Scope
}