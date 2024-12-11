package ch.wiibeeri.planovic.repositories;

import ch.wiibeeri.planovic.datatypes.db.Entry;
import ch.wiibeeri.planovic.datatypes.frontend.DayData;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EntryRepository extends MongoRepository<Entry, String> {
    @Query("{ 'year': ?0 }")
    List<Entry> allOfYear(int year);

    @Query("{ 'year': ?0, 'month': ?1, 'day': ?2 }")
    List<Entry> date(int y, int m, int d);
}
