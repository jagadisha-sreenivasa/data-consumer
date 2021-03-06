/**
 * 
 */
package org.lloyd.uk.consumerservice.resources;

import org.json.simple.JSONObject;
import org.lloyd.uk.consumerservice.model.RandomJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.ApiOperation; 

/**
 * @author jsreen
 *
 */
@CrossOrigin(origins = {"http://data-consumer.us-east-1.elasticbeanstalk.com"}, maxAge = 4800, allowCredentials = "false")
@Controller
@RequestMapping("/json")
public class JsonResource {
	
	private static final Logger log = LoggerFactory.getLogger(JsonResource.class);

	@ApiOperation(value = "Retirve the sample JSON from http://gturnquist-quoters.cfapps.io/api/random",response = JSONObject.class)
	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getJSON() {
		RestTemplate restTemplate = new RestTemplate();
		JSONObject jsonObject = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", JSONObject.class);
        log.info(jsonObject.toString());
        return new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retirve the sample JSON from the given path using query parameter",response = JSONObject.class)
	@RequestMapping(value = "/path", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public ResponseEntity<JSONObject> getJSONByUrl(@RequestParam(value="param1", required=true) String jsonPath) {
		log.info("jsonPath : "  + jsonPath);
		RestTemplate restTemplate = new RestTemplate();
		JSONObject jsonObject = restTemplate.getForObject(jsonPath, JSONObject.class);
		
        log.info(jsonObject.toString());
        return new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retirve Random JSON from http://gturnquist-quoters.cfapps.io/api/random",response = JSONObject.class)
	@RequestMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public ResponseEntity<RandomJson> randomJSON() {
		RestTemplate restTemplate = new RestTemplate();
		RandomJson randomJson = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", RandomJson.class);
        log.info(randomJson.toString());
        return new ResponseEntity<RandomJson>(randomJson, HttpStatus.OK);
	}
}