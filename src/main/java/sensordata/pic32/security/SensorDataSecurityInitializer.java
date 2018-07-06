package sensordata.pic32.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SensorDataSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
	
	public SensorDataSecurityInitializer() {
		super(SensorDataSecurityConfiguration.class);
	}
}