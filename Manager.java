package project;

import java.util.ArrayList;
import java.util.Scanner;
public class Manager extends Member implements Market,Club{
	Scanner scanner = new Scanner (System.in);
    private int balance = 3500000;
	String []media ={"April 27","April 29","May 10"};
	public Manager(String name, int age, String role, int salary) {
		super(name, age, role, salary);
	}
	public void addBalance(double add) {
	    balance += add;
	}

	public void removeBalance(int remove) {
	    balance -=remove;
	}

	public ArrayList<Player> options (int maxAge,int maxSalary,String position) {
		System.out.println("Displaying all options based on your requirments: ");
		System.out.println();
		ArrayList<Player>available = new ArrayList<>(); 
		for(int i =0 ;i<transferList.size();i++) {
			if(transferList.get(i).getAge()<=maxAge && transferList.get(i).getSalary()<=maxSalary && transferList.get(i).getPosition().equals(position)) {
				available.add(transferList.get(i));
			}
		}
		return available;}

	public void addPlayer(Player p) {
		
		if(balance>p.getSalary()) {
			team.add(p);
			transferList.remove(p);
	
			System.out.println("Updated team list after adding "+ p.getName()+"");
			for(int i = 0; i<team.size();i++) {
				System.out.print(team.get(i).getName()+ "  ");
				}
			System.out.println();
		}
		else {
			System.out.println("Unsufficient Balance, please choose another option.");
		}
		
	}
	public void sellPlayer(Player p) {
		transferList.add(p);
		int ind = 0;
		for(int i = 0;i<team.size();i++) {
			if(team.get(i) == p) {
				ind = i;
			}
		}
		team.remove(ind);
		System.out.println("Updated team list after selling " +p.getName()+ ": ");
		for(int i = 0; i<team.size();i++) {
		System.out.print(team.get(i).getName()+ "  ");
		}
System.out.println();
	
	}
	
	public ArrayList<Coach> optionsCoaches (int maxSalary) {
		ArrayList<Coach>available = new ArrayList<>(); 
		for(int i =0 ;i<transferListCoaches.size();i++) {
			if(transferListCoaches.get(i).getSalary()<=maxSalary) {
				available.add(transferListCoaches.get(i));
			}
		}
		return available;}
	public void addCoach(Coach c) {
		if(balance>c.getSalary()) {
			for(int i =0;i<team.size();i++) {
				if(team.get(i) instanceof Coach) {
					System.out.println("Old Club Coach: "+team.get(i).getName());
					transferListCoaches.remove(team.get(i));
					addBalance(team.get(i).getSalary());
					team.remove(i);
				}
			}
			System.out.println("New Club Coach: "+c.getName());
			team.add(c);
			transferListCoaches.remove(c);
			System.out.println();
		}
		else {
			System.out.println("Unsufficient Balance, please choose another option.");
		}
	
	}
	public void inspectStadium() {
		System.out.println("Do you want to improve the grass condition ofthe Club's training groud, cost:2000$(enter yes)");
		String confirm =scanner.nextLine();
		if(confirm.equals("yes")) {
			System.out.println("Done!");
			removeBalance(2000);
			System.out.println("Updated Club Balance: "+balance);
		}
		else {
			System.out.println("Okay.");
		}
	}
	public void manageMedia() {
		System.out.println("Displaying your upcoming press conferences: ");
		for(int i = 0;i<media.length;i++) {
			System.out.println(media[i]);
		}
		System.out.println("Do you want to delete any?");
		String con = scanner.next();
		if(con.equals("yes")) {
			System.out.println("Provide the index: ");
			int indx = scanner.nextInt();
			media[indx]= null;
			System.out.println("Displaying updated calender");
			for(int i =0 ;i<media.length;i++) {
			  if(media[i]!=null) {
				  System.out.println(media[i]);
			  }
			}
		}
		else {
			System.out.println("Okay");
		}
	}
	
	public ArrayList<Coach> optionsCoaches(int maxSalary, String style) {
		// TODO Auto-generated method stub
		return null;
	}
}