package com.example.demo.leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6396 👎 0

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //暴力解法
//    public int lengthOfLongestSubstring(String s) {
//        if (s == "" || s == null){
//            return 0;
//        }
//        //存放不重复的子串
//        String child = "";
//        //最长的不重复子串
//        String res = "";
//        for (int i = 0; i < s.length(); i++){
//            String a = String.valueOf(s.charAt(i));
//            if (!child.contains(a)){
//                child += a;
//                if (i == s.length() -1 && child.length() > res.length()){
//                    res = child;
//                }
//            }else {
//                if (child.length() > res.length()){
//                    res = child;
//                }
//                child = child.substring(child.lastIndexOf(a)+1) + a;
//            }
//        }
//        return res.length();
//    }

    //滑动窗口
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int end = 0, start = 0; end < n; end++) {
//            char alpha = s.charAt(end);
//            if (map.containsKey(alpha)) {
//                start = Math.max(map.get(alpha), start);
//            }
//            ans = Math.max(ans, end - start + 1);
//            map.put(s.charAt(end), end + 1);
//        }
//        return ans;
//    }

    public int lengthOfLongestSubstring(String s) {
        //字符串下标
        int i = 0;
        //重复字符下标 + 1
        int flag = 0;
        //不重复子串长度
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            //从重复字符开始查找该字符位置
            int pos = s.indexOf(s.charAt(i),flag);
            //如果字符重复
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}