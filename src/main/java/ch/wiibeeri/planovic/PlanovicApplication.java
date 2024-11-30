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
		pocDatabase();
	}

	private static void pocDatabase() {
		MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "planovic");
		mongoOps.insert(new Entry("Patrick", 1989, 11, 24));

		Entry entry = mongoOps.query(Entry.class).matching(where("name").is("Patrick")).firstValue();
		entry.name+=" Lieberherr";
		//mongoOps.remove(entry);
		//mongoOps.insert(entry);
		mongoOps.findAndReplace(Query.query(Criteria.where("_id").is(entry.id)), entry);
		entry = mongoOps.query(Entry.class).matching(where("_id").is(entry.id)).firstValue();
		System.out.println(entry.name);

		//mongoOps.dropCollection("Entry");
	}

}
