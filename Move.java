public class Move {
    static int[][] puzzleRep = new int[7][7];


    

public static void userMakesMove(int startRow, int startCol, int endRow, int endCol){
   
	/**
 * 
 * Method used to make the move indicated by the player (at this point it has been confirmed to be valid)
 * 
 * startRow - the row our move starts on
 * startCol - the column our move starts on
 * endRow - the row our move end on
 * endCol - the column our move ends on
 * 
 */
    //Start peg jumping, hence it becomes 0
    puzzleRep[startRow][startCol] = 0;
    //End spot being jumped to, hence it becomes 1
    puzzleRep[endRow][endCol] = 1;
    
    int middleRow = ((startRow + endRow) / 2);
    int middleCol = ((startCol + endCol) /2);
    
    //Middle peg removed, hence becomes 0
    puzzleRep[middleRow][middleCol] = 0;

}


/**
* Method used to check if there are any more valid moves to make.
* return - a boolean denoting whether there exists any more valid moves
*/
public static boolean validMove(){
    

for(int i = 0; i < 7; i ++){
    for(int j = 0; j < 7; j ++){
        if(puzzleRep[i][j] == 1){
            //Check up
            if( (i > 1 && j > 1 && j < 5)  || (i > 3 && j < 2 && j > 4)){
                //If peg exists above current
                if(puzzleRep[i-1][j] == 1 && puzzleRep[i-2][j] == 0){
                    return true;
                }
            }
            
            //Check down
            if( (i < 5 && j > 1 && j < 5)  || (i < 3 && j < 2 && j > 4)){
                //If peg exists above current
                if(puzzleRep[i+1][j] == 1 && puzzleRep[i+2][j] == 0){
                    return true;
                }
            }
            
            //Check left
            if( (j > 1 && i > 1 && i < 5)  || (j > 3 && i < 2 && i > 4)){
                //If peg exists above current
                if(puzzleRep[i][j-1] == 1 && puzzleRep[i][j-2] == 0){
                    return true;
                }
            }
            
            //Check right
            if( (j < 5 && i > 1 && i < 5)  || (j < 3 && i < 2 && i > 4)){
                //If peg exists above current
                if(puzzleRep[i][j+1] == 1 && puzzleRep[i][j+2] == 0){
                    return true;
                }
            }
            
        }
    }
}
return false;

}

/**
* Method used to determine whether the player is attempting to move a valid piece.
* A valid piece to be moved is one that is actually on the gameboard, and actually exists
* at the position in question (the combination of startRow and startCol)
* 
* startRow - The row the player is attempting to move a piece from
* startCol - The column the player is attempting to move a piece from
* return - a boolean denoting whether or not the player is attempting to move a valid piece.
*/

public static boolean checkStart(int startRow,int startCol){
    
    
    //Check top 2 corners (Start)
    if((startRow < 2 && startCol < 2) || (startRow < 2 && startCol > 4) ){
        System.out.println("Illegal location.");
        return false;
    }
    
    //Check bottom 2 corners (Start)
    if((startRow > 4 && startCol < 2) || (startRow > 4 && startCol > 4) ){
        System.out.println("Illegal location.");
        return false;
    }
    
    //Is there a peg at start spot?
    if(puzzleRep[startRow][startCol] != 1){
        System.out.println("Illegal move, no peg at source location.");	
        return false;
    }	
            
    return true;
}


/**
* Method used to check whether the user is jumping to a valid position on the board.
* A valid position is a position not currently occupied by a peg, and is on the gameboard itself.
* 
* 
* endRow - the row position being jumped to
* endCol - the column position being jumped to
* return - a boolean denoting whether the move is valid.
*/

public static boolean checkEndError(int endRow, int endCol){
    
//Is there a peg at end spot?
if(puzzleRep[endRow][endCol] == 1){	
    System.out.println("Illegal move, destination location is occupied");
    return false;
}

//Check top 2 corners(End)
if((endRow < 2 && endCol < 2) || (endRow < 2 && endCol > 4) ){
    System.out.println("Illegal location.");
    return false;
}

//Check bottom 2 corners(End)
if((endRow > 4 && endCol < 2) || (endRow > 4 && endCol > 4) ){
    System.out.println("Illegal location.");
    return false;
}

return true;

}
/**
 * Method used to check whether the move the user is attempting to make is indeed a valid move.
 * 
 * startRow - the row our move starts on
 * startCol - the column our move starts on
 * endRow - the row our move end on
 * endCol - the column our move ends on
 * return - a boolean whether the move is valid, or not valid, along with an appropriate error message.
 */

public static boolean checkEndMove(int startRow, int startCol, int endRow, int endCol){
    int middleRow;
    int middleCol;

    
    //Check column distance
    if(startRow == endRow){
        //Not moving, start and end are same
        if(startCol == endCol){
            System.out.println("Illegal move, no peg being jumped over, re-enter move.");
            return false;
        }
        //Not jumping a distance of 2
        if(Math.abs(startCol - endCol) !=2){
            System.out.println("Illegal move, can only jump over one peg, re-enter move.");
            return false;
        }
    }
    
    //Check row distance
    else{
        System.out.println("Also here");
        //Check for diagonal move
        if(startCol != endCol){
            System.out.println("Illegal move, can only jump over one peg, re-enter move.");
            return false;
        }
        // Not jumping a distance of 2
        if(Math.abs(startRow - endRow)!=2){
            System.out.println();
            System.out.println("Illegal move, can only jump over one peg, re-enter move.");
            return false;
        }
    }
    
    middleRow = ((startRow + endRow) / 2);
    middleCol = ((startCol + endCol) /2);
    
    //Check whether the user is actually jumping over a peg.
    if(puzzleRep[middleRow][middleCol] != 1){
        System.out.println("Illegal move, no peg being jumped over, re-enter move.");
        return false;
    }
return true;

}// End checkEnd

}