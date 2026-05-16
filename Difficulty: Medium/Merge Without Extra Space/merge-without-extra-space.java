class Solution {
    
    private int nextGap(int gap) {
        if (gap <= 1)
            return 0;

        return (gap / 2) + (gap % 2);
    }

    public void mergeArrays(int a[], int b[]) {

        int n = a.length;
        int m = b.length;

        int gap = nextGap(n + m);

        while (gap > 0) {

            int i = 0;
            int j = gap;

            while (j < n + m) {

                // Both elements in array a
                if (i < n && j < n) {

                    if (a[i] > a[j]) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }

                // One element in a and one in b
                else if (i < n && j >= n) {

                    if (a[i] > b[j - n]) {
                        int temp = a[i];
                        a[i] = b[j - n];
                        b[j - n] = temp;
                    }
                }

                // Both elements in array b
                else {

                    if (b[i - n] > b[j - n]) {
                        int temp = b[i - n];
                        b[i - n] = b[j - n];
                        b[j - n] = temp;
                    }
                }

                i++;
                j++;
            }

            gap = nextGap(gap);
        }
    }
}