package uk.co.grahamcox.elloria.oauth2.scopes

/**
 * Representation of a Scope
 * @property id The ID of the scope
 * @property description The description of the scope
 */
data class Scope(val id: ScopeId,
                 val description: String)