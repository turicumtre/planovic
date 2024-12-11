package ch.wiibeeri.planovic.datatypes.frontend;

import java.util.List;

public record YearData(
	int year,
	int currentDayOfYear,
	List<DayData> days
) {
}
