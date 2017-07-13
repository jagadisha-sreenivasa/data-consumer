/**
 * 
 */
package org.lloyd.uk.consumerservice.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author jsreen
 *
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	public SecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }
}