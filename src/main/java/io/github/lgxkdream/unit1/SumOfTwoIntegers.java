package io.github.lgxkdream.unit1;

/**
 * 
 * @title: SumOfTwoIntegers(两整数之和)
 * @description: 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
				 示例 1:
				 输入: a = 1, b = 2
				 输出: 3
				 示例 2:
				 输入: a = -2, b = 3
				 输出: 1
 * @Copyright: Copyright (c) 2018
 * @Company: lgxkdream.github.io
 * @author Jackie Lee
 * @version 1.0.0
 * @since 2018年11月14日 上午11:42:44
 */
public class SumOfTwoIntegers {

	public static void main(String[] args) {
		System.out.println(-3 << 2); // -12
		System.out.println(-3 ^ 5); // -8
		System.out.println(-3 & 5); // 5
		System.out.println(getSum1(3, 2));
		System.out.println(getSum2(5, 3));
	}

	public static int getSum1(int a, int b) {
		if ((a & b) != 0) { // 判断是否有进位
			return getSum1(a ^ b, (a & b) << 1); // 不进位和进位相加
		} else {
			return a | b; // 不进位方式相加(此处返回a ^ b亦可)
		}
	}

	public static int getSum2(int a, int b) {
		while (a != 0) {
			int forward = (a & b) << 1; // 进位
			b = a ^ b; // 不进位求和
			a = forward; // 保存进位用于下次运算
		}
		return b;
	}

}

// int res = 0;
//// 不进位的加和
// int xor = a ^ b;
//// System.out.println("xor:" + xor);
//// 进位和
// int forward = (a & b) << 1;
// if (forward != 0) {
// res = getSum(xor, forward);// 循环处理 进位和+不进位加和
// } else {
// res = xor;
// }
// return res;
