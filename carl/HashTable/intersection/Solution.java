package intersection;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 题意：给定两个数组，编写一个函数来计算它们的交集。
 */
class Solution1 {// 秀操作法

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet set1 = new HashSet<>(Arrays.asList(nums1));
        HashSet set2 = new HashSet<>(Arrays.asList(nums2));
        set1.retainAll(set2);
        return set1.stream().mapToInt(int.class::cast).toArray();
    }
}

class Solution2 {// 传统数组方法

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> result = new HashSet<>();// 存放结果，之所以用set是为了给结果集去重
        int[] hash = new int[1005];// 创建hash表
        for (int i : nums1) {
            hash[i] = 1;// 对于nums1中出现的值进行记录
        }
        for (int i : nums2) {
            if (hash[i] == 1) {// 说明nums2中也有相同的记录
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
