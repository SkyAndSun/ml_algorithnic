package arrayAlgorithmic;

import java.util.Arrays;

/**
 * 和为定值的m个数  
 * 已知数组A[0…N-1]，给定某数值sum，找出 数组中的若干个数，使得这些数的和为 sum。  
 * 布尔向量x[0…N-1] 
 * x[i]=0表示不取A[i]，x[i]=1表示取A[i]  
 * 假定数组中的元素都大于0：A[i]＞0  
 * 这是个NP(正态分布)问题！
 * 
 * 解法：
 * 	1 直接递归法
 *  2 分支限界法
 *  	正数
 *  	负数
 *
 */
public class HashFunction {
	
	/**
	 * 直接递归法
	 */
	public static void diGuiMethod(int[] arr,int sum){
		int has = 0;
		boolean[] x = new boolean[arr.length];
		diGui(arr,x,0,has,sum);
	}
	
	/**
	 * 
	 * @param arr  数组
	 * @param x 
	 * @param i	考察第arr[i] 是否加入
	 * @param has 表示当前的和
	 * @param sum 要计算的和
	 * @return 返回符合的结果
	 */
	public static void diGui(int[] arr,boolean[] x, int i, int has,int sum){
		int size = arr.length;
		if(i < size)
			x[i] = false;
		
		if (i >= size){
			return ;
		}
			
		if (has + arr[i] == sum){
			x[i] = true;
			System.out.println(Arrays.toString(x));
		} 
		
		//如果 i 下标所对元素已经加入
		x[i] = true;
		diGui(arr,x,i+1,has+arr[i],sum);
		//如果 i 下标所对元素没有加入
		x[i] = false;
		diGui(arr,x,i+1,has,sum);
	}
	

	/**
	 * 分支限界法  ---- 全为 正数
	 */
	public static void branchMethod(int[] arr,int sum){
		int has = 0;
		boolean[] x = new boolean[arr.length];
		int residue = 0;
		for (int i = 0; i < arr.length; i++) {
			residue += arr[i];
		}
		branch(arr,x,0,has,sum,residue);
	}
	
	/**
	 * 分支限界法
	 * @param arr
	 * @param x
	 * @param i
	 * @param has
	 * @param sum
	 * @param residue 剩余数的总和
	 */
	private static void branch(int[] arr,boolean[] x, int i, int has,int sum,int residue){
		int size = arr.length;
		if(i < size)
			x[i] = false;
		
		if (i >= size){
			return ;
		}
			
		if (has + arr[i] == sum){
			x[i] = true;
			System.out.println(Arrays.toString(x));
		} else if ((has + residue >= sum) && (has + arr[i] <= sum)){
			//如果 i 下标所对元素已经加入
			x[i] = true;
			branch(arr,x,i+1,has+arr[i],sum,residue -arr[i]);
		}
		
		// 如果后面的数，加起来大于sum 那么 arr[i] 是可以没有的
		if (has + residue - arr[i] >= sum){
			x[i] = false;
			branch(arr,x,i+1,has,sum,residue-arr[i]);
		}
	}
	
	
	/*
	 * negative 剩余负数 总和
	 * positive 剩余正数 总和
	 */
	private static void branchAll(int[] arr,boolean[] x, int i, int has,int sum,int negative,int positive){
		int size = arr.length;
		if(i < size)
			x[i] = false;
		
		if (i >= size){
			return ;
		}
		
		//正数 用正数的方法处理
		if (arr[i]>0){
			if (has + arr[i] == sum){
				x[i] = true;
				System.out.println(Arrays.toString(x));
			} else if ((has + positive >= sum) && (has + arr[i] <= sum)){
				//如果 i 下标所对元素已经加入
				x[i] = true;
				branchAll(arr,x,i+1,has+arr[i],sum,negative,positive -arr[i]);
			}
			
			// 如果后面的数，加起来大于sum 那么 arr[i] 是可以没有的
			if (has + positive - arr[i] >= sum){
				x[i] = false;
				branchAll(arr,x,i+1,has,sum,negative,positive-arr[i]);
			}
		}else{// 负数的处理方法
			if (has + arr[i] +positive >= sum){
				x[i] = true;
				branchAll(arr,x,i+1,has,sum,negative-arr[i],positive);
			}
			if ((has + negative <= sum) && (has + positive >= sum)){
				x[i] = false;
				branchAll(arr,x,i+1,has,sum,negative-arr[i],positive);
			}
		}
			
	}
	
	public static void branchAllMethod(int[] arr,int sum){
		boolean[] x = new boolean[arr.length];
		int negative = 0;
		int positive = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>0)
				positive += arr[i];
			else
				negative += arr[i];
		}
		branchAll(arr,x,0,0,sum,negative,positive);
	}
	

	public static void main(String[] args) {	
		int[] arr = {3,6,9,12,23,44,3,7};
		int sum = 30;
		diGuiMethod(arr, sum);
		System.out.println("---------------------------");
		branchMethod(arr,sum);
		System.out.println("---------------------------");
		int[] arrAll = {3,6,9,12,23,44,-3,-7,-3,-6,-9,-12,23,-44,3,-7};
		int sumAll = 120;
		branchAllMethod(arrAll,sumAll);
		
	}

}
