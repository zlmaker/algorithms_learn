package is_anagram;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 * <p>
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 * <p>
 * 说明: 你可以假设字符串只包含小写字母。
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        // 对字符串s的字母进行统计计数
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        // 对字符串t的字母进行统计计数
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        // 判断是否还有数量不为0的存在
        for (int count : record) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
