import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String haystack = sc.nextLine();
        System.out.print("Enter the substring to search: ");
        String needle = sc.nextLine();
        int[] nextTable = calcNextTable(needle);

        int i = 0;
        while(i <= haystack.length() - needle.length()) {
            int j = 0;
            while(j < needle.length() && (haystack.charAt(i + j) == needle.charAt(j))) {
                j++;
            }
            if(j == needle.length()) {
                System.out.println("Found " + needle + " at index " + i);
                return;
            }
            else {
                int k = nextTable[j];
                if(k == -1) i = i + j + 1;
                else if(k > 0) i += j - k;
                else i++;
            }
        }
        System.out.println("Substring not found");
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
