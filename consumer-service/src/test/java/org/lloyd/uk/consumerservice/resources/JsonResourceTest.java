package org.lloyd.uk.consumerservice.resources;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import junit.framework.TestCase;

/**
 * The class <code>JsonResourceTest</code> contains tests for the class {@link
 * <code>JsonResource</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 7/3/17 2:46 PM
 *
 * @author jsreen
 *
 * @version $Revision$
 */
@RunWith(SpringRunner.class)
@WebMvcTest(JsonResource.class)
public class JsonResourceTest extends TestCase {

	@Autowired
	private MockMvc mvc;

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
	 * @throws Exception 
	 */
	@Test
	public void testGetJSON() throws Exception {
		this.mvc.perform(get("/json/").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	/**
	 * Run the ResponseEntity<JSONObject> getJSONByUrl(String) method test
	 * @throws Exception 
	 */
	@Test
	public void testGetJSONByUrl() throws Exception {
		this.mvc.perform(get("/json/path?param1=http://gturnquist-quoters.cfapps.io/api/random").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
	
	@Test
	public void getJsonShouldReturnMakeAndModel() throws Exception {
		this.mvc.perform(get("/json/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
	
	@Test
	public void getGetJsonUrlShouldReturnNotFound() throws Exception {
		this.mvc.perform(get("/json")).andExpect(status().isNotFound());
	}
	
	@Test
	public void getVehicleWhenUserNotFoundShouldReturnNotFound_1() throws Exception {
		this.mvc.perform(get("/json/paths/?param1=http://gturnquist-quoters.cfapps.io/api/random")).andExpect(status().isNotFound());
	}
}