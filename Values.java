/*******************************************************************************************************
 * Title:		Values.java
 * Author:		Tony Zheng
 * Created On:	January 23, 2015
 * Description:	Creates a HashMap from the file specified in the command line argument and a GUI for the
 * 				user to enter the date as the key to lookup the values in the HashMap
 * Build with:	Eclipse or using the following commands on the glab machines 
 * 				To compile: javac HistoicalPrices.java TestMap.java Values.java
 * 				To run: 	java HistoicalPrices.java 'FileName'
 *******************************************************************************************************/
public class Values 
{
	private String open, high, low, close, volume, adjClose;

	public Values()
	{
		open = "";
		high = "";
		low = "";
		close = "";
		volume = "";
		adjClose = "";
	}
	
	public Values(String open, String high, String low, String close, String volume, String adjClose)
	{
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.adjClose = adjClose;
	}

	public String getOpen() 
	{
		return open;
	}

	public void setOpen(String open) 
	{
		this.open = open;
	}

	public String getHigh() 
	{
		return high;
	}

	public void setHigh(String high) 
	{
		this.high = high;
	}

	public String getLow() 
	{
		return low;
	}

	public void setLow(String low) 
	{
		this.low = low;
	}

	public String getClose()
	{
		return close;
	}

	public void setClose(String close) 
	{
		this.close = close;
	}

	public String getVolume() 
	{
		return volume;
	}

	public void setVolume(String volume) 
	{
		this.volume = volume;
	}

	public String getAdjClose() 
	{
		return adjClose;
	}

	public void setAdjClose(String adjClose) 
	{
		this.adjClose = adjClose;
	}
}