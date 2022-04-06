package Lab_1;

import java.util.Scanner;

public class Lab_1 {
	
	private static boolean ex (String str) {
		boolean res = false;
		for (int i = 0; i < str.length(); i ++) {
			if (str.charAt(i) == 'q')
				res = true;
		}
		return res;
	}
	
	public static void main (String[] args) {
		
		String s;
		
		do {

		boolean a = false;
		Scanner sc = new Scanner (System.in);
		
        s = sc.nextLine();
        
        Calculator.AbstractCalculator calc = null;
        
        Calculator.AbstractCalculator f = new Calculator.FractionCalculator();
        Calculator.AbstractCalculator k = new Calculator.KomplexCalculator();
        
        a = (f.check(s) || k.check(s)) && (f.check(s) != k.check(s));
        
        if ( a ) {
        	if (f.check(s)) {
        		calc = new Calculator.FractionCalculator();
        		if (calc.exec(s) == null) {
        			System.out.println("Помилка введення! Повторіть введення!");
        		}
        		else 
        			System.out.println("Fraction");
        			System.out.println(calc.exec(s));
        	}
        	if (k.check(s)) {
        		calc = new Calculator.KomplexCalculator();
        		if (calc.exec(s) == null) {
        			System.out.println("Помилка введення! Повторіть введення!");
        		}
        		else 
        			System.out.println("Komplex");
        			System.out.println(calc.exec(s));
        	}
        }
        
        else {
        	if (ex(s))
        		break;
        	System.out.println("Помилка введення! Повторіть введення!");
        	continue;
        }
        
		} while(!(ex(s)));
	}
}
