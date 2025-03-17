public class Position {

    int row;
    int column; 

    Position(int row, int column)throws IllegalArgumentException{
        if(row<0||column<0)throw new IllegalArgumentException("Enter valid row and column"); 
        this.row = row; 
        this.column = column; 
    }
}