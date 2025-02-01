package project;
import java.util.Scanner;
import java.util.ArrayList;
public class Coach extends Member{
	Scanner scanner = new Scanner(System.in);
	private String style;
	private int experience;
	private static ArrayList<String> coachInbox= new ArrayList<>();
	public Coach(String name, int age, String role, int salary,String style, int experience) {
		super(name, age, role, salary);
		this.style = style;
		this.experience = experience;
	}
	public String getStyle() {
		return style;
	}
	
	public int getExperience() {
		return experience;
	}
	public static ArrayList<String> getCoachInbox() {
		return coachInbox;
	}
	public void planTraining(String date,String place) {
		String training= "Next Traning session: "+date+", "+place;
		System.out.println(training);
		System.out.println("Training session added to Player Inbox");
		Player.getInbox().add(training);
	}
	public Player[]selectStartingLineup(){
		Player starting []= new Player [3];
		int count = 0;
		System.out.println("Enter yes if you want to select player and no if you don't (you should select 3 players): ");
		for(int i = 0;i<Club.team.size();i++) {
		
			if(Club.team.get(i) instanceof Player) {
				System.out.println(Club.team.get(i).introduce());
				String decision = scanner.next();
				if(decision.equals("yes")) {
					starting[count]= (Player) Club.team.get(i);
					count++;
					System.out.println("Player selected");
					if(count ==3) {
						break;
					}
				}
				else {
					System.out.println("Player not selected");
				}
				
			}
		}
		System.out.println();
		System.out.println("Final team for your game: ");
		for(int i = 0;i<3;i++) {
			if(starting[i]!=null)
			System.out.print(starting[i].getName()+ " ");
		}
		return starting;
	}
	public void selectTactics() {
		System.out.println("Enter attacking Style: ");
		String attack = scanner.next();
		System.out.println("Enter Defending Style: ");
		String defence = scanner.next();
		System.out.println("What formation will you use: ");
		String form = scanner.next();
		System.out.println("Your Tactics for todays game: Attack: "+ attack+" ,Defence: "+ defence+" ,Formation: "+ form);
	}
	public void scoutTalents(String pos) {
		System.out.println("Displaying talents based on the position you requested: ");
		for(int i = 0;i<Club.Bteam.size();i++) {
			if(Club.Bteam.get(i).getPosition().equals(pos)) {
				System.out.println(Club.Bteam.get(i).introduce());
			}
		}
	}
	public void moveToFirstTeam(Player p) {
		for(int i = 0;i<Club.Bteam.size();i++) {
			if(Club.Bteam.get(i)==(p)) {
				Club.Bteam.remove(i);
				Club.team.add(p);
			}
		}
		System.out.println("Updated First Team: ");
		for(int i =0;i<Club.team.size();i++) {
		System.out.println(Club.team.get(i).getName()+ " ");
		}
		
	}
	@Override
	public String introduce() {
		return super.introduce() + "Coaching style: " + style + "\n"
	                             + " Experience: " + experience + " years";
	}
	
	

}