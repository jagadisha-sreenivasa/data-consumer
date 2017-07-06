package org.lloyd.uk.consumerservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ConsumerServiceApplicationTests extends TestCase {
	
	private final TestRestTemplate restTemplate = new TestRestTemplate();
	
	@Value("${local.server.port}")
	private int port;

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private MockMvc mvc;

	private final ObjectMapper objectMapper = new ObjectMapper();

	private HttpEntity httpEntity;
	
	/**
	 * Perform pre-test initialization
	 *
	 * @throws Exception
	 *
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		String header = "Basic " + new String(Base64.encodeBase64String("Leel:Elec".getBytes()));
		MvcResult result = this.mvc
				.perform(post("/oauth/token").header("Authorization", header)
						.param("grant_type", "password").param("scope", "read")
						.param("username", "jags").param("password", "Sr33n!"))
				.andExpect(status().isOk()).andDo(print()).andReturn();
		Object accessToken = this.objectMapper
				.readValue(result.getResponse().getContentAsString(), Map.class)
				.get("access_token");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+accessToken);

		httpEntity = new HttpEntity<String>("parameters", headers);
	}
	
	@Test
	public void contextLoads() {
		assertThat(this.context).isNotNull();
	}
	
	@Test
	public void restApiIsAvailable() throws Exception {
		ResponseEntity<JSONObject> entity = this.restTemplate.exchange("http://localhost:" + port + "/json/", HttpMethod.GET, httpEntity,  JSONObject.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
	
	@Test
	public void restApiIsAvailable_1() throws Exception {
		ResponseEntity<JSONObject> entity = this.restTemplate.getForEntity("http://localhost:" + port + "/json/", JSONObject.class);
	    assertEquals(HttpStatus.UNAUTHORIZED, entity.getStatusCode());
	}

	@Test
	public void restApiProcessDefinitions() throws Exception {
        ResponseEntity<JSONObject> entity = restTemplate.exchange("http://localhost:" + port + "/json/path?param1=http://gturnquist-quoters.cfapps.io/api/random", HttpMethod.GET, httpEntity, JSONObject.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
	
	@Test
	public void restApiProcessDefinitions_1() throws Exception {
		ResponseEntity<JSONObject> entity = this.restTemplate.getForEntity("http://localhost:" + port + "/json/path?param1=http://gturnquist-quoters.cfapps.io/api/random",
	    		JSONObject.class);
		assertEquals(HttpStatus.UNAUTHORIZED, entity.getStatusCode());
	}
}