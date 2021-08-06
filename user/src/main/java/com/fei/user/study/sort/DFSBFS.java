package com.fei.user.study.sort;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author: zhangxinfei
 * create at:  2021/8/3  2:18 下午
 * @description:
 */
public class DFSBFS {

//  给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
    public static double reverse(int[] nums1,int[] nums2) {

        int m = 0;
        int n = 0;
        if (nums1.length > 0){
            m = nums1.length;
        }
        if (nums2.length > 0){
            n = nums2.length;
        }
        int mid = (m + n)/2;
        if ((nums1.length + nums2.length)%2 == 0){
            if (nums1.length + nums2.length == 2){
                mid = 0;
            } else {
                mid--;
            }
        }

        double result = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        String temp = "i";
        while (k <= mid){
            if (i < nums1.length && j < nums2.length){
                if (nums1[i] < nums2[j]){
                    i++;
                    temp = "i";
                } else {
                    j++;
                    temp = "j";
                }
            } else if (i >= nums1.length){
                j++;
                temp = "j";
            } else if (j >= nums2.length){
                i++;
                temp = "i";
            }
            k++;
        }
        if ((nums1.length + nums2.length)%2 != 0){
            if (temp.equals("i")){
                result = nums1[i-1];
            } else {
                result = nums2[j-1];
            }
        } else {
            if (temp.equals("i")){
                result = nums1[i-1];
            } else {
                result = nums2[j-1];
            }

            if (i < nums1.length && j < nums2.length){
                if (nums1[i] < nums2[j]){
                    result = (result + nums1[i])/2;
                } else {
                    result = (result + nums2[j])/2;
                }
            } else if (i >= nums1.length){
                result = (result + nums2[j])/2;
            } else if (j >= nums2.length){
                result = (result + nums1[i])/2;
            }
        }


        return result;
    }


//    给你一个字符串 s，找到 s 中最长的回文子串。
    public static String test1(String s){
        if(s.length() < 2){
            return s;
        }
        int start =0,maxLen = 1;
        int length = s.length();
        Boolean[][] dp = new Boolean[length][length];
        for (int right = 1; right < length; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) != s.charAt(right)){
                    continue;
                }

                if (right == left){
                    dp[left][right] = true;
                } else if (right - left <= 2){
                    dp[left][right] = true;
                } else {
                    dp[left][right] = dp[left+1][right-1];
                }
                if (dp[left][right] && right-left+1 > maxLen){
                    maxLen = right-left+1;
                    start = left;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }

    public static int test2(String s){
        s = s.trim();
        if (s.isEmpty() || s.equals("-") || s.equals("+")){
            return 0;
        }
        char[] sArr = s.toCharArray();
        int res = 0;
        int sign = 1;
        int index = 0;
        if (s.charAt(index) == '-' || s.charAt(index) == '+')
            sign = s.charAt(index++) == '+' ? 1 : -1;

        for (; index < sArr.length; ++index) {
            //字符转换成数子
            int num = sArr[index] - '0';
            if (num < 0 || num > 9){
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                res = res * 10 + num;
            }
        }
        return res*sign;
    }

    //最长公共前缀
    public static String test3(String[] strs){
        int i = 0;
        String res = strs[i++];
        while (i < strs.length){
            while (strs[i].indexOf(res) != 0){
                res = res.substring(0,res.length()-1);
            }
            i++;
        }

        return res;
    }

    //三数之和
    public static List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("result");
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
