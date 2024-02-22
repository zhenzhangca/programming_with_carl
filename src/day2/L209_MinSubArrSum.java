package day2;

/**
 * Leetcode 209 Minimum Size Sub-array Sum
 * 求元素之和大于等于target的最短子数组
 * e.g. input = [2,3,1,2,4,3] target = 7
 *      output = 2  [4,3]
 * 方法： 装指针维护一个滑动窗口，
 * case 1: 窗口内的元素之和大于等于target，记录下当前时刻的globalMin，然后sum -= input[slow], slow++，即缩小窗口
 * case 2: 窗口内的元素之和小于target，直接扩大窗口，即sum += input[fast]， fast++
 * 过例子：
 * index    0  1  2  3  4  5
 * input = [2, 3, 1, 2, 4, 3]
 * 初始slow = 0 fast = 0 fast is tracking pointer sum = 0 globalMin = 0;
 * round 1: slow = 0, fast = 0, sum = 0, globalMin = MAX_VALUE, sum += input[fast] = 0 + 2 = 2 < 7 fast++
 * round 2: slow = 0, fast = 1, sum = 2, globalMin = MAX_VALUE, sum += input[fast] = 2 + 3 = 5 < 7 fast++
 * round 3: slow = 0, fast = 2, sum = 5, globalMin = MAX_VALUE, sum += input[fast] = 5 + 1 = 6 < 7 fast++
 * round 4: slow = 0, fast = 3, sum = 6, globalMin = MAX_VALUE, sum += input[fast] = 6 + 2 = 8 >= 7
 *      接下来要缩小窗口，直到sum小于target(while stop)
 *      round 4.1 先记录sum >= 7 这一刻的globalMin = min(globalMin, fast - slow + 1) = 4
 *      sum =sum - input[slow] = 8 - 2 = 6;
 *      slow++ = 1
 *      sum < target, while stop
 * fast++ = 4
 * round 5: slow = 1, fast = 4, sum = 6, globalMin = 4, sum += input[fast] = 6 + 4 = 10 >= 7
 *      while loop 缩小窗口，直到sum < target
 *      round 5.1 先记录这一刻globalMin = min(globalMin, fast - slow + 1) = min(4, 4) = 4
 *      sum = sum - input[slow] = 10 - 3 = 7
 *      slow++ = 2
 *      round 5.2 sum >= target, while
 *      globalMin = min(4, 3) = 3
 *      sum = sum - input[slow] = 7 - 1 = 6
 *      slow++ = 3
 *      sum < target, while stop
 * fast++ = 5
 * round 6: slow = 3, fast = 5, sum = 6, globalMin = 3, sum += input[fast] = 6 + 3 = 9 >= 7
 *      while loop until sum < target
 *      round 6.1 globalMin = min(3, 3) = 3
 *      sum = sum - input[slow] = 9 - 2 = 7
 *      slow++ = 4
 *      round 6.2 sum >=target, while
 *      globalMin = min(3, 2) = 2
 *      sum = sum - input[slow] = 8 - 4 = 4
 *      slow++ = 5
 *      sum < target, while stop
 * fast++ = 6
 * 结束，最终结果 globalMin= 2
 *
 *
 * T = O(n)
 * S = O(1)
 * n is the size of input array
 */
public class L209_MinSubArrSum {
    public static void main(String[] args) {
        int[] nums = {1,3,6,9,10};
        System.out.println(minSubArrSum(new int[]{2,3,1,2,4,3}, 7)); //2
        System.out.println(minSubArrSum(new int[]{1,4,4}, 4)); //1
        System.out.println(minSubArrSum(new int[]{1,1,1,1,1,1,1}, 11)); //0
        System.out.println(minSubArrSum(new int[0], 8));//0

    }
    private static int minSubArrSum(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int globalMin = Integer.MAX_VALUE;
        int slow = 0;
        int sum = 0;
        int fast = 0;
        while(fast < nums.length){
            sum += nums[fast];
            while(sum >= target){
                globalMin = Math.min(globalMin, fast - slow + 1);
                sum -= nums[slow];
                slow++;
            }
            fast++;
        }
        return globalMin == Integer.MAX_VALUE? 0: globalMin; //如果globalMin在while中没有被复制，说明没有找到符合条件的sub-array，return0
    }
}
