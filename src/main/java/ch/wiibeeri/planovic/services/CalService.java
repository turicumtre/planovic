package ch.wiibeeri.planovic.services;
import java.time.*;
import java.util.*;

import org.springframework.stereotype.Service;

import ch.wiibeeri.planovic.datatypes.frontend.*;

@Service
public class CalService {
	public YearData allOfYear(int year) {
		List<DayData> days = new ArrayList<>(365);

		LocalDate firstDay = Year.of(year).atDay(1);
		LocalDate lastDay =firstDay.plusYears(1).minusDays(1);

		for (LocalDate i = firstDay; !i.isAfter(lastDay); i = i.plusDays(1)) {
            days.add(new DayData(i.getMonthValue(), i.getDayOfMonth(), i.getDayOfWeek().getValue(), null));
        }

		return new YearData(year, days);
	}
}
