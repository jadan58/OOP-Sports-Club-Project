package project;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		int n1 = 0;
		int n2 = 0;
		int n3= 0;
		int n4= 0;
		while(n<4) {
		System.out.println("What do you want to login as: Manager: m , Player:p , Coach: c , Fan: f");
		String login= scanner.next();
		if(login.equals("p")) {
		Player p1= new Player("Partey",25,"Player",20000,"Midfield");
		Club.team.add(p1);
		Coach c2= new Coach("Jose",50,"Coach",200000,"Defence",29);
		Coach c3= new Coach("Pielsa",60,"Coach",30000,"possesion",28);
		Coach c4= new Coach("Neggelsamn",45,"Coach",29000,"possesion",7);
		System.out.println("Your personal trainers: ");
		p1.addPT(c2);
		p1.addPT(c3);
		p1.addPT(c4);
		
		System.out.println("----------");
		while(n1<4) {
			System.out.println("Choose from the following list: \n1.Review Coach\n2.Request Training\n3.Get Last Inbox\n4.Terminate Contarct");
			int c1= scanner.nextInt();
			if(c1 ==1) {
		p1.reviewCoach();
		System.out.println("----------");
		}
			else if(c1==2) {
		p1.requestTraining();
		System.out.println("----------");
			}
			else if(c1==3) {
		System.out.println("Your last inbox: ");
		p1.getLastInbox();
		System.out.println("----------");}
			else if(c1==4) {
		p1.terminateContract();
			}
			n1++;}
	}
		else if(login.equals("m")) {
			while(n2<7) {
				System.out.println("Choose from the following list: \n1.Search Players in Market\n2.Add Player\n3.Sell Player\n4.Search Coaches in market\n5.Add Coach\n6.Inspect Stadium\n7.Mange Media");
              int c2 = scanner.nextInt();
			Manager m1 = new Manager("mo",18,"manager",500000);
			 if(c2==1) {
				 System.out.println("Enter the maximum age, maximum salary, and position you recommend(enter Midfield or Forward or Defender)");
				 int maxAge = scanner.nextInt();
				 int maxSalary = scanner.nextInt();
				 String possss = scanner.next();
			ArrayList<Player>optionss= m1.options(maxAge, maxSalary, possss);
			if(optionss.size()==0) {
				System.out.println("No players fit you description.");
			}
			else {
			for(int i = 0;i<optionss.size();i++) {
				System.out.println(optionss.get(i).introduce());
				System.out.println();
			}}
			System.out.println("-------------");
			 }
			 else if(c2==2) {
				 System.out.println("The available players: ");
				 for(int i = 0; i<Market.transferList.size();i++) {
						System.out.print(Market.transferList.get(i).getName()+ "  ");
						}
				 System.out.println();
				 System.out.println("Enter the index of the player you want to buy: ");
				 int np = scanner.nextInt();
		m1.addPlayer(Market.transferList.get(np));
		System.out.println("-------------");
			 }
			 else if(c2==3) {
				 System.out.println("The available players to sell: ");
				 for(int i = 0; i<Club.team.size();i++) {
						System.out.print(Club.team.get(i).getName()+" ");
						}
				 System.out.println();
				 System.out.println("Enter the index of the player you want to sell(from 1 till n): ");
				 int ps = scanner.nextInt();
			m1.sellPlayer((Player) Club.team.get(ps));
			System.out.println("-------------");
			 }
			 else if(c2==4) {
				 System.out.println("Enter the maximum salary: ");
				 int maxSalaryC= scanner.nextInt();
				 ArrayList<Coach>optionssC= m1.optionsCoaches(maxSalaryC);
					if(optionssC.size()==0) {
						System.out.println("No coaches fit you description.");
					}
					else {
					for(int i = 0;i<optionssC.size();i++) {
						System.out.println(optionssC.get(i).introduce());
						System.out.println();
					}
					System.out.println("-------------");
					}
			 }
			 else if(c2==5) {
				 System.out.println("The available coaches: ");
				 for(int i = 0; i<Market.transferListCoaches.size();i++) {
						System.out.print(Market.transferListCoaches.get(i).getName()+ "  ");
						}
				 System.out.println();
				 System.out.println("Enter the index of the coach you want to buy: ");
				 int ci = scanner.nextInt();
		m1.addCoach(Market.transferListCoaches.get(ci));
		System.out.println("-------------");}
			 else if(c2==6) {
		m1.inspectStadium();
		System.out.println("-------------");}
			 else if(c2==7) {
		m1.manageMedia();}
			 n2++;
		}
		
		}
		else if(login.equals("c")) {
			Coach c1 = new Coach("Jad",18,"Coach",2000000,"possesion",2);
			while(n3<5) {
				System.out.println("Choose from the following list: \n1.Select Starting LineUp\n2.Plan Training Session\n3.Select Tactics\n4.Scout talents\n5.Move to First Team");
	              int c3 = scanner.nextInt();
	              if(c3==1) {
			c1.selectStartingLineup();
			System.out.println();
			System.out.println("-------------");}
	              else if(c3==2) {
	            	  System.out.println("Enter the date and stadium: ");
	            	  String d = scanner.next();
	            	  String p = scanner.next();
			c1.planTraining(d, p);
			System.out.println("-------------");}
	              else if (c3==3) {
			c1.selectTactics();
			System.out.println("-------------");}
	              else if(c3==4) {
	            	  System.out.println("What position do you want to scout the player from?(enter Midfield or Forward or Defender");
	            	  String poss = scanner.next();
			c1.scoutTalents(poss);
			System.out.println("-------------");}
	              else if (c3==5) {
	            	  for(int i = 0; i<Club.Bteam.size();i++) {
							System.out.print(Club.Bteam.get(i).getName()+ "  ");
							}
	            	  System.out.println();
	            	  System.out.println("Enter index for the player you want to raise: ");
	            	  int indeeex = scanner.nextInt();
			c1.moveToFirstTeam(Club.Bteam.get(indeeex));}
	              n3++;
		}
		
		}
		else if(login.equals("f")){
			while(n4<3) {
				Fan f1 = new Fan(10);
				System.out.println("Choose from the following list: \n1.Purchase from Club Shop\n2.Review The Club\n3.Organize Events");
	              int c3 = scanner.nextInt();
	             
			
			 if(c3==1) {
			f1.purchaseFromClubShop(f1);
			System.out.println("-------------");}
			 else if(c3==2) {
			f1.reviewTheClub();
			System.out.println("-------------");}
			 else if(c3==3) {
			f1.organizeEvents();}
			 n4++;
		}
		
		}
		else {
			System.out.println("Invalid Choice");
		}
		n++;
	}
		scanner.close();
  }

}
