package error;

import java.lang.reflect.Method;

public class MethodError {
	public static void methoderror() {
		Class c;
		try  {
	        c = Class.forName("tes");
	        try
	        {
	          Class[] tes = new Class[5];
	          Method m = c.getDeclaredMethod("fakeMethod", tes);
	        }        
	        catch (NoSuchMethodException e)
	        {
	          System.out.println("Method not found");
	        }
	      }catch (ClassNotFoundException e)
	    {
	    	  System.out.println("Class not found");//this error called Class Not found. it happen when program can't find the classes.
	    }
	}
}
