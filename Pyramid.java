import static java.lang.StrictMath.log10;

/**
 * Created by dave on 05.07.17.
 */
public class Pyramid {
    public static void main(String[] args) {
            int lines;
            double a;

            a = log10(16*2)/log10(2);
            lines = (int)a;
            char array[][] = new char[5][16] ;

            makeBranches(0, 15, array, 0);
            display(array, lines);
        }

    static void makeBranches(int left, int right, char a[][], int line){

        if(left >= right){
            a[line][left] = 'X';
            return;
        } else{
            a[line][(right+left)/2] = 'X';
            makeBranches(left, (right+left)/2, a, line+1);
            makeBranches((right+left)/2+1, right, a, line+1);
        }
    }

    static void display(char a[][], int lines){
        int i, j;

        for(i = 0; i < lines; i++){
            for(j = 0; j < 16; j++){
                if(a[i][j] == 'X')
                    System.out.print((a[i][j]));
                else
                    System.out.print("-");
            }
            System.out.println(("\n"));
        }
    }
}
