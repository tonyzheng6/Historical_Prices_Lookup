/*******************************************************************************************************
 * Title:		HistoricalPrices.java
 * Author:		Tony Zheng
 * Created On:	January 23, 2015
 * Description:	Creates a HashMap from the file specified in the command line argument and a GUI for the
 * 				user to enter the date as the key to lookup the values in the HashMap
 * Build with:	Eclipse or using the following commands on the glab machines 
 * 				To compile: javac HistoicalPrices.java TestMap.java Values.java
 * 				To run: 	java HistoicalPrices.java 'FileName'
 *******************************************************************************************************/
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HistoricalPrices 
{	
	public static void main(String[] args)
	{
		TestMap MyMap = new TestMap();

		if(args.length != 1)
		{
			JOptionPane.showMessageDialog(null, "Enter the following command line arguments: java HistoricalPrices 'Filename'");
			return;
		}
		
		if(MyMap.createMap(args[0]) == false)
		{
			return;
		}
		
		MyMap.setTitle("Historical Prices Lookup");
		MyMap.setSize(300, 125);
		MyMap.setLocationRelativeTo(null);
		MyMap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyMap.setVisible(true);
		MyMap.setResizable(false);
	}
}