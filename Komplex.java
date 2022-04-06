package Lab_1;

public class Komplex {
	
	private final float a, b;
	
	public Komplex(float _a, float _b){
		this.a = _a;
		this.b = _b;
	}
	
	public Komplex(Komplex o){
		this.a = o.a;
		this.b = o.b;
	}
	
	public Komplex(String fs){
		  StringBuilder sb = new StringBuilder();
		  int p [] = new int [2];
		  int pos = 0;
		  
		  int s = 0;
		  
		  sb.delete(0, sb.length());
			
		  for(int i=0; i < fs.length(); i++) {
		   char ch = fs.charAt(i);
		   
			if(ch != ' ') {
				sb.append(ch);
			}
			
			if (ch == 'i') {
				p[pos] = i;
				pos ++;
			}
			
			if (ch == '*') {
				  s = 1;
			  }
			
		  }
	  
		  this.a = Integer.parseInt(sb.substring(0, (sb.indexOf("i") - 1))); 
		  this.b = Integer.parseInt(sb.substring((sb.indexOf("i")+1+s), sb.length()));
		}
	
	public float getReal () {
		return this.a;
	}

	public float getAplication () {
		return this.b;
	}
	
	public Komplex mull (Komplex o) {
	  return new Komplex((this.a * o.a - this.b * o.b), (this.a * o.b + this.b * o.a));
	}
	
	public Komplex add(Komplex o) {
	  return new Komplex(this.a + o.a, this.b + o.b);
	}
	
	public Komplex sub(Komplex o) {
	  return new Komplex(this.a - o.a, this.b - o.b);
	}
	
	public Komplex div (Komplex o) {
	  return new Komplex((this.a * o.a + this.b * o.b)/(o.a * o.a + o.b * o.b), (this.b * o.a - this.a * o.b)/(o.a * o.a + o.b * o.b));
	}

	@Override
	public String toString(){
		if(this.b == 0) {
			return "Result = " + String.valueOf(a)+ " + " +String.valueOf(b);	
		}
		else {
			if (this.b < 0) 
				return "Result = " + String.valueOf(a)+ " + " + "i * (" +String.valueOf(b) + ")";	
			else 
				return "Result = " + String.valueOf(a)+ " + " + "i * " +String.valueOf(b);	
		}
	}
}