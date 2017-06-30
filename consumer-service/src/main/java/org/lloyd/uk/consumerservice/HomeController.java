/**
 * 
 */
package org.lloyd.uk.consumerservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jsreen
 *
 */
@Controller
public class HomeController {
	@RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello World";
    }
}
