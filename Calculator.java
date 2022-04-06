package Lab_1;
public class Calculator {
	public static abstract class AbstractCalculator {
		
		protected String expr = null;
		
		AbstractCalculator() {
		}
		
		public abstract boolean check(String s);
		public abstract Object exec(String s);
	}
	
	public static class FractionCalculator extends AbstractCalculator {
	  
		FractionCalculator() {
		}
		
		Object o = new Integer (5);
		
		public boolean check(String s){
			int a = 0;
			for (int i = 0; i < s.length(); i ++) {
				if (s.charAt(i) == '/') {
					a ++;
				}
			}
			if ((a == 2) || (a == 3)) {
				return true;
			}
			else {
				if (a > 3) 
					o = null;
				return false;
			}
		}
		
		public Object ob() {
			return o;
		}
		
		public Object exec(String s) {
			Fraction res = null;
		    int iadd = 0, isub = 0, imull = 0, idiv = 0; 
		    int u = 0;
		    
			StringBuilder sb = new StringBuilder();
			  sb.delete(0, sb.length());
			  for(int i=0; i < s.length(); i++) {
			   char ch = s.charAt(i);
				if(ch != ' ') {
					sb.append(ch);
				}	
			  }
			  
			  String ss = sb.toString();
			  int index = -1, z = 0, z2 = 0;
			  int ind [] = new int [3];
			  int ind2 [] = new int [3];
			  
			  for (int i = 0; i < sb.length(); i ++) {
				  if (sb.charAt(i) != '-') {
					  if (sb.charAt(i) == '+') iadd  ++;
					  if (sb.charAt(i) == '*') imull ++; //u += 1;
					  if (sb.charAt(i) == '/') u ++; //u += 1;
					  if (sb.charAt(i) == ':') idiv ++; //u += 1;
				  }
				  else						   isub  ++; //u += 1;
			  }
			  if(u == 3) idiv ++;
			  int sum = (iadd + imull + idiv + isub);
			  int isub_index_max = -9;

			  for (int i = 0; i < ss.length(); i ++) {
				  if(ss.charAt(i) == '-')
					  isub_index_max = i;
			  }

			  if((sum <= 3) && (isub < 3)) {
				  if((iadd == 1) || ((isub >= 1) && (isub <= 2)) || (idiv == 1) || (imull == 1)){ 
					  if(((ss.indexOf("+") < isub_index_max) || (ss.indexOf("+") == (isub_index_max - 1)) || 
							  (ss.indexOf("+") == (isub_index_max + 1)) ||(ss.indexOf("+") == (isub_index_max - 2)))
							  && (ss.indexOf("+") != -1)) {
						  return res = null;
					  }
					  
					  if((ss.indexOf("*") != -1) && (ss.indexOf("*") == (isub_index_max + 1))) {
						  return res = null;
					  }
					  
					  if((ss.indexOf(":") != -1) && (ss.indexOf(":") == (isub_index_max + 1))) {
						  return res = null;
					  }
					  
					  if((ss.indexOf("/") == (isub_index_max - 1)) || (ss.indexOf("/") == (isub_index_max + 1))) {
						  return res = null;
					  }
 					  
				  if(ss.indexOf("-") == 0) {  //Мінус стоїть напочатку
					  if(iadd == 1) {
						  index = ss.indexOf("+");
							res = new Fraction(ss.substring(0, index));
							res = res.add(new Fraction(ss.substring(index + 1, ss.length())));
					  }
					  if(imull == 1) {
						  index = ss.indexOf("*");
							res = new Fraction(ss.substring(0, index));
							res = res.mull(new Fraction(ss.substring(index + 1, ss.length())));
					  }
					  if((idiv == 1) && (u != 3)) {
						  index = ss.indexOf(":");
							res = new Fraction(ss.substring(0, index));
							res = res.div(new Fraction(ss.substring(index + 1, ss.length())));
					  }
					  if((idiv == 1) && (u == 3)) {
						  z = 0;
						  for(int y = 0; y < ss.length(); y ++)
							  if(ss.charAt(y) == '/') {
								  ind [z] = y;
								  z ++;
							  }
						  index = ind [1];
							res = new Fraction(ss.substring(0, index));
							res = res.div(new Fraction(ss.substring(index + 1, ss.length())));
					  }
					  if(isub == 2) {
						  if((idiv != 0) || (imull != 0)) {
							  if(imull == 1) {
								  index = ss.indexOf("*");
									res = new Fraction(ss.substring(0, index));
									res = res.mull(new Fraction(ss.substring(index + 1, ss.length())));
							  }
							  if((idiv == 1) && (u != 3)) {
								  index = ss.indexOf(":");
									res = new Fraction(ss.substring(0, index));
									res = res.div(new Fraction(ss.substring(index + 1, ss.length())));
							  }
							  if((idiv == 1) && (u == 3)) {
								  z = 0;
								  for(int y = 0; y < ss.length(); y ++)
									  if(ss.charAt(y) == '/') {
										  ind [z] = y;
										  z ++;
									  }
								  index = ind [1];
									res = new Fraction(ss.substring(0, index));
									res = res.div(new Fraction(ss.substring(index + 1, ss.length())));
							  }
						  } else {
						  for(int y = 0; y < ss.length(); y ++)
							  if(ss.charAt(y) == '-') {
								  ind2 [z2] = y;
								  z2 ++;
							  }
						  index = ind2 [1];
							res = new Fraction(ss.substring(0, index));
							res = res.sub(new Fraction(ss.substring(index + 1, ss.length())));
						  }
					  }
				  } 
				  if (!(ss.indexOf("-") != -1)) {  //Немає мінуса
					  if ((iadd == 1) && (imull == 0) && (idiv == 0) && (isub == 0) && (u == 2)) {
						  index = ss.indexOf("+");
							res = new Fraction(ss.substring(0, index));
							res = res.add(new Fraction(ss.substring(index + 1, ss.length())));
					  }
					  if ((iadd == 0) && (imull == 1) && (idiv == 0) && (isub == 0) && (u == 2)) {
						  index = ss.indexOf("*");
							res = new Fraction(ss.substring(0, index));
							res = res.mull(new Fraction(ss.substring(index + 1, ss.length())));
					  }
					  if ((iadd == 0) && (imull == 0) && (idiv == 1) && (isub == 0) && (u != 3)) {
						  index = ss.indexOf(":");
							res = new Fraction(ss.substring(0, index));
							res = res.div(new Fraction(ss.substring(index + 1, ss.length())));
					  }
					  if ((iadd == 0) && (imull == 0) && (idiv == 1) && (isub == 0) && (u == 3)) {
						  z = 0;
						  for(int y = 0; y < ss.length(); y ++)
							  if(ss.charAt(y) == '/') {
								  ind [z] = y;
								  z ++;
							  }
						  index = ind [1];
							res = new Fraction(ss.substring(0, index));
							res = res.div(new Fraction(ss.substring(index + 1, ss.length())));
					  }
				  } 
				  
				  if((ss.indexOf("-") != -1) && (iadd == 0) && (imull == 0) && (idiv == 0) 
						  && (u == 2) && (isub == 1)) {  //Мінус стоїть всередині
					  index = ss.indexOf("-");
						res = new Fraction(ss.substring(0, index));
						res = res.sub(new Fraction(ss.substring(index + 1, ss.length())));
				  }
				  
				  }
			  }else {
				  return res = null;
				  }
			return res;
		}
	}
	
