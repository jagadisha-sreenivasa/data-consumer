package org.lloyd.uk.consumerservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ConsumerServiceApplicationTests {
	
	private final TestRestTemplate restTemplate = new TestRestTemplate();
	
	@Value("${local.server.port}")
	private int port;

	@Autowired
	private ApplicationContext context;
		
	@Test
	public void contextLoads() {
		assertThat(this.context).isNotNull();
	}
	
	@Test
	public void restApiIsAvailable() throws Exception {
		ResponseEntity<JSONObject> entity = this.restTemplate.getForEntity("http://localhost:" + port + "/json/", JSONObject.class);
	    assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test
	public void restApiProcessDefinitions() throws Exception {
		ResponseEntity<JSONObject> entity = this.restTemplate.getForEntity("http://localhost:" + port + "/json/path?param1=http://gturnquist-quoters.cfapps.io/api/random",
	    		JSONObject.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
}