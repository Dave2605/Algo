import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dave on 04.07.17.
 */
public class Combinations {

    public static void permGen(char[] s,int i,int k,char[] buff) {
        if(i<k) {
            for(int j=0;j<k;j++) {
                buff[i] = s[j];
                permGen(s,i+1,k,buff);
            }
        }
        else if (i == 3){
            System.out.println(buff);
        }
    }

    public static void main(String[] args) {
        String string = "cat";
        char[] buff = new char[string.length()];
        int k = string.length();
        for(int i=1;i<=k;i++) {
            permGen(string.toCharArray(),0,i,buff);
        }
        System.out.println(buff);
    }
}

class test {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args){
        String[] arr = {"A","B","C","D","E","F"};
        combinations2(arr, 4, 0, new String[4]);
        System.out.println(set);
    }

    static void combinations2(String[] arr, int len, int startPosition, String[] result){
        if (len == 0){
            set.add(Arrays.toString(result));
            return;
        }
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }
}
