package day2;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 904 Fruits into backets
 *
 * input: fruit[] = [1, 2, 2, 3, 4]
 * 每个数字代表一种水果，比如【苹果，梨，梨，香蕉 ，西瓜】
 * 请问最多摘两种水果的话，最多可以摘多少个
 * 思路： 双指针维护滑动窗口，在滑动窗口内只能有两种水果，那么这个滑动窗口最长可以有多长？
 * output：【1，2，2】或【2，2，3】，return 3
 *
 *
 * T = O(n)
 * S = O(1)
 * n is the size of input array
 */
public class L904_FruitIntoBaskets {
    public static void main(String[] args) {

        System.out.println(fruitToBasket(new int[]{3,3,3,1,2,1,1,2,3,3,4})); //5


    }
    private static int fruitToBasket(int[] fruits){
        if(fruits == null || fruits.length == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int slow = 0;
        int globalMax = 0;
        for(int fast = 0; fast < fruits.length; fast++){
            //map中如果有fruits[fast]这个key，返回实际的value，如果不存在这个key的话，返回默认值0
            Integer orDefault = map.getOrDefault(fruits[fast], 0);
            //不管map中有没有fruits[fast]这个key，只要存进map了，其value都需要加1
            map.put(fruits[fast], orDefault + 1);
            //假设input= [4,4,4,4,4,2,2,3,3,3,3]
            //那么map中有[<4,5>，<2,2>,<3,4>]
            //此时map的size>2, 说明要缩小窗口，把左边的所有的4都不断的抛掉，
            // <4,5>这个entry编程器<4,0>,map的size==2
            while(map.size() > 2){
                if(map.get(fruits[slow]) == 1){
                    map.remove(fruits[slow]);//如果只剩一个4，比如<4,1>直接删除这个entry
                }else{
                    map.put(fruits[slow], map.get(fruits[slow]) - 1); //不停的减1不停的减1，直到减到<4,1>，用上一个if删掉这个entry
                }
                slow++; //[0,slow)是弃掉不用的
            }
            //map.size() == 2时，while停止
            //更新一下此时此刻的globalMax
            globalMax = Math.max(globalMax, fast - slow + 1);
        }
        return globalMax;

    }
}
