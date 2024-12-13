package ch.wiibeeri.planovic.datatypes.db;

import java.time.LocalDate;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ch.wiibeeri.planovic.datatypes.frontend.DayData;

@Document(collection="Entry")
public class Entry {
    @Id
    public ObjectId id = new ObjectId();

    public String name;

    public int year, month, day;

    public Entry(String name, int year, int month, int day){
        this.name=name;
        this.year=year;
        this.month = month;
        this.day = day;
    }

    public DayData toDayData(){
        LocalDate date = LocalDate.of(year, month, day);
        return new DayData(month, day, date.getDayOfWeek().getValue(), date.getDayOfYear(), LocalDate.now().isBefore(date), name);
    }
}
