package ch.wiibeeri.planovic.services;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.wiibeeri.planovic.datatypes.db.Entry;
import ch.wiibeeri.planovic.datatypes.frontend.*;
import ch.wiibeeri.planovic.repositories.EntryRepository;

@Service
public class CalService {
	@Autowired
	private EntryRepository entryRepository;

	private record Day(int day, int month) {
	}

	public YearData allOfYear(int year) {
		List<DayData> days = new ArrayList<>(365);

		LocalDate firstDay = Year.of(year).atDay(1);
		LocalDate lastDay = firstDay.plusYears(1).minusDays(1);

		LocalDate now = LocalDate.now();

		Map<Day, Entry> entryByDay = entryRepository.allOfYear(year).stream() //
			.collect(Collectors.toMap( //
				e -> new Day(e.day, e.month), //
				e -> e //
			));

		for (LocalDate i = firstDay; !i.isAfter(lastDay); i = i.plusDays(1)) {
			Entry entry = entryByDay.get(new Day(i.getDayOfMonth(), i.getMonthValue()));
			String text = entry!=null?entry.name:null;
			boolean inPast = i.isBefore(now);
			days.add(new DayData(i.getMonthValue(), i.getDayOfMonth(), i.getDayOfWeek().getValue(), i.getDayOfYear(), inPast, text));
		}

		return new YearData(year, now.getDayOfYear(), days);
	}

	public DayData update(UpdateRequest ur) {
		List<Entry> entries = entryRepository.date(ur.y(), ur.m(), ur.d());
		if(entries.size()>1){
			throw new RuntimeException("More than 1 entry for "+ur.d()+"/"+ur.m()+"/"+ur.y());
		}
		Entry entry = entries.isEmpty()?new Entry(ur.text(), ur.y(), ur.m(), ur.d()):entries.get(0);
		entry.name = ur.text();

		if(entry.name!=null && entry.name.isBlank() && entry.id!=null){
			entryRepository.delete(entry);
		}else{
			entryRepository.save(entry);
		}
		return entry.toDayData();
	}
}
