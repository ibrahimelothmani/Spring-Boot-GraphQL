package ibrahim.GraphQL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQlApplication {

	private static final Logger LOG = LoggerFactory.getLogger(GraphQlApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
		LOG.info("GraphQlApplication started successfully");
	}

}
