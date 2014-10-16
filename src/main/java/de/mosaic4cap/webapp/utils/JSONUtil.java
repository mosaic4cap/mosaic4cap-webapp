package de.mosaic4cap.webapp.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.log4j.Logger;

/**
 * Created by Lobedan on 01.09.2014.
 *
 * Simply wrapps around jackson json mapper
 * it simplyfies its usage
 */
public class JSONUtil {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static Logger logger = Logger.getLogger(JSONUtil.class);

	public static void configure(DeserializationFeature feature, boolean state) {
		OBJECT_MAPPER.configure(feature, state);
	}

	public static String toJson(Object value) throws Exception {
		return OBJECT_MAPPER.writeValueAsString(value);
	}

	public static <T> T fromJson(String json, Class<T> valueType) throws IOException {
		return OBJECT_MAPPER.readValue(json, valueType);
	}

	public static <T> T fromJsonToList(String json, TypeReference<?> valueTypeRef) throws Exception {
		return OBJECT_MAPPER.readValue(json, valueTypeRef);
	}
}
