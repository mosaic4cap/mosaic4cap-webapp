package de.mosaic4cap.webapp.core;

import java.util.List;

import org.apache.log4j.Logger;

import de.mosaic4cap.webapp.stereotypes.PostResponse;

/**
 * Created by svenklemmer on 09.10.14.
 * <p>
 * Builder for creating standard response messages for get, post, put and delete
 * request methods
 * can also be used to display exceptions on a normal controller
 * Builder is marked with {@link de.mosaic4cap.webapp.core.Builder} to be available by springs autowire magic
 */
@Builder
public class ResponseBuilder implements IResponseBuilder {
  private static final Logger LOGGER = Logger.getLogger(ResponseBuilder.class);

  private Response object;
  private List objectList;

  public ResponseBuilder setListObjects(List aObjectList) {
    this.objectList = aObjectList;
    return this;
  }

  public ResponseBuilder getResponse() {
    this.object = new PostResponse();
    return this;
  }

  public ResponseBuilder postResponse() {
    StringBuilder sb = new StringBuilder();
    if (objectList != null) {
      sb.append("Received Objectlist ").append("with ").append(objectList.size()).append(" Elements");
      sb.append("\n").append(objectList);
    }
      this.object = new PostResponse(sb.toString());
      return this;
    }

  public ResponseBuilder putResponse() {
    this.object = new PostResponse();
    return this;
  }

  public ResponseBuilder deleteResponse() {
    this.object = new PostResponse();
    return this;
  }

  public Response build() {
    return this.object;
  }
}
