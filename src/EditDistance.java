import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Siddhant
 * Date: 7/6/16
 * Time: 1:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class EditDistance {
    String original;
    String converted;

    EditDistance(String original,String converted){
        this.original = original;
        this.converted = converted;
    }
    public static String inputString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private int min(int a,int b,int c){
        int temp = a<=b?a : b;
        return temp<=c?temp:c;
    }
    private boolean equalChars(int i,int j){
        if(original.charAt(j-1)==converted.charAt(i-1)) return true;
        return false;
    }
    private int setValue(int dp_matrix[][],int i,int j){
        if(equalChars(i,j)) return dp_matrix[i-1][j-1];
        return min(dp_matrix[i-1][j-1],dp_matrix[i-1][j],dp_matrix[i][j-1]) + 1;

    }
    public int calculateEditDistance(){
        int cols = original.length()+1;
        int rows = converted.length()+1;
        int dp_matrix[][] =  new int[rows][cols];
        for(int i=0;i<cols;i++){
            dp_matrix[0][i] = i;
        }
        for(int i=0;i<rows;i++){
            dp_matrix[i][0] = i;
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
               dp_matrix[i][j] = setValue(dp_matrix,i,j);
               System.out.print(dp_matrix[i][j]+" ");
            }
            System.out.println("");
        }

        return dp_matrix[rows-1][cols-1];
    }
    public static void main(String... s ){
        System.out.println( new EditDistance(EditDistance.inputString(),EditDistance.inputString()).calculateEditDistance());
    }

}
