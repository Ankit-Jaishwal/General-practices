package com.ankit.strings;

import java.util.ArrayList;
import java.util.List;

public class EvaluateExpression {

	static int staticIndex = 0;
	final static char OPEN_PARENTHESIS = '(';
	final static char CLOSE_PARENTHESIS = ')';
	final static char ZERO = '0';
	
	public static void main(String[] args) {
		/*
		 	(+546)
			(*2(-73)4)
			(+3(*52)(-63))
		 * */
		String exp = "(+4(/62)(*62))";
		int output = evaluateExpressionRec(exp);
		
		if (output == Integer.MIN_VALUE) {
			System.out.println("Invalid Expression");
		} else {
			System.out.println(output);
		}
		
	}
	
	public static int evaluateExpressionRec(String exp){
		// if the exp is null or empty String or not starting from OPEN_PARENTHESIS, then its invalid
		if(exp == null || exp.length() == 0 || exp.charAt(staticIndex) != OPEN_PARENTHESIS ){
			return Integer.MIN_VALUE;
		}
		staticIndex++;
		char operator = exp.charAt(staticIndex);
		// The next char after OPEN_PARENTHESIS should a operator else the exp is invalid
		if (!(operator == '+' || operator == '-' || operator == '*' || operator == '/')) {
			return Integer.MIN_VALUE;
		}
		// this list will contain the operands list
		List<Integer> operandsList = new ArrayList<Integer>();
		
		staticIndex++;
		// running the loop till we reach the end, which will point to the CLOSE_PARENTHESIS
		while(staticIndex < exp.length() && exp.charAt(staticIndex) != CLOSE_PARENTHESIS){
			char c = exp.charAt(staticIndex);
			if(c == OPEN_PARENTHESIS) {
				// recursively calling the evaluateExpressionRec(exp) method to evaluate subsequent expression
				int result = evaluateExpressionRec(exp);
				if(result == Integer.MIN_VALUE) return result;
				operandsList.add(result);
				staticIndex++;
				
				//corner case 1 : if the ending parenthesis are not proper, in that scenario this index will be pointing to last index, which won't be the case in general
				if(staticIndex >= exp.length()){
					return Integer.MIN_VALUE;
				}
				c = exp.charAt(staticIndex);
				if(c == OPEN_PARENTHESIS || c == CLOSE_PARENTHESIS) { // this is valid hence continuing the loop
					continue;
				} else if(c<'0' || c > '9'){ // this is invalid, this condition will only occur in invalid exp
					return Integer.MIN_VALUE;
				}
			}
			operandsList.add(c- ZERO);
			staticIndex++;
		}
		
		return evaluate(operator, operandsList);
	}
	
	// This method will evaluate the expression for the incoming list of integers using the operator 
	private static int evaluate(char operator, List<Integer> list){
		int result = list.get(0);
		if(operator == '+'){
			for (int i = 1; i < list.size(); i++) {
				result = result + list.get(i);
			}
		} else if(operator == '-'){
			for (int i = 1; i < list.size(); i++) {
				result = result - list.get(i);
			}
		}else if(operator == '*'){
			for (int i = 1; i < list.size(); i++) {
				result = result * list.get(i);
			}
		}else if(operator == '/'){
			for (int i = 1; i < list.size(); i++) {
				result = result / list.get(i);
			}
		}
		return result;
	}

}
