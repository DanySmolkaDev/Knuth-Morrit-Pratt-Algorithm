import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(calcNextTable("011011")));
    }
    public static int[] calcNextTable(String needle){
        int[] values = new int[needle.length()];
        values[0] = -1;

        int i = 0;
        int j = -1;

        while(i < needle.length() - 1){
            if(j == -1 || needle.charAt(i) == needle.charAt(j)){
                i++;
                j++;

                if(needle.charAt(i) == needle.charAt(j)){
                    values[i] = values[j];
                }
                else{
                    values[i] = j;
                }
            }
            else{
                j = values[j];
            }
        }
        return values;
    }
}
