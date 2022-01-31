package management;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class MyHotel implements BasicHotelReq 
{
	ArrayList<Bill> al = new ArrayList<Bill>();
	
	Scanner sc= new Scanner(System.in);
	char cho='Y';
	int price, ch, quan, grandTotal, subTotal;
	String name, email, itemName, choice; 
	int usertip;

	
	
	
	@Override
	public void displayMenu()
	{
		System.out.println("*******************************");
		System.out.println("             Menu              ");
		System.out.println("*******************************");
		System.out.println("S1No     ItemName      Price   ");
		System.out.println("*******************************");
		System.out.println("1        Coffee           $5   ");
		System.out.println("2        Fries            $3   ");
		System.out.println("3        IceCream         $4   ");
		System.out.println("4        SoftDrinks       $3   ");
		System.out.println("*******************************");
		
	}
	
	@Override
	public void getUserDetails()
	{
		System.out.println("Enter your name: ");
		name = sc.nextLine();
		System.out.println("Enter the user EmailID: ");
		email = sc.nextLine();
		System.out.println("Tip amount: ");
		usertip = sc.nextInt();
	}
	
	@Override
	public void getUserInput() 
	{
		while(cho=='Y')
		{
		System.out.print("Select the item of your choice: ");
		ch = sc.nextInt();
		System.out.print("Enter the item's quantity: ");
		quan = sc.nextInt();
		calculate(ch,quan);
		System.out.println("Do you want more? (Y/N)");
		choice = sc.next();
		choice = choice.toUpperCase();  //Ensures that anything that starts with Y or N will get executed.
		cho = choice.charAt(0);
		}
		
	}

	@Override
	public void calculate(int ch, int quan) 
	{
		switch(ch)
		{
		case 1: 
			itemName = "Coffee    ";
			price = 5;
			subTotal = quan*price;
			break;
		case 2:
			itemName = "Fries     ";
			price = 3;
			subTotal = quan*price;
			break;
		case 3:
			itemName = "IceCream  ";
			price = 4;
			subTotal = quan*price;
			break;
		case 4:
			itemName = "SoftDrinks";
			price = 3;
			subTotal = quan*price;
			break;
			
			default: System.out.println("Invalid input");
		}
		al.add(new Bill (itemName, price, quan, subTotal));
		grandTotal += subTotal;
	}
	

	
	@Override
	public void print() 
	{
		float tip = 0.1f*grandTotal; 
		
		if(usertip>tip)
		{
			tip = usertip;
		}
		double service = grandTotal * 0.7;
		System.out.println("\n\n\n\n\n\n\n");
		System.out.println("--------------------------------");
		System.out.println("Bill No: "+(new Random()).nextInt());
		System.out.println("Customer Name:  "+name);
		System.out.println("Customer Email: "+email);
		System.out.println("--------------------------------");
		System.out.println("ItemName Price Quantity Subtotal");
		System.out.println("--------------------------------");
		for(Bill b : al)
		{
			System.out.println(b);
		}
		System.out.println("--------------------------------");
		System.out.println("Tip given is :           " + tip);
		System.out.println("Service charge incurred: "+ service);
		System.out.println("Your GrandTotal is:      "+ (grandTotal+ tip + service));
		
	}
	}

