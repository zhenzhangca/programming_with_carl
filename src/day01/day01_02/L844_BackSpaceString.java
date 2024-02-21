package day01.day01_02;

/**
 * Leetcode 284 比较含退格键#的字符串，退格之后，两个字符串是否相同
 *
 * 遇到string就把它相向成是装char的array， 所以本质还是对array进行操作，
 * 所以还是双指针，slow + fast指针，其中fast指针是tracking pointer，负责遍历每一个元素
 * 思路是去检查fast扫描到的元素是不是‘#’：
 * case 1: 如果input[fast] 是‘#’，说明它前边的元素要删除，不应该留在[0,slow)区间，所以slow--
 * case 2: 如果input[fast]不是‘#’，说明它应该被保留在[0,slow)区间， input[slow] = input[fast], slow++
 *
 * T = O(n)
 * S = O(1)
 * n is the size of input array
 */
public class L844_BackSpaceString {
    public static void main(String[] args) {
        char[] c1 = new char[]{'a','b','#','d','#','c'};
        char[] c2 = new char[]{'a','d','#', 'c'};
        System.out.println(moveZeros(c1).equals(moveZeros(c2))); //true

    }
    private static String moveZeros(char[] c){

        int slow = 0;
        for(int fast = 0; fast < c.length; fast++){
            if(c[fast] != '#'){
                c[slow] = c[fast];
                slow++;
            }else{
                if(slow > 0){ // 防止slow--越界
                    slow--;
                }
            }
        }
        return new String(c, 0, slow); //[0, slow)即[0,slow-1]是存放最终结果的区间，java api都是左闭右开
    }
}
