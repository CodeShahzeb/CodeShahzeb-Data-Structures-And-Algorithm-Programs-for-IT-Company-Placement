 
package dynamicprogramming;

import java.util.Arrays;


public class DynamicProgramming {
    
        public static int cutRod(int price[],int n){
            int val[]=new int[n+1];
            val[0]=0;
            
            for(int i=1;i<=n;i++){
                int max_val=Integer.MIN_VALUE;
                for(int j=0;j<i;j++){
                    
                    max_val=Math.max(max_val,price[j]+val[i-j-1]);
                }
                val[i]= max_val;
            }
           
         return val[n];   
        }
        
        public static int MaximumProductOfSubarray(int arr[]){
            int pre_max=arr[0];
            int pre_min=arr[0];
            
            int curr_min=arr[0];
            int curr_max=arr[0];
            int result=arr[0];
            
            for(int i=1;i<arr.length;i++){
                curr_max=Math.max(Math.max(pre_max*arr[i],pre_min*arr[i]),arr[i]);
                curr_min=Math.min(Math.max(pre_max*arr[i],pre_min*arr[i]),arr[i]);
                
                result=Math.max(result,curr_max);
                pre_max=curr_max;
                pre_min=curr_min;
            }
            return result;
        }
        
        
    public  int change(int amount, int[] coins) {              //Coin change problem
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 0; i < coins.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return cc(coins, 0, amount, dp);
    }
   
    public int  cc(int[] coins, int i, int amount, int[][] dp){
        if(amount == 0) return 1;
        if(amount < 0 || i == coins.length) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];
       
