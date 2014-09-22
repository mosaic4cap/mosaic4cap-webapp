package de.mosaic4cap.webapp.utils;

import org.apache.log4j.Logger;

/**
 * EnumUtils as helper for enum types
 * <p/>
 * Created by Lobedan on 30.08.2014.
 */
public class EnumUtil {
 private static Logger logger = Logger.getLogger(EnumUtil.class);

 /**
	* A method for all enums to get the enum by its name
	*
	* @param <T>    Enum type
	* @param c      enum type. All enums must be all caps.
	* @param string case insensitive
	* @return corresponding enum
	* @throws IllegalArgumentException if parameters are null
	*/
 public static <T extends Enum<T>> T getEnumFromString(Class<T> c, String string) throws IllegalArgumentException {
	if (c != null && string != null) {
	 return Enum.valueOf(c, string.trim().toUpperCase());
	}
	throw new IllegalArgumentException("Parameters may not be null");
 }
}
