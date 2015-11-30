package uk.co.grahamcox.elloria.oauth2.scopes

/**
 * Exception to indicate that a request was made to loan an unknown Scope
 * @param id The ID of the scope
 */
class UnknownScopeException(val id: ScopeId) : Exception("Unknown scope: ${id}")