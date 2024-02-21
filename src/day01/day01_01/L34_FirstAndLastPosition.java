package day01.day01_01;

/**
 * Leetcode 34 Find First and Last Position of Element in Sorted Array
 * Binary Search 变种， Binary Search 是在一个没有重复元素的sorted input中找给定的target，返回的index要么有，就只有一个，要么没有就返回-1
 * 这个题是在有重复元素的sorted input中找给定的target，即target的位置不止一个，返回首位两个index
 * <p>
 * 这个题和Binary Search 的区别是找到了target还不能停，要继续往左找 或者 继续往右找
 * while循环的停止条件是当input还剩两个元素的时候，停止，之后做post processing
 * <p>
 * T = O(log n)
 * S = O(1)
 * n is the size of input array
 */
public class L34_FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,3,3,6,6,6,6,9,10};
        System.out.println(findFirstAndLast(nums, 2)[0] +"->" + findFirstAndLast(nums, 2)[1] ); //[-1,-1]
        System.out.println(findFirstAndLast(nums, 3)[0] +"->" + findFirstAndLast(nums, 3)[1]); //[1,3]
        System.out.println(findFirstAndLast(nums, 8)[0] +"->" + findFirstAndLast(nums, 8)[1]); //[-1,-1]
        System.out.println(findFirstAndLast(nums, 6)[0] +"->" + findFirstAndLast(nums, 6)[1]);  //[4,7]
        System.out.println(findFirstAndLast(null, 2)[0] +"->" + findFirstAndLast(null, 2)[1]);//[-1, -1]

    }

    private static int[] findFirstAndLast(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int first = firstPosition(nums, target, 0, nums.length);
        int last = lastPosition(nums, target, 0, nums.length);
        return new int[]{first, last};
    }

    /**
     * find first position
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    private static int firstPosition(int[] nums, int target, int left, int right){
        /**
         * 当[left,right]闭区间内还剩两个元素是停止while循环，做post processing
         * 因为是找不确定的元素index
         */
        while(left < right - 1){
            int mid = left + (right - left) / 2; //avoid integer overflow
            if(nums[mid] == target){
                /**
                 * 不能停，继续往左找，此处不能用right=mid - 1
                 * 因为不能确定nums [mid]这个值是不是第一次出现的，可能是，也可能不是，如果用mid-1， 就错误的排除掉正确答案了
                 * 另外，用right = mid也不会出现binary search那样的死循环，因为input还剩两个元素时，就提前结束循环了
                 */
               right= mid;
            }else if(nums[mid] > target){
                right = mid - 1; //不是target， 可以放心大胆的排除
            }else{
                left = mid + 1;
            }
        }
        //post-processing, check left first, because searching first position
        if(nums[left] == target){
            return left;
        }
        if(nums[right] == target){
            return right;
        }
        return -1; //如果没有，返回-1
    }

    /**
     * find last position
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    private static int lastPosition(int[] nums, int target, int left, int right){
        while(left < right - 1){
            int mid = left + (right - left) / 2; //avoid integer overflow
            if(nums[mid] == target){
                left= mid; //和first position唯一的区别， 找到了不能停，继续往右找
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        //post-processing, check right first, because searching last position
        if(nums[right] == target){
            return right;
        }
        if(nums[left] == target){
            return left;
        }
        return -1;
    }
}
