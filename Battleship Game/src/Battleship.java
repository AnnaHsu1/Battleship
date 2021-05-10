import java.util.Scanner;
import java.util.Random;

public class Battleship {
	
	// Assignment 3
	// Written by Anna Hsu (40178711)
	// For COMP 248 section R
	
	/*This program is a simplified version of battleship. The player plays against the computer and the goal
	 is to be the first to sink all of the opponent's ships and to avoid grenades. Each player places 6 ships 
	 and 4 grenades.*/
	
	private String [][] grid = new String[8][8];
	private int row;
	private int col;
	private int player1;
	private int player2;
	
	
	public Battleship() {//default constructor, initial state of game
		
		row = 0;
		col = 0;
		
		for(int i = 0; i<grid.length;i++) {
			for(int j = 0; j<grid[i].length;j++) {
				grid[i][j]="-";				
			}
		}		
	}
	
	public Battleship(Battleship gameGrid) {//copy of grid containing all positions of ships/grenades
		
		for(int i = 0; i<grid.length;i++) {
			for(int j =0; j<grid[i].length;j++)
				grid[i][j] = gameGrid.grid[i][j];
		}
	}
	
	public void board() { //prints state of board
		
		for(int i = 0; i<grid.length;i++) {
			for(int j = 0; j<grid[i].length;j++) 
				System.out.print(grid[i][j]+" ");
			System.out.println();	
	}}
	
	public void board(Battleship gameGrid) { //prints grid with all positions when winner is declared
		
		for(int i = 0; i<grid.length;i++) {
			for(int j = 0; j<gameGrid.grid[i].length;j++) 
				System.out.print(gameGrid.grid[i][j]+" ");
			System.out.println();	
	}
		
	}
	public int column(String coordinate) { //set column depending on player's input
		
		switch(coordinate.charAt(1)) {
		
		case '1':
			col = 0;
			break;
			
		case '2':
			col = 1;
			break;
		
		case'3':
			col = 2;
			break;
			
		case '4':
			col = 3;
			break;
			
		case '5':
			col = 4;
			break;
			
		case '6':
			col = 5;
			break;
		
		case '7':
			col = 6;
			break;
			
		case '8':
			col = 7;
			break;
			
		}
		
		return col;
	}
	
	public int row(String coordinate) { // set row depending on player's input
		
		switch(coordinate.charAt(0)) {
		
		case 'A':
		case 'a':
			row = 0;
			break;
		
		case 'B':
		case 'b':
			row = 1;
			break;
			
		case 'C':
		case 'c':
			row = 2;
			break;
	
		case 'D':
		case 'd':
			row = 3;
			break;
		
		case 'E':
		case 'e':
			row = 4;
			break;
			
		case 'F':
		case 'f':
			row = 5;
			break;
			
		case 'G':
		case 'g':
			row = 6;
			break;
		
		case 'H':
		case 'h':
			row = 7;
			break;
			
		}
		
		return row;
	}
	
	public void setHship() { //assigns letter to a position in grid
		
		grid[row][col] = "s";
	}
	
	public void setCship() {
		
		grid[row][col] = "S";
	}
	
	public void setHgrenade() {
		
		grid[row][col] = "g";
	}
	
	public void setCgrenade() {
		
		grid[row][col] = "G";
	}
	
	public boolean coordinateBounds(String coordinate) { //checks if to coordinates entered are within bounds
		
		String coordUCase = coordinate.toUpperCase();
		char coordX = coordUCase.charAt(0);
		char coordY = coordUCase.charAt(1);
		return ((coordX>=(int)'A' && coordX<=(int)'H') && (coordY>='1' && coordY<'9'));
	}
	
	public int randomRow() { //randomize integer from 0 to 7(included) to set computer's row
		
		row = (int)(Math.random()*(7))+1;
		return row;
	}
	
	public int randomCol() {
		
		col = (int)(Math.random()*(7))+1; //randomize integer from 0 to 7(included) to set computer's column
		return col;
	}
	
	public boolean alreadyEntered() { //checks if position in grid already has a ship/grenade placed
		
		return(grid[row][col]=="s" || grid[row][col]=="S"||grid[row][col]=="g" ||grid[row][col]=="G"||grid[row][col]=="*");
	}
	
	public void computerMove() { //random column and row for computer
		
		randomRow();
		randomCol();
		
		while(alreadyEntered()) { //checks if a ship/grenade has already been placed, if so, continue statement
			randomRow();
			randomCol();
			continue;
			
		}
		
		switch(row) { //prints out sentence according to row generated randomly
		
		case 0:
			System.out.print("Position of my rocket: A");
			break;
		
		case 1:
			System.out.print("Position of my rocket: B");
			break;
			
		case 2:
			System.out.print("Position of my rocket: C");
			break;
		
		case 3:
			System.out.print("Position of my rocket: D");
			break;
		
		case 4:
			System.out.print("Position of my rocket: E");
			break;
		
		case 5:
			System.out.print("Position of my rocket: F");
			break;
		
		case 6:
			System.out.print("Position of my rocket: G");
			break;
		
		case 7:
			System.out.print("Position of my rocket: H");
			break;
			
		}
		
		switch(col) {//prints out sentence according to column generated randomly
		
		case 0:
			System.out.println("1");
			break;
		
		case 1:
			System.out.println("2");
			break;
			
		case 2:
			System.out.println("3");
			break;
		
		case 3:
			System.out.println("4");
			break;
		
		case 4:
			System.out.println("5");
			break;
		
		case 5:
			System.out.println("6");
			break;
		
		case 6:
			System.out.println("7");
			break;
		
		case 7:
			System.out.println("8");
			break;
		}
		
	}
	
	public void Rocket(Battleship gameGrid) { // main game function, scenarios depend on what the user inputed and what us on the board
		
		if(gameGrid.grid[row][col]=="-") { //compares game grid with initial grid(-) to see if both have - on the position
			
			System.out.println("Nothing");
			grid[row][col] = "*";
			board(); //prints out new state of board, with * at the position attacked
			
		}
		
		else if(gameGrid.grid[row][col]=="s"||gameGrid.grid[row][col]=="S") { //checks if game grid and grid both have s
			
			System.out.println("Ship hit!");
			grid[row][col] = gameGrid.grid[row][col]; //assigns s to grid
			board(); // prints out new state of board, with s or S at the position
			if(gameGrid.grid[row][col]=="S") {
				player1++;
			
			if(player1==6) { //first to reach 6 ships sunken wins
				System.out.println("You have won!");
				board(gameGrid);//shows full grid after game ends
				System.exit(0);
			}
		}
			else if(gameGrid.grid[row][col]=="s") {
				
				player2++;
				
				if(player2==6) {
					System.out.println("You have lost!");
					board(gameGrid);//shows full grid after game ends
					System.exit(0);
				}				
			}
		}
			
		else if(gameGrid.grid[row][col]=="g"||gameGrid.grid[row][col]=="G") {//checks if a grenade was hit
			
			System.out.println("Boom! Grenade");
			grid[row][col]=gameGrid.grid[row][col];//assigns g or G to position on board
			board();
			
		}
	}
	
	public boolean grenadeHit(Battleship gameGrid) {//checks if grenade was hit
		
		return(gameGrid.grid[row][col]=="G"||gameGrid.grid[row][col]=="g");
		
	}
	public void blankGrid() {//grid shown to player
		
		for(int i = 0; i<grid.length;i++) {
			for(int j = 0; j<grid[i].length;j++) {
				
				grid[i][j] = "-";
			}		
		}
	}
}	//End of Battleship class
	
	


	