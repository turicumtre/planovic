package ch.wiibeeri.planovic.datatypes;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Entry")
public class Entry {
    public ObjectId id = new ObjectId();

    public String name;

    public int year, month, day;

    public Entry(String name, int year, int month, int day){
        this.name=name;
        this.year=year;
        this.month = month;
        this.day = day;
    }
}