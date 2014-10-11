package de.mosaic4cap.webapp.stereotypes;

import org.apache.log4j.Logger;

import de.mosaic4cap.webapp.core.Response;

/**
 * Created by svenklemmer on 09.10.14.
 *
 * Standard Post Response
 */
public class PostResponse implements Response {
  private static final Logger LOGGER = Logger.getLogger(PostResponse.class);

  private String message;

  public PostResponse() {
  }

  public PostResponse(String aMessage) {
    message = aMessage;
  }

  @Override
  public String toString() {
    return message;
  }
}
