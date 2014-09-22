package de.mosaic4cap.webapp.boot;

import org.apache.log4j.Logger;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * Created by svenklemmer on 11.09.14.
 * <p/>
 * Checks the actual memory situation on the server
 * if memory is greater than 20MB than helth.up is displayed else its down
 * See Issue #1
 */
@Component
public class MemoryHealtIndicator extends AbstractHealthIndicator {
 private static final Logger LOGGER = Logger.getLogger(MemoryHealtIndicator.class);

 @Override
 protected void doHealthCheck(Health.Builder builder) throws Exception {

 }
}
