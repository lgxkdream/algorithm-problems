package io.github.lgxkdream.unit1;

/**
 * 
 * @title: TrappingRainWater(接雨水)
 * @description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
				 示例:
				 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
				 输出: 6
 * @Copyright: Copyright (c) 2018
 * @Company: www.maodou.com
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2018年10月31日 上午10:48:08
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		int[] water = { 20, 8, 4, 6, 3, 9, 5, 10, 7, 11 };
		System.out.println(getWater(water));
		System.out.println(getWater1(water));
		System.out.println(getWater2(water));
	}

	private static int getWater(int[] height) {
		if (height == null || height.length < 3) {
			return 0;
		}
		int total = 0;
		int left = 1, right = height.length - 2;
		int leftMax = height[0], rightMax = height[height.length - 1];
		while (left <= right) {
			if (leftMax <= rightMax) {
				total += Math.max(0, leftMax - height[left]);
				leftMax = Math.max(leftMax, height[left++]);
			} else {
				total += Math.max(0, rightMax - height[right]);
				rightMax = Math.max(rightMax, height[right--]);
			}
		}
		return total;
	}

	public static int getWater1(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int sum = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			int leftMax = arr[0];
			for (int j = 0; j < i; j++) {
				if (arr[j] > leftMax) {
					leftMax = arr[j];
				}
			}
			int rightMax = arr[arr.length - 1];
			for (int k = arr.length - 1; k > i; k--) {
				if (arr[k] > rightMax) {
					rightMax = arr[k];
				}
			}
			sum += Math.max(0, Math.min(leftMax, rightMax) - arr[i]);
		}
		return sum;
	}
	
	public static int getWater2(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1, level = 0;
        while (l < r) {
            int lower = height[height[l] < height[r] ? l++ : r--];
            level = Math.max(level, lower);
            res += level - lower;
        }
        return res;
    }

}
