package de.mosaic4cap.webapp.utils;

import java.util.zip.ZipInputStream;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by svenklemmer on 16.10.14.
 */
@RunWith(JUnit4.class)
public class ZipUtilTest {
  private static final Logger LOGGER = Logger.getLogger(ZipUtilTest.class);

  private String zipUrl = "https://github.com/Lobedan/angular-d3/archive/master.zip";

  @Test
  public void testCanDownloadZipFile() throws Exception {
    String filePath = ZipUtil.downloadZipFile(zipUrl, "file.zip");
    assertThat(filePath, is(notNullValue()));
    assertThat(filePath.length(), is(greaterThan(0)));
  }

  @Test
  public void testCanReadZipFile() throws Exception {
    String filePath = ZipUtil.downloadZipFile(zipUrl, "file.zip");
    assertThat(filePath, is(notNullValue()));
    assertThat(filePath.length(), is(greaterThan(0)));

    ZipInputStream zipInputStream = ZipUtil.readZipFile(filePath);
    zipInputStream.close();
  }

  @Test
  public void testCanDeleteZipFile() throws Exception {
    ZipUtil.deleteLocalZipFile(ZipUtil.downloadZipFile(zipUrl, "file.zip"));
  }
}