        return dp[i][amount] = cc(coins, i, amount - coins[i], dp) + cc(coins, i + 1, amount, dp);
    }
    
    public static int UniquePathWays(int m,int n){
        int dp[][]=new int[m][n];
        
        for(int i=0;i<m;i++){                             // Finding unique paths problem
            for(int j=0;j<n;j++){
                
                if(i==0 || j==0){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=dp[i-1][j] + dp[i][j-1];
                }
                     
            }
        }
        return dp[m-1][n-1];
        
    }
    
    public static int eggDropping(int n,int k){
       int eggFloor[][]=new int[n+1][k+1];
       int result;
       
       for(int i=1;i<=n;i++){
           eggFloor[i][1]=1;
           eggFloor[i][0]=0;
           
       }
       
       for(int j=1;j<=k;k++){
           eggFloor[1][j]=j;
       }
       
       for(int i=2;i<=n;i++){
           
           for(int j=2;j<=k;k++){
              eggFloor[i][j] = Integer.MAX_VALUE; 
              
              for (int x = 1; x <= j; x++) { 
                  
                   result = 1 + Math.max(eggFloor[i - 1][x - 1],eggFloor[i][j - x]); 
                   if (result < eggFloor[i][j]) 
                        eggFloor[i][j] = result; 
                } 
           }
       }
       return eggFloor[n][k];
    }
    
    public static int StairCaseWays(int arr[],int n){
        int staircase[]=new int[n+1];
         
           if(n==0){
               return 1;
            }
           staircase[0]=1;
           
           for(int i=1;i<=n;i++){
               int total=0;
               for(int j:arr){
                   if(i-j>=0){
                       total +=staircase[i-j];
                   }
               }
               staircase[i]=total;
               
           }
          return staircase[n];
    }
    
    // Painter Problem
    public static int Sum(int arr[],int from ,int to){
        int total=0;
        for(int i=from ;i<=to;i++){
            total +=arr[i];
        }
        return total;
    }
    
    public int  findMax(int arr[],int n,int k){
        int dp[][]=new int[k+1][n+1];
        
        for(int i=1;i<=n;i++){     //k==1
            dp[1][i]=Sum(arr,0,i-1);  
        }
        
        for(int i=1;i<=k;i++){  //n==1
            dp[i][1]=arr[0];
        }
        
        for(int i=2;i<=k;i++){
            for(int j=2;j<=n;j++){
                
                int best=Integer.MAX_VALUE; 
                
                for(int p=1;p<=j;p++){
                    best=Math.min(best,Math.max(dp[i-1][p],Sum(arr,p,j-1)));
                }
                dp[i][j]=best;
            }
        }
        return dp[k][n];
    }
    
    public static int HouseRobber(int arr[]){
        if(arr==null || arr.length==0){
            return 0;
        }
        if(arr.length==2){
            return Math.max(arr[0],arr[1]);
        }
        
        int dp[]=new int[arr.length];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(arr[i]+dp[i-2],dp[i-1]);
        }
        return dp[arr.length];
    }
    
    
     public int maxCoins(int[] nums) {
        int array[] = new int[nums.length + 2];
        array[0] = 1;
        array[array.length-1] = 1;
        for (int i = 0; i < nums.length; i++) {
            array[i+1] = nums[i];
        }

        // Initialize DP arrays, 1 index based
        int dp[][] = new int[array.length][array.length]; //dp[i][j] stands for max coins at i step, burst j
        for (int i =0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i=1; i< array.length-1; i++) {
            for (int j=i; j >=1; j--) {
                // k as last
                for (int k=j; k <= i; k++) {
                    dp[j][i] = Math.max(array[j-1]*array[k]*array[i+1] + dp[j][k-1] + dp[k+1][i], dp[j][i]);
                }
            }
        }

        return dp[1][array.length-2];
    }
     
     
     static int editDistDP(String str1, String str2, int m, int n) 
    { 
        int dp[][] = new int[m + 1][n + 1]; 
  
        for (int i = 0; i <= m; i++) { 
            for (int j = 0; j <= n; j++) { 
               
                if (i == 0) 
                    dp[i][j] = j; 
  
                else if (j == 0) 
                    dp[i][j] = i; 
   
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) 
                    dp[i][j] = dp[i - 1][j - 1]; 
  
               
                else
                    dp[i][j] = 1 + Math.min(Math.max(dp[i][j - 1],dp[i - 1][j]), dp[i - 1][j - 1]); 
            } 
        } 
  
        return dp[m][n]; 
    } 
     
     
     
     static boolean isSubsetSum(int set[],int n, int sum) 
    { 
        boolean subset[][] = new boolean[sum + 1][n + 1]; 
  
        for (int i = 0; i <= n; i++) 
            subset[0][i] = true; 
  
        for (int i = 1; i <= sum; i++) 
            subset[i][0] = false; 
  
        for (int i = 1; i <= sum; i++) { 
            for (int j = 1; j <= n; j++) { 
                subset[i][j] = subset[i][j - 1]; 
                if (i >= set[j - 1]) 
                    subset[i][j] = subset[i][j] 
                                   || subset[i - set[j - 1]][j - 1]; 
            } 
        } 
  
        return subset[sum][n]; 
    } 
     
    static boolean findPartition (int arr[], int n) 
    { 
        int sum = 0; 
        int i, j; 
  
        // Calculate sum of all elements 
        for (i = 0; i < n; i++) 
            sum += arr[i]; 
  
        if (sum%2 != 0) 
            return false; 
  
        boolean part[][]=new boolean[sum/2+1][n+1]; 
  
        // initialize top row as true 
        for (i = 0; i <= n; i++) 
            part[0][i] = true; 
  
        // initialize leftmost column, except part[0][0], as 0 
        for (i = 1; i <= sum/2; i++) 
            part[i][0] = false; 
  
        // Fill the partition table in botton up manner 
        for (i = 1; i <= sum/2; i++) 
        { 
            for (j = 1; j <= n; j++) 
            { 
                part[i][j] = part[i][j-1]; 
                if (i >= arr[j-1]) 
                    part[i][j] = part[i][j] || 
                                 part[i - arr[j-1]][j-1]; 
            } 
        } 
  
        return part[sum/2][n]; 
    } 
    
    
    public int PerfectSQuare(int n){
        
        int dp[]=new int[n+1];
        dp[0]=0;
        for(int i=0;i<=n;i++){
            
          for(int j=1;j*j<=i;j++){
           
             dp[i]=i;
             dp[i]=Math.min(dp[i],1+dp[i-j*j]);
            
        }
        }
        return dp[n];
    }
    
    public int MaximalSquareMatrix(int matrix[][],int rows,int columns){
         
        if(rows==0){
            return 0;
        }
        
        int dp[][]=new int[rows+1][columns+1];
        
        int largest=0;
      
      for(int i=1;i<=rows;i++){
          for(int j=1;j<=columns;j++){
              
              if(matrix[i-1][j-1]=='1'){
                  
                  dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                  
                  if(largest<dp[i][j]){
                      
                      largest=dp[i][j];
                  }
              }
          }
      }
      return largest*largest;
    }
    
    public int MatrixChainMultiplication(int dims[],int i,int j){
        
        int T[][]=new int[i][j];
        if(j<=i+1){
            return 0;
        }
        
        int min=Integer.MAX_VALUE;
        
        if(T[i][j]==0)
        {
        for(int k=1;k<=j-1;k++){
            int cost=MatrixChainMultiplication(dims,i,k);
            cost +=MatrixChainMultiplication(dims,k,j);
            cost +=dims[i]*dims[k]*dims[j];
            
            if(cost<min){
                min=cost;
            }
        }
        T[i][j]=min;
        
    }
     return T[i][j];   
    }
    
     static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int i, w; 
        int K[][] = new int[n + 1][W + 1]; 
  
        for (i = 0; i <= n; i++) { 
            for (w = 0; w <= W; w++) { 
                if (i == 0 || w == 0) 
                    K[i][w] = 0; 
                else if (wt[i - 1] <= w) 
                    K[i][w] = Math.max( 
                        val[i - 1] + K[i - 1][w - wt[i - 1]], 
                        K[i - 1][w]); 
                else
                    K[i][w] = K[i - 1][w]; 
            } 
        } 
  
        return K[n][W]; 
    } 
     
    
    int lcs( char[] X, char[] Y, int m, int n ) 
  { 
    int L[][] = new int[m+1][n+1]; 
  
    for (int i=0; i<=m; i++) 
    { 
      for (int j=0; j<=n; j++) 
      { 
        if (i == 0 || j == 0) 
            L[i][j] = 0; 
        else if (X[i-1] == Y[j-1]) 
            L[i][j] = L[i-1][j-1] + 1; 
        else
            L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
      }
      
    } 
  return L[m][n]; 
  }  
    
    
    
    
    public static void main(String[] args) {
        DynamicProgramming  d=new DynamicProgramming();
    
       
    }
    
}
 
