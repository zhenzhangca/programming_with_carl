package day02;

/**
 * Leetcode 27 Remove Element
 *
 * 给一个数组nums，给一个target value， 删除数组中的所有target value
 *
 * 两种方法：
 * solution1 暴力解法， 两层循环，外层循环遍历每一个元素，找和target value相同的元素，找到了，从这个为止开始，把后边的元素一个一个往前移动，但要记得i--，都则会漏掉元素
 * 时间O（n2）
 * solution2 双指针， slow+ fast指针，其中fast指针是tracking pointer，负责遍历每一个元素
 * 定义区间: [0, fast)存放已经遍历过的元素，[fast, n-1]是待探索区间，初始是[0, n-1]
 *          [0, slow)存放最终结果
 *          case1: if（nums[fast] == target) continue
 *          case2: if(nums[fast] != target) copy nums[fast] to [0,slow)区间，slow++
 * 返回值是删除所有target之后的新数组的长度，因为[0, slow) 即[0, slow-1]是删除后的数组，所以slow所指向的index值就是新数组长度，因为数组index从0开始
 *
 * T = O(n)
 * S = O(1)
 * n is the size of input array
 */
public class L27_RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{2,3,1,1,3,1}, 1)); //3
        System.out.println(removeElement(new int[]{4,2,3,4}, 4)); //2
        System.out.println(removeElement(new int[0], 8));//0

    }
    private static int removeElement(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != target){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
