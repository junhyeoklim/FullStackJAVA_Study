package view;

import peopleData.Customer;
import peopleData.Fruiter;

public class FruitView {

	public static void main(String[] args) {
		
		Customer buyer = new Customer(20000);
		Fruiter f1 = new Fruiter(2000, 50, 50000);
		Fruiter f2 = new Fruiter(1000, 100, 100000);		
		
		buyer.customerBuy(f1, 10);
		buyer.customerBuy(f2, 2);

		f1.fruiterState();
		f2.fruiterState();
		
		buyer.customerState();
		
	}

}
