import java.util.Scanner;

public class BattleshipDriver {

	public static void main(String[] args) {
		
		int Hship = 1;
		int Cship = 1;
		int Hgrenade = 1;
		int Cgrenade = 1;
				
		Battleship grid = new Battleship();
			 
		System.out.println("Hi! Let's play battleship!");
				
		while(Hship<=6) { //Setting human ships
			System.out.println("Enter the coordinates of your ship #"+Hship+": ");
			Scanner input = new Scanner(System.in);
			String HshipInput = input.next();
					
			if(HshipInput.length()!=2) {//checking length of coordinates
				System.out.println("Invalid coordinates re-enter!");
				continue;
			}		
			else if(!grid.coordinateBounds(HshipInput)) {//checking if bounds are respected, if not, continue statement
				System.out.println("Invalid coordinates, re-enter!");
				continue;
			}
					
			else { //sets ships to grid
						
				grid.row(HshipInput);
				grid.column(HshipInput);
						
				if(grid.alreadyEntered()) {
					System.out.println("Coordinates already entered, re-enter!");
					continue;
				}
				grid.setHship();	
				Hship++;
			}
		}	
		System.out.println();
				
		while(Hgrenade<=4) { //setting human grenades
					
			System.out.println("Enter the coordinates of your grenade #"+Hgrenade+": ");
			Scanner input2 = new Scanner(System.in);
			String HgrenadeInput = input2.next();
					
			if(HgrenadeInput.length()!=2) {
				System.out.println("Invalid coordinates, re-enter!");
				continue;
			}	
					
			else if(!grid.coordinateBounds(HgrenadeInput)) {
			System.out.println("Invalid coordinates. re-enter!");
			continue;
			}
				
			else {
						
				grid.row(HgrenadeInput);
				grid.column(HgrenadeInput);
						
				if(grid.alreadyEntered()) {
					System.out.println("Coordinates already entered, re-enter!");
					continue;
				}
						
				grid.setHgrenade();
				Hgrenade++;
			}
			
		}
		System.out.println();
				
		while(Cship<=6) { //setting computer ships
					
			grid.randomRow();
			grid.randomCol();
					
			if(grid.alreadyEntered())
				continue;
			grid.setCship();
			Cship++;
		}
				
		while(Cgrenade<=4) {//setting computer grenades
					
			grid.randomRow();
			grid.randomCol();
					
			if(grid.alreadyEntered())
				continue;
				
			grid.setCgrenade();
			Cgrenade++;
		}
			
		System.out.println("OK, the computer placed its ships and grenades at random. Let's play!");
		System.out.println();
		System.out.println();
				
		Battleship gameGrid = new Battleship(grid);//copy of grid, contains all ships/grenade placed
		grid.blankGrid();//blank board will be shown to player now that all positions have been copied to gameGrid
				
		while(true) {
		System.out.println("position of your rocket: ");//player's turn
		Scanner input3 = new Scanner(System.in);
		String rocket = input3.next();
				
		if(!grid.coordinateBounds(rocket)) {
					
			System.out.println("Invalid coordinates, re-enter!");
			continue;
		}
		grid.row(rocket);
		grid.column(rocket);
		grid.Rocket(gameGrid);
				
		if(grid.grenadeHit(gameGrid)) {//player hits a grenade, computer's turn
					
			grid.computerMove();
			grid.Rocket(gameGrid);
					
			if(grid.grenadeHit(gameGrid)) {//if computer hits grenade, player and computer both skip turns and goes back to player
				grid.Rocket(gameGrid);
				continue;
					}
		}
				
		grid.computerMove();
		grid.Rocket(gameGrid);
				
		if(grid.grenadeHit(gameGrid)) {
			System.out.println("position of your rocket: ");
					
			Scanner input4 = new Scanner(System.in);
			String rocket1 = input3.next();
					
			grid.row(rocket1);
			grid.column(rocket1);
			grid.Rocket(gameGrid);
					
			if(grid.grenadeHit(gameGrid)) {//if player hits grenade, both turns are skipped and goes back to computer
				grid.computerMove();
				grid.Rocket(gameGrid);
			}
			
		}
	}
		
		
	}	
			
}//end BattleshipDriver class

			


	
