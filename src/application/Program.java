package application;

import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;

public class Program {

	public static void main(String[] args) throws ParseException {
		
	    SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner s= new Scanner(System.in);
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name=s.nextLine();
		System.out.print("Email: ");
		String email=s.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(s.next());
		
		Client client= new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(s.next());
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many items to this order?");
		int N =s.nextInt();
		for (int i=0; i<N; i++) {
			System.out.println("Enter #"+ (i+1) + " item data: ");
			System.out.print("Product name: ");
			s.nextLine();
			String productName= s.nextLine();
			System.out.print("Product price: ");
			double productPrice = s.nextDouble();
			System.out.print("Quantity: ");
			int quantity= s.nextInt();
			
			Product product= new Product(productName, productPrice);
			OrderItem it = new OrderItem(quantity, productPrice, product);
			
			order.addItem(it);
			
		}
		
		System.out.println();
		System.out.println(order);
				
		
		s.close();
	}

}
