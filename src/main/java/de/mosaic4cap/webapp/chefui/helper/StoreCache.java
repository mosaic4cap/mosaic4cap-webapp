package de.mosaic4cap.webapp.chefui.helper;

import org.apache.log4j.Logger;

/**
 * Created by svenklemmer on 10.10.14.
 */
public final class StoreCache {
  private static final Logger LOGGER = Logger.getLogger(StoreCache.class);
  protected static StoreCache unique = null;
  private long storeId;

  private StoreCache() {
  }

  public static StoreCache get() {
    if (unique == null) {
      unique = new StoreCache();
    }
    return unique;
  }

  public long getStoreId() {
    LOGGER.debug("returning storeId" + storeId);
    if (storeId > 0) {
      return storeId;
    } else {
      return -1;
    }
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
