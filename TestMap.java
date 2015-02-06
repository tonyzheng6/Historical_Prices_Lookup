/*******************************************************************************************************
 * Title:		TestMap.java
 * Author:		Tony Zheng
 * Created On:	January 23, 2015
 * Description:	Creates a HashMap from the file specified in the command line argument and a GUI for the
 * 				user to enter the date as the key to lookup the values in the HashMap
 * Build with:	Eclipse or using the following commands on the glab machines 
 * 				To compile: javac HistoicalPrices.java TestMap.java Values.java
 * 				To run: 	java HistoicalPrices.java 'FileName'
 *******************************************************************************************************/
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TestMap extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Map<String, Values> hashMap = new HashMap<String, Values>();
	private JPanel inputPanel;
	private JTextField monthInput, dayInput, yearInput;
	private JLabel label, firstSlash, secondSlash;
	private JButton enter, clear;

	public TestMap()
	{
		super();
		setLayout(new BorderLayout());
		inputPane();
		getContentPane().add(inputPanel, BorderLayout.CENTER);
	}
	
	public void inputPane()
	{
		inputPanel = new JPanel();
		
		label = new JLabel("Enter in the following format: MM/dd/yyyy");
		firstSlash = new JLabel("/");
		secondSlash = new JLabel("/");
		monthInput = new JTextField(4);
		dayInput = new JTextField(4);
		yearInput = new JTextField(4);
		enter = new JButton("Enter");
		clear = new JButton("Clear");
		
		inputPanel.add(label);
		inputPanel.add(monthInput);
		inputPanel.add(firstSlash);
		inputPanel.add(dayInput);
		inputPanel.add(secondSlash);
		inputPanel.add(yearInput);
		inputPanel.add(enter);
		inputPanel.add(clear);

		ActionHandler Handler = new ActionHandler();
		
		monthInput.addActionListener(Handler);
		dayInput.addActionListener(Handler);
		yearInput.addActionListener(Handler);
		enter.addActionListener(Handler);
		clear.addActionListener(Handler);
	}
	
	private class ActionHandler implements ActionListener
	{	
		private String dateKey, monthText, dayText, yearText;
		
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == monthInput || event.getSource() == dayInput || event.getSource() == yearInput || event.getSource() == enter)
			{
				monthText = monthInput.getText();
				dayText = dayInput.getText();
				yearText = yearInput.getText();
				
				if(isNumeric(monthText) && isNumeric(dayText) && isNumeric(yearText))
				{
					dateKey = monthText + "/" + dayText + "/" + yearText;

					try
					{
						JOptionPane.showMessageDialog
						(
							null, "The date " + dateKey + " returns the following values in the HashMap: \n" + 
							"Open: " + hashMap.get(dateKey).getOpen() + "\n" +
							"High: " + hashMap.get(dateKey).getHigh() + "\n" +
							"Low: " + hashMap.get(dateKey).getLow() + "\n" + 
							"Close: " + hashMap.get(dateKey).getClose() + "\n" +
							"Volume: " + hashMap.get(dateKey).getVolume() + "\n" +
							"Adj Close: " + hashMap.get(dateKey).getAdjClose()
						);
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, "The date " + dateKey + " does not match up to any value in the HashMap");
					}
				}
			}
			if(event.getSource() == clear)
			{
				monthInput.setText("");
				dayInput.setText("");
				yearInput.setText("");
			}
		}
		
		public boolean isNumeric(String string)
		{
			for(int i = 0; i < string.length(); i++)
			{
				if(!Character.isDigit(string.charAt(i)))
				{
					JOptionPane.showMessageDialog(null, "Only enter numeric values in the following format: \n MM/dd/yyyy");
					return false;
				}
			}
			
			return true;
		}
	}
	
	public boolean createMap(String fileName)
	{			
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) 
			{
				disassembleString(line);
			}
			br.close();
			return true;
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, "File does not exist or is in the wrong directory \nEnter the following command line arguments: java HistoricalPrices 'Filename'");
			return false;
		}
	}
	
	public void disassembleString(String string)
	{
		java.util.List<String> items = Arrays.asList(string.split("\\s*,\\s*"));
		String key = new String(items.get(0));
		hashMap.put(key, new Values(items.get(1), items.get(2), items.get(3), items.get(4), items.get(5), items.get(6)));
	}
}