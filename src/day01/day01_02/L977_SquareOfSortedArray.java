package day01.day01_02;

/**
 * Leetcode 977 有序数组的平方，如果input中都是正数，直接linear scan 取每个元素的平方即可，
 * 但实际input中有正有负数，平方之后结果还要保证是有序数组，用O（n）时间
 * 暴力解法： linear scan每个元素， 取平方之后放回原位置，然后排序，时间是O（nlogn）比较慢
 * 遇到有序数组，还是双指针，两个指针相向而行，为什么
 * e.g.input = [-5, -4， -2， 1, 2, 3]
 * 去平方之后 [25,16，4，｜  1, 4, 9]
 *            负数平方->  <-正数平方
 *  得到的平方之是两边最大，然后往中间越来越小，所以可以用双指针，相向而行，得到由大到小的结果
 *  自我理解我们可以把input每个元素平方之后的新数组看作是两个数组，负数平方得到descending数组，正数平方得到ascending数组
 *  对这两个数组进行合并，方法就是‘谁大移谁’，放到新数组中去，这里不能in-place，因为原数组的元素会被覆盖
 *  因为结果要求是升序排列，所以要从后往前放
 *  所以最终我们用到3个指针，left，right用于scan每个元素，还有一个k，是用来跟踪最终结果，k初始值是n-1
 *
 * 谁大移谁：
 * case 1: input[left]*input[left] > input[right]*input[right],说明左半边数组的元素大，左边的放到最终结果
 * case 2: input[left]*input[left] <= input[right]*input[right],说明右半边数组的元素大，右边的放到最终结果
 *
 * T = O(n)
 * S = O(n)
 * n is the size of input array
 */
public class L977_SquareOfSortedArray {
    public static void main(String[] args) {


    }
    private static int[] square(int[] nums){
        if(nums == null || nums.length == 0){
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        int k = nums.length - 1;
        int[] result = new int[nums.length];
        while(left <= right){
            if(nums[left] * nums[left] > nums[right]*nums[right]){
                result[k] = nums[left] * nums[left];
                left++;
                k--;
            }else{
                result[k] = nums[right] * nums[right];
                right--;
                k--;
            }
        }
        return result;

    }
}
