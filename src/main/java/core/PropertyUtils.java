package core;

import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by AnilKumarVerma
 *
 * <p>This class is used for reading property values from resources/properties file under resources
 */
public class PropertyUtils {
  private static Properties props = new Properties();

  PropertyUtils(String path) {
    loadPropertyFile(path);
  }

  String getProperty(String propertyKey) {
    String propertyValue = props.getProperty(propertyKey.trim());

    if (propertyValue == null || propertyValue.trim().length() == 0) {
      System.out.println("Unable to read property !!");
    }

    return propertyValue;
  }

  private void loadPropertyFile(String propertyFileName) {
    try {
      props.load(new FileInputStream(propertyFileName));
    } catch (IOException e) {
      Assert.fail("Unable to load file!", e);
    }
  }

  public void setProperty(String propertyKey, String value) {
    props.setProperty(propertyKey, value);
  }
}
