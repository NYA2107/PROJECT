package unitcounter;

import java.io.File;
import java.io.PrintWriter;

public class main {
    public static void main(String[] args)  throws Exception {
	// Indicate that you are planning to use a file
	File fleExample = new File("Example.xlsx");
        // Create that file and prepare to write some values to it
        PrintWriter pwInput = new PrintWriter(fleExample);

	// Write a string to the file
	pwInput.println("Francine");
	// Write a string to the file
     	pwInput.println("Mukoko");
	// Write a double-precision number to the file
	pwInput.println(22.85);
	// Write a Boolean value to the file
	pwInput.print(true);
	 pwInput.close();
    }
}


