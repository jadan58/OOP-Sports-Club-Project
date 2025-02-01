package project;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public interface Market {
	List<Player> transferList = new ArrayList<>(Arrays.asList(new Player("Pedri",19,"Player",1000000,"Midfield"), new Player("Halaand",21,"Player",300000,"Forward"), new Player("bellingham",20,"Player",100000,"Midfield"),new Player("Maldini",30,"Player",200000,"Defender"),new Player("Aruajo",22,"Player",300000,"Defender"),new Player("Leao",19,"Player",250000,"Forward")));
	List<Coach> transferListCoaches = new ArrayList<>(Arrays.asList(new Coach("Guardiola",50,"Coach",500000,"possesion",20), new Coach("Klopp",60,"Coach",400000,"pressure",25), new Coach("Alonso",40,"Coach",200000,"passing",2)));
	public ArrayList<Player> options (int maxAge,int maxSalary,String position);
	public ArrayList<Coach> optionsCoaches (int maxSalary,String style);
	public void addPlayer(Player p);
	public void sellPlayer(Player p);
	public void addCoach(Coach c);
	
	
 
}