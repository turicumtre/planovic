package ch.wiibeeri.planovic.datatypes.frontend;

import java.util.List;

public record YearData(
	int year,
	List<DayData> days
) {
}
