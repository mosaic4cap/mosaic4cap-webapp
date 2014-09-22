package de.mosaic4cap.webapp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Lobedan on 01.09.2014.
 */
public class ZipUtil {
	private static Logger logger = Logger.getLogger(ZipUtil.class);

	@Value("${storage.tmpDir}")
	private static String serverTmpDir;

	/**
	 * Reads in Contents of Zip File
	 *
	 * @param filename of file to read
	 * @return contents as ZipInputStream
	 * @throws Exception
	 */
	public static ZipInputStream readZipFile(String filename) throws Exception {
		return readZipFile(new File(filename));
	}

	/**
	 * Reads in Contents of Zip File
	 *
	 * @param file object of file to read
	 * @return contents as ZipInputStream
	 * @throws Exception
	 */
	public static ZipInputStream readZipFile(File file) throws Exception {
		return new ZipInputStream(new FileInputStream(file));
	}

	/**
	 * Downloads ZipFile to tmp dir from application.properties
	 *
	 * @param url      String url of zip file to download
	 * @param fileName of file on local storage
	 * @return path of file on localstorage
	 * @throws Exception
	 */
	public static String downloadZipFile(String url, String fileName) throws Exception {
		if (url == null) {
			throw new NullPointerException("Url to path may not be NULL");
		}
		return downloadZipFile(new URL(url), fileName);
	}

	/**
	 * Downloads ZipFile to tmp dir from application.properties
	 *
	 * @param url      Url of zip file to download
	 * @param fileName of file on local storage
	 * @return path of file on localstorage
	 * @throws Exception
	 */
	public static String downloadZipFile(URL url, String fileName) throws Exception {
		if (url == null) {
			throw new NullPointerException("Url to path may not be NULL");
		}
		FileUtils.copyURLToFile(url, new File(serverTmpDir + fileName));
		return serverTmpDir + fileName;
	}

	/**
	 * Deletes ZipFile quietly from localStorage path
	 *
	 * @param filename to delete
	 * @throws Exception
	 */
	public static void deleteLocalZipFile(String filename) throws Exception {
		deleteLocalZipFile(new File(filename));
	}

	/**
	 * Deletes ZipFile quietly from localStorage path
	 *
	 * @param file to delete
	 * @throws Exception
	 */
	public static void deleteLocalZipFile(File file) throws Exception {
		FileUtils.deleteQuietly(file);
	}
}
