package de.mosaic4cap.webapp.chefui.services.notification;

/**
 * Created by svenklemmer on 19.09.14.
 * <p/>
 * Simple enum defining some specific types of
 * notifications with its icon displayed in application
 * notification header
 */
public enum NotificationType {

 DEPLOYMENT("fa fa-yelp"),
 STOREACCOUNT("fa fa-usd");

 private String iconCss;

 NotificationType(String aIconCss) {
	iconCss = aIconCss;
 }

 public String getIconCss() {
	return iconCss;
 }

 public void setIconCss(String aIconCss) {
	iconCss = aIconCss;
 }

 @Override
 public String toString() {
	return iconCss;
 }
}
