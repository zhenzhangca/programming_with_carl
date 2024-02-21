package day01.day01_01;

/**
 * Leetcode 367 判断一个数是否是完全平方数
 * Binary Search 变种
 * e.g. input = 7, return false
 *      input = 4, return true
 *
 * input = 4
 * round 1: left = 1, right = 4, mid = 2 ， 4 / mid = 2, return true;
 *
 * input = 5
 * round 1: left = 1, right = 5, mid = 3, 5 / mid = 1.6666 mid > 1.6666, mid 右边的数平方都会大于5， 排除右半边，right = mid - 1
 * round 2: left = 1， right = 2， mid = 1， 5 / mid = 5 mid < 5， mid 左边的数平方都会小于5， 排除左半边，left = mid + 1
 * round 3： left = 2， right = 2， mid = 2， 5 / mid = 2.5， mid < 2.5, 这里知道如果5 / mid 向下取整得2， mid = 2， 就会返回错误答案true，但正确答案应该是false，所以要1.0 * 5 / mid
 *
 *
 * T = O(log n)
 * S = O(1)
 * n is the size of input array
 */
public class L367_PerfectSquare {
    public static void main(String[] args) {

        System.out.println(bs(2)); //false
        System.out.println(bs(0)); //true
        System.out.println(bs(16)); //true
    }
    private static boolean bs(int num){
        if(num == 0){
            return true;
        }
        int left = 1;
        int right = num;
        while(left <= right){
            int mid = left + (right - left) / 2;
            /**
             * 0 不能做除数，所以这里mid和num都不能是0， num=0要作为corner case单独拿出来
             * 这里要考虑两整数相除向下取整的问题，要注意精度
             */

            if(mid < 1.0 * num / mid){
                left = mid + 1;
            }else if(mid > 1.0 * num / mid){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
