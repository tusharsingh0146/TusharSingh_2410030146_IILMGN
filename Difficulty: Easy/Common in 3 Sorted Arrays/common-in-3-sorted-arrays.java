class Solution {
    ArrayList<Integer> commonElements(int a[], int b[], int c[]) {

        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        int lastAdded = Integer.MIN_VALUE;

        while (i < a.length && j < b.length && k < c.length) {

            int x = a[i];
            int y = b[j];
            int z = c[k];

            // If all are equal
            if (x == y && y == z) {

                if (res.size() == 0 || res.get(res.size() - 1) != x) {
                    res.add(x);
                }

                i++;
                j++;
                k++;
            }

            // Move the smallest pointer
            else if (x <= y && x <= z) {
                i++;
            }
            else if (y <= x && y <= z) {
                j++;
            }
            else {
                k++;
            }

            // Skip duplicates in each array
            while (i > 0 && i < a.length && a[i] == a[i - 1]) i++;
            while (j > 0 && j < b.length && b[j] == b[j - 1]) j++;
            while (k > 0 && k < c.length && c[k] == c[k - 1]) k++;
        }

        return res;
    }
}