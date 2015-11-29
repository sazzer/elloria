package uk.co.grahamcox.elloria.oauth2.webapp.scopes

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Controller for working with scopes
 */
@Controller
@RequestMapping("/api/oauth2/scopes")
class ScopeController {
    /** The scopes that are in the system */
    private val scopes = listOf(
        Scope(id = "oauth2:read", namespace = "oauth", scope = "read", description = "Ability to read client details"),
        Scope(id = "oauth2:write", namespace = "oauth", scope = "write", description = "Ability to write client details"),
        Scope(id = "oauth2:admin", namespace = "oauth", scope = "admin", description = "Ability to administer all client details")
    )

    /**
     * List the scopes that are available
     */
    @RequestMapping
    @ResponseBody
    fun listScopes() = scopes
}