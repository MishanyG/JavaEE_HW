import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Main {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient((Configuration) new ClientConfig().register(JacksonJsonProvider.class));
        WebTarget webTarget = client.target("http://127.0.0.1:8080/HomeWork_L4/api").path("product");
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        String out = response.readEntity(String.class);
        System.out.println(response.getStatus());
        System.out.println(out);
    }
}
