package day02;

/**
 * Leetcode 283 Move zeros
 *
 * leetcode 27题变种
 *
 * 把数组中的0全都移动到后边，保持其他元素顺序不变
 *
 *
 * e.g.input = [1,0,2,0,3,3] return [1,2,3，3，0，0]
 * 还是双指针，slow + fast指针，其中fast指针是tracking pointer，负责遍历每一个元素
 * 思路就是先把数组中的0全都删除，之后做post-processing，把0补到结尾
 *
 * T = O(n)
 * S = O(1)
 * n is the size of input array
 */
public class L283_MoveZeros {
    public static void main(String[] args) {


    }
    private static void moveZeros(int[] nums){
        if(nums == null || nums.length <= 1){
            return;
        }
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for(int i = slow; i <  nums.length; i++){
            nums[i] = 0;
        }
    }
}
