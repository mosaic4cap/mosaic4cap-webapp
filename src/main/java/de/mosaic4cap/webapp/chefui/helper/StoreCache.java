package de.mosaic4cap.webapp.chefui.helper;

import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 10.10.14.
 */
public final class StoreCache {
  private static final Logger LOGGER = Logger.getLogger(StoreCache.class);
  protected static StoreCache unique = null;
  private long storeId = -1;

  private StoreCache() {
  }

  public static StoreCache get() {
    if (unique == null) {
      unique = new StoreCache();
    }
    return unique;
  }

  public long getStoreId() {
    LOGGER.debug("returning storeId " + storeId);
    return storeId;
  }

  public void setStoreId(long aStoreId) {
    if (storeId != aStoreId) {
      LOGGER.debug("Setting storeId to " + storeId);
      storeId = aStoreId;
    } else {
      LOGGER.debug("No need to change storeId from " + storeId + " to " + aStoreId);
    }
  }
}
