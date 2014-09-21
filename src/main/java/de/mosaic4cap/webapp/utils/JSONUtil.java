package de.mosaic4cap.webapp.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by Lobedan on 01.09.2014.
 */
public class JSONUtil {
  private static Logger logger = Logger.getLogger(JSONUtil.class);

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public static void configure(DeserializationFeature feature, boolean state) {
    OBJECT_MAPPER.configure(feature, state);
  }

  public static String toJSON(Object value) throws Exception {
    return OBJECT_MAPPER.writeValueAsString(value);
  }

  public static <T> T fromJSON(String json, Class<T> valueType) throws IOException {
    return OBJECT_MAPPER.readValue(json, valueType);
  }
}