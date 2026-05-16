import java.util.*;

class Solution {
    
    public boolean isSubset(int a[], int b[]) {
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        // count frequency of elements in a[]
        for (int x : a) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        
        // check for b[]
        for (int x : b) {
            
            if (!freq.containsKey(x) || freq.get(x) == 0) {
                return false;
            }
            
            freq.put(x, freq.get(x) - 1);
        }
        
        return true;
    }
}