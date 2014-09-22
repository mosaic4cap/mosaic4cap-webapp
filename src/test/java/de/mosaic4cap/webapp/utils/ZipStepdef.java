package de.mosaic4cap.webapp.utils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.util.zip.ZipInputStream;

/**
 * Created by Lobedan on 09.09.2014.
 */
public class ZipStepdef {
    private static Logger logger = Logger.getLogger(ZipStepdef.class);
    @Value("${storage.tmpDir}")
    private String filepath;

    private String zipUrl;
    private ZipInputStream zipInputStream;

    @Given("^a zipUrl \"([^\"]*)\"$")
    public void initZipUrl(String pZipUrl) {
        zipUrl = pZipUrl;
    }

    @Then("it can be downloaded")
    public void downloadZip() throws Exception {
        filepath = ZipUtil.downloadZipFile(zipUrl, "file.zip");
    }

    @And("it can be read as ZipInputStream")
    public void initStream() throws Exception {
        zipInputStream = ZipUtil.readZipFile(filepath);
    }

    @And("delete from local")
    public void deleteZip() throws Exception {
        ZipUtil.deleteLocalZipFile(filepath);
    }
}
