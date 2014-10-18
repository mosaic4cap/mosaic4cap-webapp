package de.mosaic4cap.webapp.stereotypes.enumeration;

/**
 * Created by svenklemmer on 17.10.14.
 *
 * enum to display different enviroments
 * it includes hostnames, ip-adresses and enviroment
 * identifier names
 * default is always a local enviroment
 *
 * TODO: maybe later it will be possible to define different enviroments and there config inside adminui
 */
public enum Enviroment {
  LOCAL("development", "", ""),
  INTEGRATION("integration", "", ""),
  PRODUCTION("production", "", "");

  private String ident;
  private String ipAdress;
  private String hostName;

  Enviroment(String aIdent, String aIpAdress, String aHostName) {
    ident = aIdent;
    ipAdress = aIpAdress;
    hostName = aHostName;
  }

  public String getIpAdress() {

    return ipAdress;
  }

  public void setIpAdress(String aIpAdress) {
    ipAdress = aIpAdress;
  }

  public String getHostName() {
    return hostName;
  }

  public void setHostName(String aHostName) {
    hostName = aHostName;
  }

  public String getIdent() {

    return ident;
  }

  public void setIdent(String aIdent) {
    ident = aIdent;
  }

  @Override
  public String toString() {
    return "Enviroment{" +
           "ident='" + ident + '\'' +
           ", ipAdress='" + ipAdress + '\'' +
           ", hostName='" + hostName + '\'' +
           '}';
  }
}
