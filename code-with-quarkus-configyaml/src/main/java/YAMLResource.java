import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("yaml")
public class YAMLResource {

    @ConfigProperty(name = "greeting.message", defaultValue = "Default value")
    String message;

    @GET
    public String getYaml() {
        return message;
    }
}
