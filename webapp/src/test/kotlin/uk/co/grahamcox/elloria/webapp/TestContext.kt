package uk.co.grahamcox.elloria.webapp

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Profile
import uk.co.grahamcox.elloria.spring.CoreContext
import uk.co.grahamcox.elloria.webapp.spring.ServletContext
import java.time.Clock
import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * Root configuration for the Spring Context to use for tests
 */
@Configuration
@Import(
    CoreContext::class,
    ServletContext::class
)
open class TestContext {
    /** The timezone to use */
    private val UTC_TIMEZONE = ZoneId.of("UTC")

    /** The clock to use for the tests */
    @Bean
    @Profile("test")
    open fun clock() = Clock.fixed(ZonedDateTime.of(2015, 11, 26, 7, 50, 25, 0, UTC_TIMEZONE).toInstant(),
            UTC_TIMEZONE)
}