	public static class KomplexCalculator extends AbstractCalculator {
	  private int posOp = -1;
	  protected char operation = 'p';
		
		KomplexCalculator() {
			
		}
		
		public boolean check(String s){
			int a = 0;
			for (int i = 0; i < s.length(); i ++) {
				if (s.charAt(i) == 'i') {
					a ++;
				}
			}
			if (a == 2) {
				return true;
			}
			else {
				
				return false;
			}
		}
		
		public Object exec(String s) {
			
			Komplex res = null;
			StringBuilder sb = new StringBuilder();
			  sb.delete(0, sb.length());
			  for(int i=0; i < s.length(); i++) {
			   char ch = s.charAt(i);
				if(ch != ' ') {
					sb.append(ch);
				}	
			  }
			  
			  String ss = sb.toString();
			  
			  int komplexI [] = new int [2];
			  int positionI = 0, iMul = 0, iSub = 0, iDiv = 0, iAdd = 0, iOp = 0;
			  char Op [] = new char [3];

			  for (int i = 0; i < ss.length(); i ++) {
				  if (ss.charAt(i) == 'i') {
					  komplexI [positionI] = i;
					  positionI ++;
				  }
				  
				  if (ss.charAt(i) == '*') {
					  iMul ++;
				  }
				  
				  if ((ss.charAt(i) == ':') || (ss.charAt(i) == '/')) {
					  iDiv ++;
				  }
				  
				  if (ss.charAt(i) == '+') {
					  iAdd ++;
				  }
				  if (ss.charAt(i) == '-') {
					  iSub ++;
				  }
			  }
			  
			  for (int i = komplexI[0]; i < komplexI[1]; i ++) {
				  if (iMul < 3) {
					  if (ss.charAt(i) == '*') {
						  if ( ((i - 1) == komplexI [0]) || ((i + 1) == komplexI [1]) ) {
							  continue;
						  } else {
							  posOp = i;
							  operation = '*';
						  }
					  }
				  } else {
					  if (iMul >= 2)
						  operation = '*';
				  }
			  }
			  
			  if (iAdd >= 3) {
				  operation = '+';
			  }
			  
			  if (iSub > 3) {
				  operation = '-';
			  }

			  for (int i = komplexI[0]; i < komplexI[1]; i ++) {
				  if ((ss.charAt(i) == '+') || (ss.charAt(i) == '-') || (ss.charAt(i) == '/') || (ss.charAt(i) == ':')) {
					  Op [iOp] = ss.charAt(i);
					  iOp ++;
				  }
			  }

			  iOp = 0;
			  
			  if (posOp == (komplexI [0] + 1)) 
				  iOp ++;
			  			  
			  if (operation != '*') {
				  operation = Op [iOp]; }
			  else {iOp = posOp; 
			  		System.out.println("iOp = " + iOp);
			  }
			  
			  for (int i = 0; i < komplexI[1]; i ++) {
				  if ((ss.charAt(i) == operation) && (i > komplexI [0])){
					  iOp = i;
					  break;
				  }
			  }
			  
			  res = new Komplex(ss.substring(0, iOp));
			  
			  switch (operation) {
			  case '*' :
				  res = res.mull(new Komplex(ss.substring((iOp + 1), ss.length())));
				  break;
			  case ':' :
				  res = res.div(new Komplex(ss.substring((iOp + 1), ss.length())));
				  break;
			  case '/' :
				  res = res.div(new Komplex(ss.substring((iOp + 1), ss.length())));
				  break;
			  case '+' :
				  res = res.add(new Komplex(ss.substring((iOp + 1), ss.length())));
				  break;
			  case '-' :
				  res = res.sub(new Komplex(ss.substring((iOp + 1), ss.length())));
				  break;
			  }
			  
			return res;
		}
	}
}