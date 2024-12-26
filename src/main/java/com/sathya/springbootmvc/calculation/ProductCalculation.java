
package com.sathya.springbootmvc.calculation;

public class ProductCalculation {
	public static void main(String[] args) {
		int discountrate=20;
		int quqntity=50;
		int tax=18;
		double price=30000;
		double discountprice=((double)discountrate/100)*price;
		System.out.println(discountprice);
		double offerprice=price-discountprice;
		System.out.println(offerprice);
		double taxamt=((double)tax/100)*offerprice;
		System.out.println(taxamt);
		double finalprice=offerprice+taxamt;
		System.out.println(finalprice);
		double stockvalue=finalprice*quqntity;
		System.out.println(stockvalue);
	}

}
