package can_construct;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * <p>
 * canConstruct("aa", "ab") -> false
 * <p>
 * canConstruct("aa", "aab") -> true
 */
public class Solution {// 哈希数组解法

    public boolean canConstruct(String ransom, String magazine) {
        int[] record = new int[26];// 创建hash数组，保存记录过的值；
        // ransom的值一定是比magazine的值要小或相等的，否则一定无法配对
        if (ransom.length() > magazine.length()) {
            return false;
        }
        // 将可能较长的magazine记录每个字母的次数，当然也可以记录ransom，只不过后面判断条件要修改下
        for (char c : magazine.toCharArray()) {
            record[c - 'a']++;
        }
        // 如果ransom中字母存在于record中就减一
        for (char c : ransom.toCharArray()) {
            // 判断record中是否有负数，说明ransom中我要的字母，magazine中已经没有了
            if (--record[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
