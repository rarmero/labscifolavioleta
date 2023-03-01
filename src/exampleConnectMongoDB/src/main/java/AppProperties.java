import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("app")
public class AppProperties {

private String uri;
private String database;

    public String getUri() {
        return uri;
    }

    public String getDatabase() {
        return database;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
