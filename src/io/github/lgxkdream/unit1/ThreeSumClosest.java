package io.github.lgxkdream.unit1;

import java.util.Arrays;

/**
 * 
 * @title: ThreeSumClosest(最接近的三数之和)
 * @description: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
				 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
				 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2018年12月18日 下午2:47:37
 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		System.out.println(threeSumClosest(nums, 1)); // 2
	}

	public static int threeSumClosest(int[] nums, int target) {
		int closestSum = 0, diff = Integer.MAX_VALUE; // 初始化最接近的三个数的和 及 与目标值的差值(绝对值)
		Arrays.sort(nums); // 对数组排序
		for (int k = 0; k < nums.length - 2; k++) { // 第一个数的索引
			int i = k + 1, j = nums.length - 1; // 第二个和第三个数的索引
			while (i < j) {;
				int sumTemp = nums[k] + nums[i] + nums[j]; // 当前的三数之和
				int diffTemp = Math.abs(target - sumTemp); // 当前三数之和与目标值差值的绝对值
				if (diffTemp < diff) { // 如果差值绝对值小于之前的，则更新最接近的三个数的和 及 与目标值的差值(绝对值)
					closestSum = sumTemp;
					diff = diffTemp;
				}
				if (sumTemp > target) { // 如果三数之和大于目标值，则减小最大的第三个数
					j--;
				} else if (sumTemp < target) { // 如果三数之和小于目标值，则增大的第二个数
					i++;
				} else {
					return target; // 如果和目标值相等，那当然就是最接近的三数之和了
				}
			}
		}
		return closestSum;
	}

}
