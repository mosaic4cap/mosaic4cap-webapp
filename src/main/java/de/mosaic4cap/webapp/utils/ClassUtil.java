package de.mosaic4cap.webapp.utils;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by svenklemmer on 13.09.14.
 *
 * Simple helper class for loading classes and methods by there names
 * TODO: Need to move to Commons (#24)
 */
@SuppressWarnings("unchecked")
public class ClassUtil {
  private static Logger logger = Logger.getLogger(ClassUtil.class);

  public static List<Method> getDelclaredMethods(String className) throws Exception {
    return Arrays.asList(loadClass(className).getDeclaredMethods());
  }

  public static Method getMethodByName(String className, String methodName) throws Exception {
    return getMethodByName(loadClass(className), methodName);
  }

  public static Method getMethodByName(Class clazz, String methodname) throws Exception {
    return clazz.getMethod(methodname);
  }

  /**
   * Simple helper method to avoid long class names
   * @param className
   * @return
   * @throws ClassNotFoundException
   */
  public static Class loadClass(String className) throws ClassNotFoundException {
    return Class.forName(className);
  }
}
