//USING DP ARRAY
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [] dp = new int[n + 1];
        int max = 0;
        int prev = 0;
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i- 1][j - 1] == '1'){
                    int temp = dp[j];
                    dp[j] = Math.min(dp[j], Math.min(dp[j - 1], prev)) + 1;
                    max = Math.max(max, dp[j]);
                    prev = temp;
                }else{
                    dp[j] = 0;
                }    
            }
        }
        return max * max;
    }
}
TIME COMPLEXITY = O(mn)
SPACE COMPLEXITY = O((m+1)(n+1))

=============================================================================================
USING DP MATRIX 

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dp = new int [m + 1][n + 1];
        int max = 0;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(matrix[i- 1][j - 1] == '1'){
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }    
            }
        }
        return max * max;
    }
}

TIME COMPLEXITY = O(mn)
SPACE COMPLEXITY = O(n)
