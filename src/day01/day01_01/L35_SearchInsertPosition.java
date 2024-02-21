package day01.day01_01;

/**
 * Leetcode 35 Search Insert Positon
 * Binary Search 变种， 同样的方法，过两个例子就知道了
 * index    0  1  2  3  4
 * input = [1, 3, 5, 7, 9] target = 6
 * round 1: left = 0, right = 4, mid = 2, input[2] = 5 < 6, left = mid + 1 = 3
 * round 2: left = 3, right = 4, mid = 3, input[3] = 7 > 6, right = mid - 1 = 2
 * round 3: left = 3, right = 2, while loop is done.
 * return 3
 *
 * index    0  1  2  3
 * input = [1, 3, 5, 6] target = 2
 * round 1: left = 0, right = 3, mid = 1, input[1] = 3 > 2, right = mid - 1 = 0
 * round 2: left = 0, right = 0, mid = 0, input[0] = 1 < 2, left = mid + 1 = 1
 * round 3: left = 1, right = 0, while loop is done.
 * return 1
 *
 * 从这两个例子发现，当input中不存在target时， target总是插在left指针所在为止，所以最终return left即可
 *
 * T = O(log n)
 * S = O(1)
 * n is the size of input array
 */
public class L35_SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,6,9,10};
        System.out.println(bs(nums, 2)); //1
        System.out.println(bs(nums, 6)); //2
        System.out.println(bs(nums, 8)); //3
        System.out.println(bs(nums, 12));  //5
        System.out.println(bs(new int[0], 8));//0

    }
    private static int bs(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2; //avoid integer overflow
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left; //和binary search 唯一不同的地方
    }
}
