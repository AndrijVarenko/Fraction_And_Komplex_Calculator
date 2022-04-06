package Lab_1;

public final class Fraction {
	
	private int a, b, c = 0;
	private double a1 = 0, a2 = 0;
	
	public Fraction(Fraction o){
		this.a = o.a;
		this.b = o.b;
	}
	
	public Fraction (int _a, int _b) {
		int a = 0, b = 0;
		if(((_a < 0) && (_b < 0)) || (_b < 0)) {
			a = (-1) * _a;
			b = (-1) * _b;
		}
		else {
			a = _a;
			b = _b;
		}
		int min = 0;
		int chus = 0, znam = 0;
		if (a < b) 
			min = a;
		else 
			min = b;
		for (int i = 1; i < min; i ++) {
			if ( ((a % i) == 0) && ((b % i) == 0) ) {
				chus = a / i;
				znam = b / i;
			}
		}
		a1 = chus;
		a2 = znam;
		if ((a1 / a2) > 1) {
			this.c = chus / znam;
			chus = chus % znam;
		}
			this.a = chus;
			this.b = znam;
	}

	public Fraction(String fs) {
	try {	
	  StringBuilder sb = new StringBuilder();
	  sb.delete(0, sb.length());
		
	  for(int i=0; i < fs.length(); i++) {
	   char ch = fs.charAt(i);
	   
		if(ch != ' ') {
			sb.append(ch);
		}	
	  }
	   
	  this.a = Integer.parseInt(sb.substring(0, sb.indexOf("/")));
	  this.b = Integer.parseInt(sb.substring((sb.indexOf("/")+1), sb.length()));
	} 
	catch (java.lang.NumberFormatException|java.lang.ArithmeticException e) {
		System.out.println("Помилка введення! Повторіть введення!");
	}
	}
	
	private int evkl(int a, int b) {
		if (a == 0) 
			return b;

			while (b != 0) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
			
	  return a;		
	}
	
	public int getZnam () {
		return this.a;
	}

	public int getChus () {
		return this.b;
	}
	
	public Fraction mull (Fraction o) {
	  return new Fraction(this.a *o.a, this.b * o.b);
	}
	
	public Fraction add(Fraction o) {
		int zn = (this.b * o.b) / evkl(this.b, o.b);
		int x1, x2;
		x1 = zn / this.b;
		x2 = zn / o.b;
		int chys = this.a * x1 + o.a * x2;
	  return new Fraction(chys, zn);
	}
	
	public Fraction sub(Fraction o) {
		int zn = (this.b * o.b) / evkl(this.b, o.b);
		int x1, x2;
		x1 = zn / this.b;
		x2 = zn / o.b;
		int chys = this.a * x1 - o.a * x2;
	  return new Fraction(chys, zn);
	}
	
	public Fraction div(Fraction o) {
	  return new Fraction(this.a*o.b, this.b*o.a);
	}
	
	@Override
	public String toString(){
		if(this.a == this.b) {
			return "Result = 1";	
		}
		else {
			if (c != 0) 
				return "Result = " + String.valueOf(c) + " " + String.valueOf(a) + "/" + String.valueOf(b);
			else
				return "Result = " + String.valueOf(a) + "/" + String.valueOf(b);	
		}
	}
}
