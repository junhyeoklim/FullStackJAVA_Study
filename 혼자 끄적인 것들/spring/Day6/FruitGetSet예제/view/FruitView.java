package view;

import peopleData.Customer;
import peopleData.Fruiter;

public class FruitView {

	public static void main(String[] args) {
		
		Customer buyer = new Customer();
		Fruiter f1 = new Fruiter();
		Fruiter f2 = new Fruiter();
		
		f1.fruiterDefine(2000, 50, 50000);
		f2.fruiterDefine(1000, 100, 100000);
		
		buyer.customerDefine(20000);
		buyer.customerBuy(f1, 3);
		buyer.customerBuy(f2, 8);
		
		f1.fruiterState();
		f2.fruiterState();
		
		buyer.customerState();
		
	}

}
