class Solution {

    String helper(String s, String t, int n) {
        int[][] dp = new int[n + 1][n + 1];

        int maxi = 0;
        int endIndex = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    int startIndex = i - dp[i][j];
                    int reverseIndex = j - dp[i][j];

                    if (startIndex + dp[i][j] == n - reverseIndex) {

                        if (dp[i][j] > maxi) {
                            maxi = dp[i][j];
                            endIndex = i - 1;
                        }
                    }

                } else {
                    dp[i][j] = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < maxi; k++) {
            sb.append(s.charAt(endIndex));
            endIndex--;
        }

        return sb.reverse().toString();
    }

    public String longestPalindrome(String s) {

        int n = s.length();

        String t = new StringBuilder(s).reverse().toString();

        return helper(s, t, n);
    }
}