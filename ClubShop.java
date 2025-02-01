package project;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class ClubShop {
	private Manager m= new Manager("J",18,"Mnager",232332);
Scanner scanner = new Scanner(System.in);
HashMap<String, Integer> jersey = new HashMap<String, Integer>() {{
    put("Home", 40);
    put("Away", 30);
    put("Third", 20);
}};
HashMap<String, Integer> accesories = new HashMap<String, Integer>() {{
    put("Backpack", 50);
    put("Souvenirs", 20);
    put("Scarffs", 20);
}};
HashMap<String, Integer> trainingMaterial = new HashMap<String, Integer>() {{
    put("Cones", 20);
    put("Goal", 30);
    put("GoalKeeper Materials", 30);
}};
HashMap<String, Integer> zones = new HashMap<String, Integer>() {{
    put("VIP", 1000);
    put("Zone101",500 );
    put("Zone201", 300);
    put("Zone301",100);
}};
private ArrayList<String>cart= new ArrayList<>();
public void checkIn() {
System.out.println();
System.out.println("Enter your Name: ");
String name = scanner.next();
System.out.println("Enter your phone number: ");
String phone= scanner.next();
System.out.println("Enter your address: ");
String address= scanner.next();
System.out.println();
System.out.println("Checkin complete: \nName: "+ name+"\nPhone Number: "+phone+"\nAddress: "+address);
}
public void ticketPurchase(Fan f) {
System.out.println();
System.out.println("Available Zones: "+zones);
System.out.println("Choose the zone: ");
String chosenZone =scanner.next();
System.out.println("Your Ticket:\n"+"Zone: "+chosenZone+"\nPrice: "+(discount(f)?(zones.get(chosenZone)-(zones.get(chosenZone)*0.2)):zones.get(chosenZone)));
if(discount(f)) {
	m.addBalance(zones.get(chosenZone) - (zones.get(chosenZone) * 0.2));
	}
else { 
	m.addBalance(zones.get(chosenZone) * 0.2);
	}
cart.add(chosenZone);
}
public void purchaseItems(Fan f) {
System.out.println();
System.out.println("Enter the category that you want to shop from:\n1.Jersey(enter 1)\n2.Accessories(enter 2)\n3.Training Materials(enter 3)");
    int cho = scanner.nextInt();
    switch(cho) {
    case 1:
System.out.println(jersey);
System.out.println("Enter the name of the item you want to purchase: ");
String purchase1= scanner.next();
System.out.println("Purcahse done\nItem:"+purchase1+"\nPrice:"+(discount(f) ? jersey.get(purchase1) - (jersey.get(purchase1) * 0.2) : jersey.get(purchase1)));
cart.add(purchase1);
if(discount(f)) {
	m.addBalance(jersey.get(purchase1) - (jersey.get(purchase1) * 0.2));
	}
else { 
	m.addBalance(jersey.get(purchase1) * 0.2);
	};


break;
    case 2 :
System.out.println(accesories);
System.out.println("Enter the name of the item you want to purchase: ");
String purchase2= scanner.next();
System.out.println("Purcahse done\nItem:"+purchase2+"\nPrice: " +(discount(f)?accesories.get(purchase2)-(accesories.get(purchase2)*0.2):accesories.get(purchase2)));
cart.add(purchase2);
if(discount(f)) {
	m.addBalance(accesories.get(purchase2) - (accesories.get(purchase2) * 0.2));
	}
else { 
	m.addBalance(accesories.get(purchase2) * 0.2);
	};
break;
    case 3:
System.out.println(trainingMaterial);
System.out.println("Enter the name of the item you want to purchase: ");
String purchase3= scanner.next();
System.out.println("Purcahse done\nItem:"+purchase3+"\nPrice: "+(discount(f)?trainingMaterial.get(purchase3)-(trainingMaterial.get(purchase3)*0.2):trainingMaterial.get(purchase3)));
cart.add(purchase3);
if(discount(f)) {
	m.addBalance(trainingMaterial.get(purchase3) - (trainingMaterial.get(purchase3) * 0.2));
	}
else { 
	m.addBalance(trainingMaterial.get(purchase3) * 0.2);
	};
break;
    default:
System.out.println("Wrong number entry");
break;
    }
}
public void receipt(Fan f) {
	System.out.println();
    System.out.println("Your updated reciept: ");
    int sum = 0;
    for (int i = 0; i < cart.size(); i++) {
        if (jersey.containsKey(cart.get(i))) {
            System.out.println("Item: "+cart.get(i) + " Price: " +(discount(f) ? (jersey.get(cart.get(i)) - (jersey.get(cart.get(i)) * 0.2)) : jersey.get(cart.get(i))));
            sum += discount(f) ? (jersey.get(cart.get(i)) - (jersey.get(cart.get(i)) * 0.2)) : jersey.get(cart.get(i));
        } else if (accesories.containsKey(cart.get(i))) {
            System.out.println("Item: "+cart.get(i) + " Price: " +(discount(f) ? (accesories.get(cart.get(i)) - (accesories.get(cart.get(i)) * 0.2)) : accesories.get(cart.get(i))));
            sum += discount(f) ? (accesories.get(cart.get(i)) - (accesories.get(cart.get(i)) * 0.2)) : accesories.get(cart.get(i));
        } else if (trainingMaterial.containsKey(cart.get(i))) {
            System.out.print("Item: "+cart.get(i) + " Price: " +(discount(f) ? (trainingMaterial.get(cart.get(i)) - (trainingMaterial.get(cart.get(i)) * 0.2)) : trainingMaterial.get(cart.get(i))));
            sum += discount(f) ? (trainingMaterial.get(cart.get(i)) - (trainingMaterial.get(cart.get(i)) * 0.2)) : trainingMaterial.get(cart.get(i));
        }
        else {
            System.out.println("Item: "+cart.get(i) + " Price: " +(discount(f) ? (zones.get(cart.get(i)) - (zones.get(cart.get(i)) * 0.2)) : zones.get(cart.get(i))));

        	sum+=discount(f) ? (zones.get(cart.get(i)) - (zones.get(cart.get(i)) * 0.2)) : zones.get(cart.get(i));
        }
    }
    System.out.println("Total: "+sum);
}

public boolean discount(Fan f) {
return f.getLoyality()>=10;
}
}