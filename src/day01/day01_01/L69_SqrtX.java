package day01.day01_01;

/**
 * Leetcode 69 求x的平方根
 * Assumptions： x>= 0
 * return value should be non-negative integer
 * Binary Search 变种，
 *
 * e.g x = 4, return 2 (no -2)
 *     x = 8, return 2 (real value is 2.82842...)
 * 过个例子：
 * input = 8
 * 1， 2， 3， 4， 5， 6， 7， 8
 * round 1: left = 1, right = 8, mid = 4, mid * mid = 16 > 8, 所以比mid大的数，平方肯定都大于8， 右半边排除，right = mid - 1 = 3
 * round 2: left = 1， right = 3， mid = 2， mid * mid = 4 < 8， 所以比mid小的数，平方肯定都小于8， 左半边排除，left = mid + 1 = 3
 * round 3: left = 3， right = 3， mid = 3， mid * mid = 9 > 8， 所以比mid大的数， 平方肯定都大于吧，右半边排除，right = mid - 1 = 2
 * round 4: left = 3， right = 2， while 循环 done
 * return right（小的那个）
 *
 *
 * T = O(log n)
 * S = O(1)
 * n is the size of input array
 */
public class L69_SqrtX {
    public static void main(String[] args) {

        System.out.println(sqrt(2)); //1
        System.out.println(sqrt(9)); //3
        System.out.println(sqrt(8)); //2
        System.out.println(sqrt(0));  //0

    }
    private static int sqrt(int x){
        if(x == 0){
            return 0;
        }
        int left = 1;
        int right = x;
        while(left <= right){
            int mid = left + (right - left) / 2; //mid向下取整，结果也是向下取证
            if(mid == x / mid){ //0 不能做除数，所以把mid 不能等于0， 即x不能等于0， 所以把x=0作为corner case 先判断
                return mid;
            }else if(mid > x / mid){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right; //left 和 right 错开了，返回小的那个, right 在left 左边，所以right肯定是小的那个
    }
}
