class Solution {
  public:
    int minJumps(vector<int>& arr) {
        int n = arr.size();

        // If array has only one element
        if (n == 1)
            return 0;

        // Cannot move anywhere
        if (arr[0] == 0)
            return -1;

        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;

        for (int i = 1; i < n; i++) {

            // Reached the end
            if (i == n - 1)
                return jumps;

            maxReach = max(maxReach, i + arr[i]);

            steps--;

            // No steps left
            if (steps == 0) {
                jumps++;

                // Cannot move further
                if (i >= maxReach)
                    return -1;

                steps = maxReach - i;
            }
        }

        return -1;
    }
};