package four_sum_count;

import java.util.HashMap;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * <p>
 * A = [ 1, 2]
 * <p>
 * B = [-2,-1]
 * <p>
 * C = [-1, 2]
 * <p>
 * D = [ 0, 2]
 * <p>
 * 输出:
 * <p>
 * 2
 */
public class Solution {// HashMap方法

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();//key:a+b的数值，value:a+b数值出现的次数
        int count = 0;// 统计数量
        // 遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中
        for (int i : A) {
            for (int j : B) {
                if (map.containsKey(i + j)) {
                    map.put(i + j, map.get(i + j) + 1);
                } else {
                    map.put(i + j, 1);
                }
            }
        }
        // 在遍历大C和大D数组，找到如果 -(c+d) 在map中出现过的话，就把map中key对应的value也就是出现次数统计出来。
        for (int i : C) {
            for (int j : D) {
                if (map.containsKey(-(i + j))) {
                    count += map.get(-(i + j));
                }
            }
        }
        return count;
    }
}
