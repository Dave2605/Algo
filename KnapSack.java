/**
 * Created by dave on 29.06.17.
 */
public class KnapSack {

    public static void main(String[] args) {
        int[] originalArr=new int[] { 11,12,7,6,5};
        int[] target=knapSack(originalArr,23);
        for (int i : target) {
            System.out.println(i);
        }
    }

    public static int[] knapSack(int[] originalArr,int target) {
        int targetArr[]=new int[originalArr.length];
        int targetCounter;
        int sum;

        outer:
        for(int i=0;i<originalArr.length;i++) {
            sum=0;targetCounter=0;
            int elem=originalArr[i];
            targetArr[targetCounter]=elem;
            sum+=elem;

            for(int k=i;k<originalArr.length;k++) {
                sum=0;targetCounter=0; targetArr=new int[originalArr.length];
                targetArr[targetCounter]=elem;
                sum+=elem;

                for(int j=k+1;j<originalArr.length;j++) {
                    sum=sum+ originalArr[j];

                    if(sum < target) {
                        targetCounter++;
                        targetArr[targetCounter]=originalArr[j];
                    }

                    if(sum > target) {
                        sum=sum-originalArr[j];
                        continue;
                    }

                    if(sum==target) {
                        targetCounter++;
                        targetArr[targetCounter]=originalArr[j];
                        break outer;
                    }
                }
            }
        }
        return targetArr;
    }
}

class Knapsack2 {
    public int[] arr = {11,8,7,6,5};
    public int[] retArr = new int[5];
    int i = 0;
    public boolean problem(int sum, int pick) {
        if(pick == arr.length) {
            return false;
        }
        if(arr[pick] < sum) {
            boolean r = problem(sum - arr[pick], pick+1);
            if(!r) {
                return problem(sum, pick+1);
            } else {
                retArr[i++] = arr[pick];
                return true;
            }
        } else if (arr[pick] > sum) {
            return problem(sum, pick+1);
        } else {
            retArr[i++] = arr[pick];
            return true;
        }
    }

    public static void main(String[] args) {
        Knapsack2 rk = new Knapsack2();
        if(rk.problem(20, 0)) {
            System.out.println("Success " );
            for(int i=0; i < rk.retArr.length; i++)
                System.out.println(rk.retArr[i]);
        }
    }

}
