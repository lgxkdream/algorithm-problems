package io.github.lgxkdream.unit1;

/**
 * 
 * @title: BurstBalloons(戳气球)
 * @description: 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
				 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
				 求所能获得硬币的最大数量。
				 说明:
				 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
				 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
				 示例:
				 输入: [3,1,5,8]
				 输出: 167 
				 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
				      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2018年12月14日 下午5:12:41
 */
public class BurstBalloons {
	
	public static void main(String[] args) {
		int[] balloons = { 3, 1, 5, 8 };
		System.out.println(maxCoins(balloons));
	}
	
	private static int maxCoins(int[] nums) {
		int[] coins = new int[nums.length + 2];
		int[][] dp = new int[coins.length][coins.length];
		coins[0] = coins[coins.length - 1] = 1;
		for (int i = 0; i < nums.length; i++) {
			coins[i + 1] = nums[i];
		}
		for (int i = 2; i < coins.length; i++) { // 外层循环区间间隔，也即每组气球的个数，2~nums.length；
			for (int j = 0; i + j < coins.length; j++) { // 中层获取每组气球的起始下标
				for (int k = j + 1; k < i + j; k++) { // 内层获取戳破的气球
					dp[j][i + j] = Math.max(dp[j][i + j], dp[j][k] + dp[k][i + j] + coins[j] * coins[k] * coins[i + j]);
				}
			}
		}
		return dp[0][coins.length - 1];
	}

}
