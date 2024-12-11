package ch.wiibeeri.planovic.datatypes.frontend;

public record DayData(
	int m, // month
	int d, // day
	int dow, // day of week
	int doy, // day of year
	String text // text that the user entered, or null
) {
}
