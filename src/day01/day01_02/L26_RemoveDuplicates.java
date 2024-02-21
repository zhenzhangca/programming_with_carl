package day01.day01_02;

/**
 * Leetcode 26 Remove Duplicates from sorted array
 *
 * leetcode 27题变种
 *
 * e.g.input = [1,2,2,2,3,3] return [1,2,3]
 * 还是双指针，slow + fast指针，其中fast指针是tracking pointer，负责遍历每一个元素
 *
 * 定义区间: [0, fast)存放已经遍历过的元素，[fast, n-1]是待探索区间
 *          [0, slow)存放最终结果
 *          初始值slow = 1， fast =1， 因为无论怎样，第一个元素都要保留
 *          case1: if（nums[fast] == input[slow-1]) continue
 *          case2: if(nums[fast] != input[slow-1]) copy nums[fast] to [0,slow)区间，slow++
 * 返回值是删除所有target之后的新数组的长度，因为[0, slow) 即[0, slow]是删除后的数组，所以slow所指向的index值就是新数组长度，因为数组index从0开始
 *
 * 过例子：
 * index    0  1  2  3  4  5
 * input = [1, 2, 2, 2, 3, 3]
 *                   s
 *                         f
 *
 * round 1: slow = 1, fast = 1, input[fast] != input[slow-1],copy input[fast] to [0, slow), input[slow] = input[fast], slow++
 * round 2: slow = 2, fast = 2, input[fast] == input[slow-1], continue
 * round 3: slow = 2, fast = 3, input[fast] == input[slow-1], continue
 * round 4: slow = 2, fast = 4, input[fast] != input[slow-1], input[slow] = input[fast] slow++
 * round 5: slow = 3, fast = 5, input[fast] == input[slow -1] continue
 * round 6: slow = 3, fast = 6 出界， for loop停止，slow所在的位置就是新数组的长度
 *
 *
 * T = O(n)
 * S = O(1)
 * n is the size of input array
 */
public class L26_RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1,2,2,4,4,5})); //4
        System.out.println(removeElement(new int[]{1,2,3,4})); //4
        System.out.println(removeElement(new int[0]));//0

    }
    private static int removeElement(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int slow = 1;
        for(int fast = 1; fast < nums.length; fast++){
            if(nums[fast] != nums[slow - 1]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
