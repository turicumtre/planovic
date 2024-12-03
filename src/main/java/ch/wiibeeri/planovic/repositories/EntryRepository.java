package ch.wiibeeri.planovic.repositories;

import ch.wiibeeri.planovic.datatypes.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EntryRepository extends MongoRepository<Entry, String> {
    @Query("{ 'year': ?0 }")
    List<Entry> allOfYear(int year);
}
