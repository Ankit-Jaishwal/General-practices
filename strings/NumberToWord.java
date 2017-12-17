package com.ankit.strings;

import java.util.HashMap;
import java.util.Map;

public class NumberToWord {
	
	public static String[] lessThan20Arr = {"zero","one ","two ","three ","four ", "five ","six ","seven ","eight ","nine ","ten ",
			"eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen "};
	public static String[] twoDigitArr = {"zero ","ten ","twenty ","thirty ","forty ","fifty ","sixty ","seventy ","eighty ","ninety "};
	public static Map<Integer, Integer> lenToUnitMap = new HashMap<>();
	public static Map<Integer, String> unitToWordMap = new HashMap<>();
	
	static {
		lenToUnitMap.put(3, 100);		// for hundred
		lenToUnitMap.put(4, 1000);		// for Thousand
		lenToUnitMap.put(5, 1000);		// for Thousand
		lenToUnitMap.put(6, 100000);	// for Lac
		lenToUnitMap.put(7, 100000);	// for lac
		lenToUnitMap.put(8, 1000000);	// for Crore
		lenToUnitMap.put(9, 1000000);	// for Crore
		
		unitToWordMap.put(100, "Hundred ");
		unitToWordMap.put(1000, "Thousand ");
		unitToWordMap.put(100000, "Lac ");
		unitToWordMap.put(10000000, "Crore ");
		
	}
	
	public static String getWordFromNumber (Integer n){
		String word = "";
		int inputLen = String.valueOf(n).length();
		
		while(inputLen > 2){
			int divideUnit = lenToUnitMap.get(inputLen);
			int dividend = n/divideUnit;
			n = n%divideUnit;
			word = word + (n == 0 && !word.equals("") ? "and " : "") + getWordForTwoDigit(dividend) + unitToWordMap.get(divideUnit);
			inputLen = String.valueOf(n).length();
		}
			word  = word + (n != 0 ? "and " + getWordForTwoDigit(n) : "") + "only";
		
		return word;
	}
	
	
	private static String getWordForTwoDigit(int unit) {
		String word = "";
		if(unit < 20){
			word = word + lessThan20Arr[unit];
		} else{
			word = word + twoDigitArr[unit/10]+ (unit%10 != 0 ? lessThan20Arr[unit%10] : "");
		}
		return word;
	}


	public static void main(String[] args) {
		System.out.println(getWordFromNumber(5040));

	}

}
