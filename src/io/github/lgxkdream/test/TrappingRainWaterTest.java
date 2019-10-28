package io.github.lgxkdream.test;

/**
 * 
 * @title: TrappingRainWaterTest
 * @description:
 * @Copyright: Copyright (c) 2019
 * @company: www.maodou.com
 * @author LiGang
 * @version 1.0.0
 * @since 2019年3月4日 下午2:19:14
 */
public class TrappingRainWaterTest {

	public static void main(String[] args) {
		int[] water = { 20, 8, 4, 6, 3, 9, 5, 10, 7, 11 };
		System.out.println(getWater(water));
		System.out.println(getWater1(water));
	}

	private static int getWater(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int sum = 0;
		int leftMax = arr[0];
		int rightMax = arr[arr.length - 1];
		int l = 1;
		int r = arr.length - 2;
		while (l <= r) {
			if (leftMax <= rightMax) {
				sum += Math.max(0, leftMax - arr[l]);
				leftMax = Math.max(leftMax, arr[l++]);
			} else {
				sum += Math.max(0, rightMax - arr[r]);
				rightMax = Math.max(rightMax, arr[r--]);
			}
		}
		return sum;
	}

	private static int getWater1(int[] arr) {
		if (arr == null || arr.length < 3) {
			return 0;
		}
		int sum = 0;
		int leftMax = arr[0];
		int rightMax = arr[arr.length - 1];
		int l = 1;
		int r = arr.length - 2;
		while (l <= r) {
			if (leftMax <= rightMax) {
				sum += Math.max(0, leftMax - arr[l]);
				leftMax = Math.max(leftMax, arr[l++]);
			} else {
				sum += Math.max(0, rightMax - arr[r]);
				rightMax = Math.max(rightMax, arr[r--]);
			}
		}
		return sum;
	}

}
