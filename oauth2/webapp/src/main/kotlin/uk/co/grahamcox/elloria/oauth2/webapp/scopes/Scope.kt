package uk.co.grahamcox.elloria.oauth2.webapp.scopes

/**
 * Representation of a Scope as sent over the HTTP API
 * @property id The full ID of the scope
 * @property namespace The namespace of the scope
 * @property scope The scope inside the namespace
 * @property description The description of the scope
 */
data class Scope(val id: String,
                 val namespace: String?,
                 val scope: String,
                 val description: String)