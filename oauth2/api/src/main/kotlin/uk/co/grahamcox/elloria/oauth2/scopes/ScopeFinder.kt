package uk.co.grahamcox.elloria.oauth2.scopes

import uk.co.grahamcox.elloria.Page
import uk.co.grahamcox.elloria.PaginationControls

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
     * List all of the scopes that match the given filters
     * @param pagination The pagination controls to use
     * @param filters The filters to apply to the list
     * @return the list of scopes
     */
    fun listScopes(filters: Map<ScopeField, String> = mapOf(),
                   pagination: PaginationControls = PaginationControls()) : Page<Scope>

    /**
     * Get a single scope with the given ID
     * @param id The ID of the scope to get
     * @return the scope
     */
    fun getScope(id: ScopeId) : Scope
}