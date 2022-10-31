public class Pegboard {
	
	static PegboardSolitaire m =  new PegboardSolitaire();
    

    /**
 * Method used to  print the current board state, generally after every move the user makes.
 */

public static void printBoard(){
	
	String border = "        +---------+\n";
	String shortLBorder = "       |";
	String shortRBorder = "|\n";
	String shortdashBorder = " +-----+";
	String shortdashBorderR = "+-----+\n";
	String lBorder = "|";
	String space = "   ";
	String peg = " X ";
	String column = "    0  1  2  3  4  5  6\n";
	
	System.out.print(column);
	System.out.print(border);
	System.out.print("0");
	System.out.print(shortLBorder);
	if(PegboardSolitaire.puzzleRep[0][2]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(PegboardSolitaire.puzzleRep[0][3]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(PegboardSolitaire.puzzleRep[0][4]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
    System.out.print(shortRBorder);
    System.out.print(1);
    System.out.print(shortdashBorder);
    
    if(PegboardSolitaire.puzzleRep[1][2]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(PegboardSolitaire.puzzleRep[1][3]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(PegboardSolitaire.puzzleRep[1][4]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	System.out.print(shortdashBorderR);
	
	for(int i = 2; i < 5;i++){
		System.out.print(i+" ");
		System.out.print(lBorder);
		for(int j = 0; j < 7; j ++){
			if(PegboardSolitaire.puzzleRep[i][j] == 1){
				System.out.print(peg);
			}
			else{
				System.out.print(space);
			}
		}//End for loop
		
		System.out.print(shortRBorder);
	}//End row 2-4 border print
	
	System.out.print("5");
	System.out.print(shortdashBorder);
	if(PegboardSolitaire.puzzleRep[5][2]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(PegboardSolitaire.puzzleRep[5][3]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(PegboardSolitaire.puzzleRep[5][4]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
    System.out.print(shortdashBorderR);
    
    
    System.out.print(6);
    System.out.print(shortLBorder);
    if(PegboardSolitaire.puzzleRep[6][2]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(PegboardSolitaire.puzzleRep[6][3]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	
	if(PegboardSolitaire.puzzleRep[6][4]==1){
		System.out.print(peg);
	}
	else{
		System.out.print(space);
	}
	System.out.print(shortRBorder);
	System.out.print(border);
	
	
	
}

/**
 * Method used to fill the puzzle representation logic.
 * For the purposes of the game, a 0 represents an empty space, a 2 represents a peg.
 */
public static void puzzleFill(){
	System.out.println();
	
	for(int i = 0; i < 7;i++){
		for(int j = 0; j < 7;j++){
			PegboardSolitaire.puzzleRep[i][j] = 1;
		}
	
	}
	PegboardSolitaire.puzzleRep[3][3] = 0;
	PegboardSolitaire.puzzleRep[0][0] = 2;
	PegboardSolitaire.puzzleRep[0][1] = 2;
	PegboardSolitaire.puzzleRep[0][5] = 2;
	PegboardSolitaire.puzzleRep[0][6] = 2;
	PegboardSolitaire.puzzleRep[1][0] = 2;
	PegboardSolitaire.puzzleRep[1][1] = 2;
	PegboardSolitaire.puzzleRep[1][5] = 2;
	PegboardSolitaire.puzzleRep[1][6] = 2;
	PegboardSolitaire.puzzleRep[5][0] = 2;
	PegboardSolitaire.puzzleRep[5][1] = 2;
	PegboardSolitaire.puzzleRep[5][5] = 2;
	PegboardSolitaire.puzzleRep[5][6] = 2;
	PegboardSolitaire.puzzleRep[6][0] = 2;
	PegboardSolitaire.puzzleRep[6][1] = 2;
	PegboardSolitaire.puzzleRep[6][5] = 2;
	PegboardSolitaire.puzzleRep[6][6] = 2;
	
}
	//End puzzle
	




/**
 * Method used to set up the Peg Solitaire gameboard representation at the start of the game.
 */
public static void initialPuzzle(){
		System.out.print("   ");
		for(int i = 0; i < 7; i ++){
			if(i !=6){
				System.out.print(i+"  ");
			}
			else{
				System.out.print(i);
			}		
		}
		System.out.println();
		
		System.out.print("        ");
		System.out.print("+---------+");
		System.out.println();
		
		for(int i = 0; i <7;i++){
			System.out.print(i+" ");
			if(i == 0 || i == 6){
				System.out.print("      | X  X  X |      ");
				System.out.println();
			}
			
			if(i == 1 || i==5){
				System.out.print("+-----+ X  X  X +-----+");
				System.out.println();	
			}
			
			if(i == 2 || i == 4){
				System.out.print("| X  X  X  X  X  X  X |");
				System.out.println();
			}
			
			if(i == 3){
				System.out.print("| X  X  X     X  X  X |");
				System.out.println();
			}
		}//End for loop
		System.out.print("        ");
		System.out.print("+---------+");
		System.out.println();
		
	}
	

    public static void introScreen() {
	System.out.println("**********************************");
	System.out.println("******Pegboard solitaire!*********");
	System.out.println("**********************************");
	System.out.println("Below is a printed Pegboard, the pegs are marked by the X's");
	System.out.println("First, pick your desired peg (X) by typing: y-axis number/x-axis number. Example: 13.");
	System.out.println("Once you have done this, it will ask you to enter in your desired empty spot (that goes over another Peg (X)). Example: 33");
	System.out.println("When you have hopped over all the X's and you have one left, you win!");
	System.out.println("Good luck!");

	System.out.println();
    }

    
}
