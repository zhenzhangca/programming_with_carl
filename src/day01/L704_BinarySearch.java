package day01;

/**
 * Leetcode 704 Binary Search
 * 在有序数组中找target元素，存在返回index， 不存在返回-1
 * @params: int[] nums, int target
 * input array is ascending order， no duplicates
 * 思路：两个指针相向而行，搜索区间[left, right], 左闭右闭，每一轮搜索范围减半，排除掉不包含target number的那一半
 * T = O(log n)
 * S = O(1)
 * n is the size of input array
 */
public class L704_BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,3,6,9,10};
        System.out.println(bs(nums, 5));
        System.out.println(bs(nums, 6));
        System.out.println(bs(new int[0], 8));
        System.out.println(bs(null, 7));
    }
    private static int bs(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        /**
         * challenge: 为什么不是left<right
         * 举例验证： 假设input = {5}, target = 5, expected result = 0
         * in this case: left = 0, right = 0
         * 如果用 left < right, while 循环进不去，得到错误结果-1
         */
        while(left <= right){
            int mid = left + (right - left) / 2; //avoid integer overflow
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                /**
                 * challenge：为什么不是right = mid 或left = mid
                 * 举例验证： 假设input= {5}, target = 7, expected result = -1
                 * in this case： left = 0， right = 0
                 * while（left <= right) 可以进去， mid = 0， input[mid] = 5 < 7, left = mid = 0
                 * 下一轮还是left = 0， right = 0， while会死循环
                 * 另一方面：input[mid]> target or input[mid] < target 的情况，说明input[mid]一定不是答案，可以直接排除掉
                 */
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
