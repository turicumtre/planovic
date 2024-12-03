package ch.wiibeeri.planovic;

import ch.wiibeeri.planovic.datatypes.Entry;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@SpringBootApplication
public class PlanovicApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlanovicApplication.class, args);
	}
}
