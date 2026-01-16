public class KMPSearch {

    /**
     *Searches for the first occurrence of needle in haystack
     * @param haystack the main string
     * @param needle the substring to search for
     * @return starting index of needle, or -1 if not found
     */
    public static int search(String haystack, String needle) {
        if(haystack == null || needle == null || needle.isEmpty()) return -1;
        if(haystack.length() < needle.length()) return -1;

        int[] nextTable = calcNextTable(needle);
        int i = 0;

        while(i <= haystack.length() - needle.length()) {
            int j = 0;
            while(j < needle.length() && (haystack.charAt(i + j) == needle.charAt(j))) {
                j++;
            }
            if(j == needle.length()) {
                System.out.println("Found " + needle + " at index " + i);
                return i;
            }
            else {
                int k = nextTable[j];
                if(k == -1) i = i + j + 1;
                else if(k > 0) i += j - k;
                else i++;
            }
        }
        return -1;
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
