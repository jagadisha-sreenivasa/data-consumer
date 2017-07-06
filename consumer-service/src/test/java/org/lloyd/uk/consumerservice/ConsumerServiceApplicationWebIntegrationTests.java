package org.lloyd.uk.consumerservice;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lloyd.uk.consumerservice.ConsumerServiceApplication;
import org.lloyd.uk.consumerservice.model.RandomJson;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The class <code>ConsumerServiceApplicationWebIntegrationTests</code>
 * contains tests for the class {@link <code>ConsumerServiceApplication</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 7/3/17 12:10 PM
 *
 * @author jsreen
 *
 * @version $Revision$
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class ConsumerServiceApplicationWebIntegrationTests extends TestCase {
	
	@Autowired
	private TestRestTemplate restTemplate;

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
	
	@Test
	public void test() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("/", String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).isEqualTo("Hello World");
	}
	
	@Test
	public void testRandomJson() {
		ResponseEntity<RandomJson> entity = this.restTemplate.getForEntity("/json/random", RandomJson.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}