
package cn.fiona.pet.account.restclient;


import cn.fiona.pet.account.entity.From;
import cn.fiona.pet.account.facade.AuthRestService;
import cn.fiona.pet.account.facade.LoginVO;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author baiqw
 */
public class MenuClient {
    @Test
  public void testMenu() {
      final String port = "8828";
      menu("http://172.17.191.191:" + port + "/api/v2/menus/", MediaType.APPLICATION_JSON_TYPE);
  }

  private void menu(String url, MediaType mediaType) {
      System.out.println("menu via " + url);

      Client client = ClientBuilder.newClient();
      WebTarget target = client.target(url);
      Response response = target.request().header(AuthRestService.HEADER_AUTHORIZATION_KEY, "fc5db3b3-4063-4a12-a511-880ba19e4b58").get();

      try {
          if (response.getStatus() != 200) {
              throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
          }
          System.out.println("Successfully got result: " + response.readEntity(String.class));
      } finally {
          response.close();
          client.close();
      }
  }
}
