package com.java.functionAPI;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RandomDate {

	public static void main(String[] args) {

		System.out.println("${non-futureDate}" + "${non-futureDate}");
		List<String> dates = getDates("${non-futureDate}", "${non-futureDate}");
		for (String string : dates) {
			System.out.println(string);
		}

		System.out.println("${non-futureDate}" + "${futureDate}");
		dates = getDates("${non-futureDate}", "${futureDate}");
		for (String string : dates) {
			System.out.println(string);
		}

		System.out.println("${futureDate}" + "${futureDate}");
		dates = getDates("${futureDate}", "${futureDate}");
		for (String string : dates) {
			System.out.println(string);
		}

		System.out.println("${futureDate}" + "${non-futureDate}");
		dates = getDates("${futureDate}", "${non-futureDate}");
		for (String string : dates) {
			System.out.println(string);
		}

		System.out.println("${non-futureDate}" + "${futureDate}");
		dates = getDates("${non-futureDate}", "${futureDate}");
		for (String string : dates) {
			System.out.println(string);
		}

		System.out.println("${oldDate}" + "${futureDate}");
		dates = getDates("${oldDate}", "${futureDate}");
		for (String string : dates) {
			System.out.println(string);
		}

		System.out.println("${non-futureDate}" + "${oldDate}");
		dates = getDates("${non-futureDate}", "${oldDate}");
		for (String string : dates) {
			System.out.println(string);
		}

		System.out.println("${futureDate}" + "${oldDate}");
		dates = getDates("${futureDate}", "${oldDate}");
		for (String string : dates) {
			System.out.println(string);
		}

		System.out.println("${oldDate}" + "${oldDate}");
		dates = getDates("${oldDate}", "${oldDate}");
		for (String string : dates) {
			System.out.println(string);
		}
	}

	public static List<String> getDates(String dateFromPlaceHolder, String dateToPlaceHolder) {

		List<String> datesList = new ArrayList<>();

		SecureRandom random = new SecureRandom();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

		if (dateFromPlaceHolder.equals("${non-futureDate}") && dateToPlaceHolder.equals("${non-futureDate}")) {
			int minDate = (int) LocalDate.of(1994, 1, 1).toEpochDay();
			int maxDate = (int) LocalDate.now().toEpochDay();

			int randomEpochDa1 = minDate + random.nextInt(maxDate - minDate);
			int randomEpochDa2 = minDate + random.nextInt(maxDate - minDate);

			LocalDate dateFrom = LocalDate
					.ofEpochDay((long) (randomEpochDa1 <= randomEpochDa2 ? randomEpochDa1 : randomEpochDa2));
			LocalDate dateTo = LocalDate
					.ofEpochDay((long) (randomEpochDa1 >= randomEpochDa2 ? randomEpochDa1 : randomEpochDa2));

			datesList.add(dateFrom.format(dateFormatter));
			datesList.add(dateTo.format(dateFormatter));
		} else {
			datesList.add(getDateByPlaceHolder(dateFromPlaceHolder));
			datesList.add(getDateByPlaceHolder(dateToPlaceHolder));
		}

		return datesList;
	}

	public static String getDateByPlaceHolder(String placeHolder) {
		SecureRandom random = new SecureRandom();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

		if (placeHolder.equals("null") || placeHolder == null) {
			return null;
		} else if (placeHolder.equals("${futureDate}")) {

			int minDate = (int) LocalDate.now().toEpochDay() + 1;
			int maxDate = minDate + 1000;

			int randomEpochDay = minDate + random.nextInt(maxDate - minDate);

			LocalDate randomFutureDate = LocalDate.ofEpochDay((long) randomEpochDay);

			return randomFutureDate.format(dateFormatter);
		} else if (placeHolder.equals("${oldDate}")) {

			int minDate = (int) LocalDate.of(1970, 1, 1).toEpochDay();
			int maxDate = (int) LocalDate.of(1993, 12, 31).toEpochDay();

			int randomEpochDay = minDate + random.nextInt(maxDate - minDate);

			LocalDate randomOldDate = LocalDate.ofEpochDay((long) randomEpochDay);

			return randomOldDate.format(dateFormatter);
		} else if (placeHolder.equals("${non-futureDate}")) {

			int minDate = (int) LocalDate.of(1994, 1, 1).toEpochDay();
			int maxDate = (int) LocalDate.now().toEpochDay();

			int randomEpochDay = minDate + random.nextInt(maxDate - minDate);

			LocalDate randomOldDate = LocalDate.ofEpochDay((long) randomEpochDay);

			return randomOldDate.format(dateFormatter);
		}

		throw new IllegalStateException("Can not create random date for given placeHolder -> " + placeHolder);
	}

	public static int findMissingNumberFroArray(int... intArray) {
		int counter = 0;
		int actualSum = 0;
		int expectedSum = 0;

		while (counter < intArray.length) {
			actualSum += intArray[counter];

			counter++;

			expectedSum += counter;
		}
		return expectedSum + (counter + 1) - actualSum;
	}

}