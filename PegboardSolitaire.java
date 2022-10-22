//Pegboard

import java.util.Scanner;


public class PegboardSolitaire {
	static Move m =  new Move();//Pulling in objects from the Move class
	static Pegboard pb = new Pegboard();//Pulling in objects from the Pegboard class
	static int[][] puzzleRep = new int[7][7];

	 //Representation of the board state (This code is also in the other class files)
	public static void main(String[] args) {
		

		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Hello player, what is your name?");
			String userChoice = input.nextLine();
			System.out.println("Welcome " + userChoice + " to");
			Pegboard.introScreen();
			Pegboard.initialPuzzle();
			Pegboard.puzzleFill();
			
			Pegboard.printBoard();
			int n = 0;
			int startingRow;
			int startingCol;
			int endingRow;
			int endingCol;
			boolean restart;
			
			//While the user does not quit (hence they have not entered -1)
			while(n != -1){
				restart = false;
				//Valid move check
				if(!Move.validMove()){
					System.out.println("There are no more legal moves.");
					break;
					
				}
				//Moving from
				do{
					System.out.println();
					System.out.print("Enter the location of the peg to move (type -1 to quit): ");
					n = input.nextInt();
					startingRow = n / 10;
					startingCol = n %10;
					if(n == -1){
						//User exited
						System.out.println("Player quit.");
						break;
					}
				}
				while(!Move.checkStart(startingRow,startingCol));
				
				if(n!=-1){
				
					//Moving to
					do{
						System.out.println();
						System.out.print("Enter the location where the peg is moving to (type -1 to quit): ");
						n = input.nextInt();
						endingRow = n / 10;
						endingCol = n %10;
						if(n == -1){
							//User exited
							System.out.println("Player quit.");
							break;
						}
						
						if(!Move.checkEndMove(startingRow,startingCol,endingRow,endingCol)){
							restart = true;
							break;
						}
					}
					while(!Move.checkEndError(endingRow,endingCol));
					
					//At this point, were both choices not quitting?
					if(n!=-1 && !restart){

						//If a valid move
						Move.userMakesMove(startingRow,startingCol,endingRow,endingCol);
						Pegboard.printBoard();
					}
				
				}		
				
			
				//Tally the ammount of pegs left on the board	
				int pegCount = 0 ;
				for(int i = 0; i < 7;i++){
					for(int j = 0; j < 7; j ++){
						if(puzzleRep[i][j] == 1){
							pegCount+=1;	
						}
					}
				}//End for loop
				System.out.println("You left "+pegCount+" on the board.");
				
}//End main
		}

	}
}
