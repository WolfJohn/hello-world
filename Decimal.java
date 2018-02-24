package com.java.functionAPI;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Decimal {

	public static void main(String[] args) {
		BigDecimal d = new BigDecimal(12.4569);
		
		System.out.println(d.divide(new BigDecimal(10), 5, RoundingMode.DOWN));
	}
}
