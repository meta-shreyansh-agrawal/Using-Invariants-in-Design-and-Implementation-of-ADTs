import java.util.HashMap;
import java.util.Map;

public class SparseMatrices{
    HashMap<Position,Integer> matric = new HashMap<>(); 
    int rows = 0; 
    int columns = 0; 

    SparseMatrices(int[][] newMatric){
        if(newMatric.length==0)return; 
        rows = newMatric.length; 
        columns = newMatric[0].length; 
        for(int i = 0;i<newMatric.length;i++){
            for(int j = 0; j<newMatric[0].length;i++){
                if(newMatric[i][j]!=0){
                    Position p = new Position(i, j); 
                    matric.put(p, newMatric[i][j]); 
                }
            }
        }
    }

    public int[][] transpose(){
        int[][] matrix = new int[columns][rows];
        matric.forEach((key,value)->{
            matrix[key.column][key.row] = value; 
        }); 
        return matrix; 
    }

    public int[][] toMatrix(){
        int[][] matrix = new int[rows][columns];
        matric.forEach((key,value)->{
            matrix[key.row][key.column] = value; 
        }); 
        return matrix; 
    }

    public boolean isSymmetrical(){
        for(Map.Entry<Position,Integer> set: matric.entrySet()){
            Position p = set.getKey();
            Integer v = set.getValue(); 
           if( matric.get(new Position(p.column, p.row))!=v){
                return false; 
           }  
        }
        return true; 
    }

    public int[][] add(int[][] newMatric){
        if(newMatric.length!=rows||newMatric[0].length!=columns)throw new IllegalArgumentException("Enter matric with same dimensions as main matric"); 
        for(Map.Entry<Position,Integer> set: matric.entrySet()){
            Position p = set.getKey();
            Integer v = set.getValue(); 
            newMatric[p.row][p.column] += v;    
        }
        return newMatric; 
    }

    public int[][] multiply(int[][] newMatric){
        int rowSize = Math.min(rows,newMatric.length); 
        int columnSize = Math.min(columns,newMatric[0].length); 
        int[][] ans = new int[rowSize][columnSize];

        for(int i = 0; i<rowSize; i++){
            for(int j = 0; j<columnSize; j++){
                int value = 0; 
                for(int k = 0; k<Math.min(rowSize,columnSize);k++){
                    value += newMatric[i][k]*matric.get(new Position(k, j)); 
                }
                newMatric[i][j] = value; 
            }
        }
        return ans; 
    }

}