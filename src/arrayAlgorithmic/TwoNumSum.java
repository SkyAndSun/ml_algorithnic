package arrayAlgorithmic;

import java.util.Arrays;

/**
 * 寻找和为定值的两个数  输入一个数组A[0…N-1]和一个数字Sum，在 数组中查找两个数A i ,A j ，使得A i +A j =Sum。
 * 
 * 解法： a 暴力求解 b 先排序，两头扫
 * 
 */
public class TwoNumSum {

	/*
	 * 暴力求解
	 */
	public static String forceMethod(int[] arr, int sum) {
		StringBuilder result = new StringBuilder();
		int numA = 0;
		// int numB =0;
		int flag = 1;// 作为标记，看一下是多少组的

		for (int i = 0; i < arr.length; i++) {// 代表第一个数
			numA = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] == (sum - numA)) {
					result.append("第" + flag + "组:" + numA + "," + arr[j] + "; ");
					flag++;
				}
			}
		}

		String res = result.toString();

		if (res == null || "".equals(res))
			res = "没有这样的两个数";

		return res;
	}

	/*
	 * 若a[i]+a[j]>sum，则i不变，j--；  若a[i]+a[j]<sum，则i++，j不变； 
	 * 若a[i]+a[j]==sum，如果只要求输出一个结果，则退出； 否则，输出结果后i++，j--；
	 */
	public static String doubleSum(int[] arr, int sum) {
		StringBuilder result = new StringBuilder();
		int index = 1;
		// 1 先排序
		Arrays.sort(arr);
		// 2 两头扫
		int begin = 0;
		int end = arr.length - 1;

		while (begin < end) {
			if (arr[begin] + arr[end] > sum)
				end--;
			if (arr[begin] + arr[end] < sum)
				begin++;
			if (arr[begin] + arr[end] == sum) {
				result.append("第" + index + "组:" + arr[begin] + "," + arr[end] + "; ");
				//继续往下找
				end --;
				begin ++;
				index ++;
			}
		}

		String res = result.toString();

		if (res == null || "".equals(res))
			res = "没有这样的两个数";

		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 6, 9, 12, 7, 5, 3, 4,8,12,2 };
		int num = 10;
		String str = forceMethod(arr, num);
		System.out.println(str);
		
		str = doubleSum(arr,num);
		System.out.println(str);

	}

}
