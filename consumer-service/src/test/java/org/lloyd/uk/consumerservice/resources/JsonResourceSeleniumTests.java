package org.lloyd.uk.consumerservice.resources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;

/**
 * The class <code>JsonResourceSeleniumTests</code> contains tests for the
 * class {@link <code>JsonResource</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 7/3/17 12:51 PM
 *
 * @author jsreen
 *
 * @version $Revision$
 */
@RunWith(SpringRunner.class)
@WebMvcTest(JsonResource.class)
public class JsonResourceSeleniumTests extends TestCase {
	
	@Autowired
	private WebDriver webDriver;

	/**
	 * Perform pre-test initialization
	 *
	 * @throws Exception
	 *
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		// Add additional set up code here
	}

	/**
	 * Perform post-test clean up
	 *
	 * @throws Exception
	 *
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		// Add additional tear down code here
	}

	/**
	 * Run the ResponseEntity<JSONObject> getJSON() method test
	 */
	@Test
	public void testGetJSON() {
		
		this.webDriver.get("/json/");
	}

	/**
	 * Run the ResponseEntity<JSONObject> getJSONByUrl(String) method test
	 */
	@Test
	public void testGetJSONByUrl() {
		// add test code here
		this.webDriver.get("/json/path?param1=http://gturnquist-quoters.cfapps.io/api/random");
		assertTrue(true);
	}
	
	/**
	 * Run the ResponseEntity<RandomJson> randomJSON() method test
	 */
	@Test
	public void testGetRandomJsonN() {
		
		this.webDriver.get("/json/random");
	}
	
}