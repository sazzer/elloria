package uk.co.grahamcox.elloria.oauth2.scopes

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Unit tests for the Scope ID
 */
@RunWith(JUnitParamsRunner::class)
class ScopeIdTest {
    /**
     * Test building a Scope ID with valid values
     */
    @Test
    @Parameters(method = "validScopes")
    fun testBuildValid(namespace: String?, scope: String) {
        val built = ScopeId(namespace, scope)
        Assert.assertEquals(namespace, built.namespace)
        Assert.assertEquals(scope, built.scope)
    }

    /**
     * Test rendering a single string representing a scope
     */
    @Test
    @Parameters(method = "validScopesCombined")
    fun testToString(namespace: String?, scope: String, combined: String) {
        val built = ScopeId(namespace, scope)
        Assert.assertEquals(combined, built.toString())
    }

    /**
     * Test parsing a Scope ID with valid values
     */
    @Test
    @Parameters(method = "validScopesCombined")
    fun testParseValid(namespace: String?, scope: String, combined: String) {
        val built = ScopeId.parse(combined)
        Assert.assertEquals(namespace, built.namespace)
        Assert.assertEquals(scope, built.scope)
    }

    /**
     * Test building a Scope ID with invalid values
     */
    @Test(expected = InvalidScopeIdentifierException::class)
    @Parameters(method = "invalidScopes")
    fun testBuildInvalid(namespace: String?, scope: String) {
        ScopeId(namespace, scope)
    }

    /**
     * Test parsing a Scope ID with invalid values
     */
    @Test(expected = InvalidScopeIdentifierException::class)
    @Parameters(method = "invalidScopesCombined")
    fun testParseInvalid(input: String) {
        ScopeId.parse(input)
    }

    /**
     * Collection of valid scope identifiers with the combined version
     */
    private fun validScopesCombined() = arrayOf(
            arrayOf("namespace", "scope", "namespace:scope"),
            arrayOf(null, "scope", "scope")
    )

    /**
     * Collection of valid scope identifiers.
     * This is all of the values from validScopesCombined, but only the namespace and scope portions
     */
    private fun validScopes() = validScopesCombined().map { s -> arrayOf(s[0], s[1]) }

    /**
     * Collection of invalid scope identifiers
     */
    private fun invalidScopes() = arrayOf(
        arrayOf("", "scope"),
        arrayOf("namespace", ""),
        arrayOf(null, ""),
        arrayOf("name:space", "scope"),
        arrayOf("namespace", "sc:ope"),
        arrayOf("name:space", "sc:ope"),
        arrayOf("name:space", ""),
        arrayOf("", "sc:ope")
    )

    /**
     * Collection of invalid scope identifiers
     */
    private fun invalidScopesCombined() = invalidScopes().map { s -> arrayOf(s.joinToString(":")) }
}