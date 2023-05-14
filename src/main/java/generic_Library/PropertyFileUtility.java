package generic_Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class contains reusable methods for actions performed on property file
 * 
 * @author yashu
 *
 */
public class PropertyFileUtility {

	private Properties property;

	/**
	 * this method is used to initilize property file
	 * 
	 * @param filepath
	 * @param Key
	 */
	public void propertyconfg(String filepath) {
		FileInputStream fis = null;
		try {

			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * this method is used to fetch the value from property file based on key
	 * 
	 * @param value
	 * @return
	 */

	public String fetchproperty(String key) {

		return property.getProperty(key);
	}

	/**
	 * this method is used to write the data into property file
	 * 
	 * @param key
	 * @param value
	 * @param filePath
	 * @param message
	 */
	public void setDataToprorprty(String key, String value, String filePath, String message) {

		property.put(key, value);

		try {
			property.store(new FileOutputStream(filePath), message);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
