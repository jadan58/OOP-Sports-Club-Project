package project;
import java.util.Scanner;
import java.util.ArrayList;
public class Fan {
Scanner scanner= new Scanner(System.in);
private int loyality;
private ClubShop c1 = new ClubShop();
private ArrayList<String>eventDates= new ArrayList<>();
public Fan(int loyality) {
	this.loyality = loyality;
}
public int getLoyality() {
return loyality;
}
public void purchaseFromClubShop(Fan f) {
c1.checkIn();
if(loyality>=10) {
	System.out.println("You have a 20% discount");
}
c1.purchaseItems(f);
c1.ticketPurchase(f);
c1.receipt(f);
}
public void reviewTheClub() {
System.out.println("Enter your thoughts here: ");
String review = scanner.nextLine();
System.out.println("Your concerns have been sent to club members.");
Coach.getCoachInbox().add(review);
}
public void organizeEvents() {
System.out.println("Enter the date of your upcoming event");
String review = scanner.nextLine();
System.out.println("Added to the event list!");
eventDates.add(review);
System.out.println("Upadated event list: "+eventDates);
}
}
