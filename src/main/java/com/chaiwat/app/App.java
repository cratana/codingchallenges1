package com.chaiwat.app;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.*;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/*
	How to run
	java -cp target/chaiwat-app-1.0-SNAPSHOT.jar com.chaiwat.app.App
*/

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
		String inputFile = "/Users/cratana/Code/hello-maven/chaiwat-app/Set_marketdata_price-EPG.html";
        System.out.println( "Chaiwat App starts!" );
		String delim = ":";

		Document doc;
		Elements element;
		stockPriceList priceList;

		try {
			File input = new File(inputFile);
			doc = Jsoup.parse(input, "UTF-8", inputFile);
			String title = doc.title();
			System.out.println("Doc title: " + title);
			
			Element table = doc.select("div.table-responsive").get(0);
			Elements headrows = table.select("th");

			System.out.println("Header row: " + headrows.text());

			//printTableHeader(headrows, delim);

			Elements rows = table.select("tr");
			createStockPriceList(rows);
			//printTableRows(rows, delim);

			//System.out.println("Header row text: " + headrows.text());
			//printElements(rows);
			//System.out.println(table.html());
			
		} catch (IOException e) {
			System.out.println(e);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void printTableHeader(Elements headrows, String delim)
	{
		
			String headerCells = "";
			for(Element i : headrows)
			{
				headerCells += i.text() + delim;	
			}
			System.out.println("Header row cells: " + headerCells);
	}

	public static void	createStockPriceList(Elements rows) throws ParseException {

		stockPriceList stockList = new stockPriceList();
		List<stockPriceList> stockPriceListList = new ArrayList<stockPriceList>();
		//Element element1 = rows.first();
		Elements rowContents = rows.next();

		for(Element row : rowContents)
		{

			// Now let's assign into a stockPriceList object
			stockList.date = row.child(0).text();
			stockList.openPrice = Float.valueOf(row.child(1).text());
			stockList.highPrice = Float.valueOf(row.child(2).text());
			stockList.lowPrice = Float.valueOf(row.child(3).text());
			stockList.closedPrice = Float.valueOf(row.child(4).text());
			stockList.diffPrice = Float.valueOf(row.child(5).text());
			stockList.diffPercentPrice = Float.valueOf(row.child(6).text());
			stockList.volumeTotal = NumberFormat.getInstance().parse(row.child(7).text()).floatValue();
			stockList.valueTotal = NumberFormat.getInstance().parse(row.child(8).text()).floatValue();
		}



//		System.out.println("Header: " + element1.text());
//		System.out.println("Header: " + rowContents.text());
//		System.out.println("Content: " + stockList.toString());

//		List<String> itemList = new ArrayList<String>();
//		for(Element row: rows)
//		{
//			System.out.println("--------------");
//			System.out.println(row.child(0).text() + separator + row.child(1).text() +separator+
//					row.child(2).text() +separator+ row.child(3).text() +separator+ row.child(4).text()
//					+separator+ row.child(5).text() +separator+ row.child(6).text() +separator+ row.child(7).text()
//					+separator+ row.child(8).text());
//		}
	}

	public static void printTableRows(Elements rows, String delim)
	{
		int rowcount = 0;
		String rowCells = "";
		for(Element row : rows)
		{
			rowcount++;
			//Elements tds = rows.select("td");
			System.out.println("Table row[" + rowcount + "]:" + row.text());
			//System.out.println("Table row: " + row.html());
		}
		System.out.println("Total row = " + rowcount);
	}

	public static void printElements(Elements rows)
	{
			int rowCount = 0;
			for(Element row : rows) {
				rowCount++;
				System.out.println(row.html());
			}
			System.out.println("Total rows = " + rowCount);
		
	}

	public void testURL()
	{
		String url = "http://en.wikipedia.org";
		
		try 
		{
			Document doc = Jsoup.connect(url).get();
			String title = doc.title();
			System.out.println("Doc title: " + title);
			
			Elements newsHeadlines = doc.select("#mp-itn b a");
			for (Element headline : newsHeadlines)
			{
				System.out.println("headline: " + headline);
			}
		} 
		catch (IOException e) {
			System.out.println(e);
		}
	}


}
