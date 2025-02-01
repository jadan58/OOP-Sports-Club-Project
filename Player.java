package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player extends Member {
	Scanner scanner = new Scanner(System.in);
    private String position;
    private int salary;
    private static ArrayList<String> inbox = new ArrayList<>(Arrays.asList("Hello, make sure to stay fit for your game."));
    
  private ArrayList <Coach>pts = new ArrayList<>();

    public static ArrayList<String> getInbox() {
        return inbox;
    }

    public Player(String name, int age, String role, int salary, String position) {
        super(name, age, role, salary);
        this.position= position;
        
    }
public void addPT(Coach pt) {
pts.add(pt);
System.out.println(pt.getName());
}
 

    public int getSalary() {
        return salary;
    }
public void terminateContract() {
	System.out.println("You have terminated you contract with the club, Updated Roster:");
	Club.team.remove(Club.team.size()-1);
	for(int i = 0;i<pts.size();i++) {
		System.out.println(Club.team.get(i).getName());
	}
}
 public void requestTraining() {
	 System.out.println("Request a training session");
	 String training = scanner.nextLine();
	 Coach.getCoachInbox().add(training);
	 System.out.println("Updated pts inbox: ");
	 System.out.println(Coach.getCoachInbox());
	 }

    public void getLastInbox() {
        System.out.println(inbox.get(inbox.size() - 1));
    }

   public void  reviewCoach() {
	   System.out.println("Write your review: ");
	   String review= scanner.nextLine();
	   Coach.getCoachInbox().add(review);
	   System.out.println("Updated pts inbox: ");
	   System.out.println(Coach.getCoachInbox());
   }
   public Object getPosition() {
	   return position;
   }
   
   @Override
	public String introduce() {
		return super.introduce()+"Player position: " + position;
	}
	

  }