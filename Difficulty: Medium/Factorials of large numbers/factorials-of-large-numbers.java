import java.util.*;

class Solution {
    
    static ArrayList<Integer> factorial(int n) {
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);

        for (int x = 2; x <= n; x++) {
            multiply(res, x);
        }

        return res;
    }

    static void multiply(ArrayList<Integer> res, int x) {
        int carry = 0;

        // multiply from right to left
        for (int i = res.size() - 1; i >= 0; i--) {
            int prod = res.get(i) * x + carry;
            res.set(i, prod % 10);
            carry = prod / 10;
        }

        // add remaining carry at front
        while (carry > 0) {
            res.add(0, carry % 10);
            carry /= 10;
        }
    }
}