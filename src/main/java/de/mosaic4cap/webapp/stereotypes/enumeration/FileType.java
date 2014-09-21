package de.mosaic.commons.enumeration;

/**
 * Created by svenklemmer on 13.09.14.
 *
 * Simple enum to define commons filetypes
 * TODO: Move to commons (Github #23)
 */
public enum FileType {

  /* textual file extensions */
  JSON(".json", "JSON Datei"),
  PROPERTIES(".properties", "Einstellungen"),
  SQL(".sql", "SQL Querys"),
  TXT(".txt", "Standard Textformat"),

  /* programm language extensions */
  JAVA(".java", "Java SourceCode"),
  GROOVY(".groovy", "Groovy SourceCode"),
  PHP(".php", "PHP SourceCode"),

  /* image extensions */
  JPG(".jpg", "Standard Bildformat"),
  PNG(".png", "Bildformat mit transparenz"),
  GIF(".gif", "Animierte Bilder"),

  /* archive extensions */
  ZIP(".zip", "Compressed Archive");

  private String extension;
  private String description;

  FileType(String aExtension, String aDescription) {
    extension = aExtension;
    description = aDescription;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String aDescription) {
    description = aDescription;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String aExtension) {
    extension = aExtension;
  }

  @Override
  public String toString() {
    return extension;
  }
}
