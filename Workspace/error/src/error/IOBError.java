package error;

public class IOBError {
 public static void IOBerror() {
	 try {
			int num[] = {1,2,3,4};
			System.out.println(num[10]);//this why the error is occur. it because program called the wrong index of array. 
		}
		catch (ArrayIndexOutOfBoundsException e) {//this error occur when index out of bound
			System.out.println("Indexnya Nyasar euy..");
		}
 }
}
