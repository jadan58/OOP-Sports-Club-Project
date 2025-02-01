package project;

import java.util.ArrayList;
import java.util.Arrays;

interface Club {
	ArrayList <Member>team =new ArrayList<>(Arrays.asList(new Coach("Xavi",40,"Coach",3600000,"position",5), new Player("Gavi",18,"Player",500000,"Midfield"),new Player("Neymar",30,"Player",5000000,"Forward"),new Player("Materazzi",35,"Player",3000000,"Defender"),new Player("Gundogan",30,"Player",3000000,"Midfield")));
 
	ArrayList <Player>Bteam =new ArrayList<>(Arrays.asList(new Player("Lamine Yamal",16,"Player",2000,"Forward"), new Player("Pau Cubarsi",17,"Player",400,"Defender"),new Player("Marc Casado",20,"Player",3000,"Midfield")));	
	void addBalance(double add);
 void removeBalance(int remove);
	
	
}