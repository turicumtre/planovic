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

		Map<Day, Entry> entryByDay = entryRepository.allOfYear(year).stream() //
			.collect(Collectors.toMap( //
				e -> new Day(e.day, e.month), //
				e -> e //
			));

		for (LocalDate i = firstDay; !i.isAfter(lastDay); i = i.plusDays(1)) {
			Entry entry = entryByDay.get(new Day(i.getDayOfMonth(), i.getMonthValue()));
			String text = entry!=null?entry.name:null;
			days.add(new DayData(i.getMonthValue(), i.getDayOfMonth(), i.getDayOfWeek().getValue(), text));
		}

		return new YearData(year, days);
	}
}
