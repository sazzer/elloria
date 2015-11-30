package uk.co.grahamcox.elloria.oauth2.scopes

/** The separator between namespace and scope in a Scope ID */
private const val SCOPE_ID_SEPARATOR = ":";

/**
 * Exception thrown when an invalid Scope Identifier is constructed
 * @param message The error message
 */
class InvalidScopeIdentifierException(val namespace: String?,
                                      val scope: String,
                                      message: String) : Exception(message)

/**
 * Representation of the ID of a Scope
 * @property namespace The namespace of the scope
 * @property scope The scope inside the namespce
 */
data class ScopeId(val namespace: String?,
                   val scope: String) {
    companion object {
        /**
         * Parse a combined Scope string into a ScopeId
         * @param input The combined Scope string, in the exact form that {@link ScopeId#toString} returns
         * @return the built ScopeId
         */
        fun parse(input: String) = if (input.contains(SCOPE_ID_SEPARATOR)) {
            val separator = input.indexOf(SCOPE_ID_SEPARATOR)
            val namespace = input.substring(0, separator)
            val scope = input.substring(separator + 1)
            ScopeId(namespace, scope)
        } else {
            ScopeId(null, input)
        }
    }
    init {
        if (namespace != null) {
            if (namespace.isBlank()) {
                throw InvalidScopeIdentifierException(namespace, scope, "Namespace must not be the empty string")
            }
            if (namespace.contains(SCOPE_ID_SEPARATOR)) {
                throw InvalidScopeIdentifierException(namespace, scope, "Namespace must not contain a '${SCOPE_ID_SEPARATOR}' character")
            }
        }

        if (scope.isBlank()) {
            throw InvalidScopeIdentifierException(namespace, scope, "Scope must not be the empty string")
        }
        if (scope.contains(SCOPE_ID_SEPARATOR)) {
            throw InvalidScopeIdentifierException(namespace, scope, "Scope must not contain a '${SCOPE_ID_SEPARATOR}' character")
        }
    }
    /**
     * Generate a string version of the Scope ID. This is the Namespace and Scope separated
     * by a colon character
     * @return the Scope ID as a single string
     */
    override fun toString() = listOf(namespace, scope)
        .filterNotNull()
        .joinToString(SCOPE_ID_SEPARATOR)
}