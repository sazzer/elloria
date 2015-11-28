package uk.co.grahamcox.elloria.verification.steps

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.Assert

/**
 * Dummy steps
 */
class DummySteps {
    /** The current value */
    private var value: Int = 0

    /**
     * Set the starting value
     * @param v The value
     */
    @Given("^that I start with (\\d+)$")
    fun startWith(v: Int) {
        value = v;
    }

    /**
     * Add a number to it
     * @param v the value
     */
    @When("^I add (\\d+)$")
    fun add(v: Int) {
        value += v;
    }

    /**
     * Check the answer
     * @param v the value
     */
    @Then("^I get (\\d+)$")
    fun checkAnswer(v: Int) {
        Assert.assertEquals(v, value);
    }
}