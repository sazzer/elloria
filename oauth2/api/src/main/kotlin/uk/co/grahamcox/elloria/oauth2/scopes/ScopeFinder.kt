package uk.co.grahamcox.elloria.oauth2.scopes

/**
 * Mechanism to find Scope information
 */
interface ScopeFinder {
    /** Fields that we can filter on */
    enum class ScopeField {
        /** Filter on the namespace */
        NAMESPACE,
        /** Filter on the scope */
        SCOPE
    }

    /**
     * List all of the scopes
     * @return the list of scopes
     */
    fun listScopes() : List<Scope> = listScopes(mapOf())

    /**
     * List all of the scopes that match the given filters
     * @param filters The filters to apply to the list
     * @return the list of scopes
     */
    fun listScopes(filters: Map<ScopeField, String>) : List<Scope>

    /**
     * Get a single scope with the given ID
     * @param id The ID of the scope to get
     * @return the scope
     */
    fun getScope(id: ScopeId) : Scope
}