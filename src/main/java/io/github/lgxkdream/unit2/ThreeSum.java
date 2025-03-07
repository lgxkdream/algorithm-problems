package io.github.lgxkdream.unit2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @title: ThreeSum(三数之和)
 * @description: 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
				 注意：答案中不可以包含重复的三元组。
				 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
				 满足要求的三元组集合为：
				 [
				   [-1, 0, 1],
				   [-1, -1, 2]
				 ]
 * @Copyright: Copyright (c) 2019
 * @company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2019年1月23日 上午11:06:18
 */
public class ThreeSum {
	
	public static void main(String[] args) {
		int[] nums = { 0, -4, -1, -4, -2, -3, 2 };
//		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> threeSum = threeSum(nums);
		for (List<Integer> list : threeSum) {
			for (Integer sum : list) {
				System.out.print(sum + " ");
			}
			System.out.println("");
		}
	}

	private static List<List<Integer>> threeSum(int[] nums) {
		// 双指针思想：先对nums排序，三个数拆成1+2形式，第一个数nums[k]一定小于等于0，后两个数通过设置两个指针 i,j 分别指向数组两端：
		// 如果两指针所指向数nums[i]和nums[j]的和sub大于-nums[k]，j指针前移，找一个更小的数；如果两指针所指向数的和小于target，
		// i指针后移，找一个更大点的数；如果相同，则返回即可。 
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums); // -4, -1, -1, 0, 1, 2 // -4,-4,-3,-2,-1,0,2
		for (int k = 0; k < nums.length; k++) {
			if (nums[k] > 0 || (k > 0 && nums[k] == nums[k - 1])) {
				continue; // 最小的数大于0不可能再组成结果0了 或者 返回的第一个数相等去重
			}
			int i = k + 1, j = nums.length - 1;
			while (i < j) {
				int sub = nums[i] + nums[j];
				if (sub == -nums[k]) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[k]);
					list.add(nums[i]);
					list.add(nums[j]);
					res.add(list); // 添加结果
					while (i < j && nums[i] == nums[i + 1]) { // 第二个数相等去重
						i++;
					}
					while (i < j && nums[j] == nums[j - 1]) { // 第三个数相等去重
						j--;
					}
					i++;
					j--;
				} else if (sub > -nums[k]) {
					j--; // 三个数的和大于0，第三个数减小点
				} else {
					i++; // 三个数的和小于0，第二个数增大点
				}
			}
		}
		return res;
	}

}
