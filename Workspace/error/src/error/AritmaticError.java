
package error;

public class AritmaticError {
	public static void aritmaticerror(){
	 int num1;
	 int num2;
	 
	     try {
	       
	        num1 = 0;
	        num2 = 62 / num1;//the reason why the program was error
	        System.out.println(num2);
	        
	     }
	     catch (ArithmeticException e) { 
	        /* This block will only execute if any Arithmetic exception 
	         * occurs in try block
	         */
	        System.out.println("Aritmaitic Error");
	     }
	 
	}
}