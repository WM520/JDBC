package com.donghui.exception;

public class AuctionTest {
	
	private double initPrice = 30.0;
	
	public void bid(String bidPrice) throws AuctionException{
		double d = 0.0;
		try {
			d = Double.parseDouble(bidPrice);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			throw new AuctionException("必须是数值");
			
		}
		
		if (initPrice > d) {
			throw new AuctionException("必须大于竞价");
		}
		
		initPrice = d;
	}
	
	public static void main(String[] args) {
		AuctionTest test = new AuctionTest();
		try {
			test.bid("dddd");
		} catch (AuctionException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		
		}
	}
}
