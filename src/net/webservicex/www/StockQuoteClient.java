package net.webservicex.www;

import java.rmi.RemoteException;
import java.util.Scanner;

import net.webservicex.www.StockQuoteStub.GetQuoteResponse;

import org.apache.axis2.AxisFault;

public class StockQuoteClient {

	public static void main(String[] args) {
		StockQuoteStub stub;
		try {

			System.out.print("Enter the Quote to be converted to Symbol:\t");
			Scanner sc = new Scanner(System.in);

			String symbol = sc.nextLine();
			stub = new StockQuoteStub(
					"http://10.100.5.39:9763/services/StockQuote/");
			// "http://192.168.43.143:9763/services/StockQuote/"
			StockQuoteStub.GetQuote qu = new StockQuoteStub.GetQuote();

			qu.setSymbol(symbol);

			GetQuoteResponse res = stub.getQuote(qu);

			System.out.println("Get Symbol Result  is "
					+ res.getGetQuoteResult());
		} catch (AxisFault e) {
			System.out.println("AxisFault exception ");
			e.printStackTrace();
			e.getMessage();

		} catch (RemoteException e) {
			System.out.println("remote exception");
			e.printStackTrace();
		}
	}

}
