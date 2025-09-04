/*
 * 
 * Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104
 * 
 * 
 */



 class Solution {
    public boolean validMountainArray(int[] arr) {
        boolean Valid = false;
        boolean valid1 = false;
        boolean valid2 = false;

        //arr.length >= 3
        if(arr.length >= 3){
        int highestValue = 1;
        int highestValueIndex = 0;


        for(int i =0;i< arr.length;i++){

            if(arr[i]> highestValue){
                // determine the "peak" of our mountain
                highestValue = arr[i];
                highestValueIndex = i;
                System.out.println("highest value is: " + highestValue);
                System.out.println("highest value index: " + highestValueIndex);
            }
        }


            // arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
            // check if slope is constantly increasing before peak
            for(int j=0;j<highestValueIndex;j++){
                System.out.println("Checking: arr[" + j + "]=" + arr[j] + " < arr[" + (j+1) + "]=" + arr[j+1]);
                if(arr[j] < highestValue && arr[j]< arr[j+1]){
                valid1 = true;
                System.out.println("Condition 1 met!");
                }else if(arr[j] >= arr[j+1] || arr[j] > highestValue){
                    // if slope isnt constantly increasing, test fails
                    valid1 = false;
                    break;
                }
            }


            // arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
            // check if slope is constantly decreasing after peak
            for(int m=highestValueIndex+1;m<arr.length;m++){
                if(arr[m]< arr[m-1]){
                valid2 = true;
                System.out.println("Condition 2 met!");
                }else if(arr[m]== highestValue || arr[m] >= arr[m-1]){
                    // if slope isnt constantly decreasing, test fails
                    valid2 = false;
                    break;
                }
            }
            // only if both tests pass do we have a mountain
            if(valid1 && valid2){
                Valid = true;
            }

        }
        
        


        return Valid;
    }
}