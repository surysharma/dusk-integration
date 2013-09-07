package com.hedgebenefits.cucumber;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * This would run the cuke tests
 */
@RunWith(Cucumber.class)
@Cucumber.Options(format = "html:target/report.html")
public class RunCukeTests {
}
