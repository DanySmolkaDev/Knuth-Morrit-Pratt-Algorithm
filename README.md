# Optimized KMP string search implementation
A high performance implementation of the Knuth-Morris-Pratt(KMP) algorithm made in Java, 
featuring an optimized failure function(next table) with look-ahead logic to minimize
redundant comparisons.

# Complexity analysis
Next table time:O(n) where n is the length of the needle

Search time: O(h) where h is the length of the haystack

Space complexity: O(n) to store the next table

# Usage
This implementation is designed as a reusable utility.

-----------
```java
String haystack = "ABABDABACDABABCABAB";

String needle = "ABABCABAB";

int result = KMP.search(haystack, needle);

if (result != -1) {
    System.out.println("Pattern found at index: " + result);
}
```
# Next table function
The core of this algorithm is the calcNextTable method. It constructs the symmetry table
using a -1 base-index convention.

Needle: ABACD

| Index  | Character | Next Table |
|--------|-----------|------------|
| 0      | A         | -1         |
| 1      | B         | 0          |
| 2      | A         | -1         |
| 1      | C         | 1          |
| 0      | D         | 0          |
