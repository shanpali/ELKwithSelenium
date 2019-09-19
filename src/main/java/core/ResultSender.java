package core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;

public class ResultSender {

  private static final ObjectMapper OM = new ObjectMapper();
  private static final String CONTENT_TYPE = "Content-Type";
  private static final String CONTENT_TYPE_VALUE = "application/json";
  private PropertyUtils propertyUtils;

  public ResultSender() {
    this.propertyUtils =
        new PropertyUtils(
            System.getProperty("user.dir") + "/src/main/resources/configuration.properties");
  }

  public void send(final TestStatus testStatus) {
    try {

      String elasticSearchUrl = propertyUtils.getProperty("ELASTIC_SEARCH_URL");
      System.out.println("Elastic Search url is: " +  elasticSearchUrl);
      Unirest.post(elasticSearchUrl)
          .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
          .body(OM.writeValueAsString(testStatus))
          .asJson();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
