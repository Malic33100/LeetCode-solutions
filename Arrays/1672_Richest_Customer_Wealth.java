/*
 * LeetCode #1672: Richest Customer Wealth
 * Difficulty: Easy
 * Topics: Array, Matrix
 * 
 * Problem Summary: Given a 2D array where accounts[i][j] is the amount of 
 * money the ith customer has in the jth bank, return the wealth of the richest customer.
 * 
 * Approach: Iterate through each customer, calculate their total wealth by summing
 * all their accounts, and track the maximum wealth seen so far.
 * 
 * Time Complexity: O(m * n) where m = customers, n = accounts per customer
 * Space Complexity: O(1) - only using variables for tracking
 * 
 * Key Insights: 
 * - Simple nested loop problem - good practice with 2D arrays
 * - Need to reset sum for each customer
 * - Track running maximum rather than storing all sums
 */

class Solution {
    public int maximumWealth(int[][] accounts) {
        int wealth = 0;
        int wealthBar = 0;
        int[] test = new int[accounts.length];

        for(int i = 0; i < accounts.length; i++){

            for(int j = 0; j < accounts[i].length; j++){
            wealthBar +=  accounts[i][j];   
            }
            test[i] = wealthBar;
            wealthBar = 0;
        }

        wealth = test[0];

        for(int m = 1; m < test.length; m++){
            if(wealth < test[m]){
                wealth = test[m];
            }
            else{
                continue;
            }
        }

        return wealth;
    }
}
