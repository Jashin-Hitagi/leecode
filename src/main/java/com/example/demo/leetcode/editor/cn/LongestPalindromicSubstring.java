//package leetcode.editor.cn;
package com.example.demo.leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4326 👎 0

public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {

        //中心扩散法
        if (s.length() <= 1){
            return s;
        }else if (s.length() == 2){
            if (s.charAt(0) == s.charAt(1)){
                return s;
            }else {
                return s.substring(1,2);
            }
        }else {
            String mid = "";
            String result = "";
            for (int i=1; i<s.length() - 1; i++){
                int startIndex = i;
                int endIndex = i;
                while (s.charAt(startIndex - 1) == s.charAt(i)){
                    startIndex--;
                    if (startIndex < 1){
                        break;
                    }
                }
                while (s.charAt(endIndex + 1) == s.charAt(i)){
                    endIndex++;
                    if (endIndex > s.length()-2){
                        break;
                    }
                }
                mid = getResult(s.substring(startIndex,endIndex+1), startIndex, endIndex, s);
                if (mid.length() > result.length()){
                    result = mid;
                }
            }
            return result;
        }
    }

    public String getResult(String mid, int startIndex, int endIndex, String s){
        if (startIndex >= 1 && endIndex < s.length() - 1){
            if (s.charAt(startIndex - 1) == s.charAt(endIndex + 1)){
                mid = s.substring(startIndex-1, endIndex + 2);
                return getResult(mid, startIndex -1, endIndex + 1, s);
            }
        }
        return mid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}