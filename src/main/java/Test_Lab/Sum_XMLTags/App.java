package Test_Lab.Sum_XMLTags;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Create program that works with file (not XML file),
 * which consists of N xml records (each xml is in the new line) with the different amount of tags. 
 * The result should be output file with sums of all tag values for each xml. 
 * In case sums cannot be calculated, appropriate record should be added to file (using try/catch). 
 */
public class App 
{	
    public static void main( String[] args )
    {
    	//Check command line arguments
		if(args.length == 0) {
			System.out.println("Please use path to file in argument");
			System.exit(0);
		}
		//Parse file
		try {
			Scanner lf = new Scanner(new FileInputStream(args[0]));
			lf.useDelimiter("\n");
			//Test
	    	XMLRecord xline = new XMLRecord();
			while (lf.hasNext()){
				xline.setXRecord(lf.next());
				xline.getSumbyXPath();
			}
			lf.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
    }
}
