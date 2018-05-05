package stringAlgorithmic;

/**
 * 字符串匹配
 * 	1)暴力求解法  Brute Force BF
 * 		时间复杂度O(m*n)
 */
public class ForceAlgorithmic {
	
	/**
	 * 暴力法
	 * @param text  原始串
	 * @param pattern 模式串
	 * @return 匹配的 开始下标
	 */
	public static int forceMethod(String text,String pattern){
		int i = 0;//当前匹配到的原始串首位
		int j = 0;//模式串的匹配位置
		int size = text.length();
		int psize = pattern.length();
		
		while((i<size)&&(j<psize)){
			//若匹配，则模式串匹配位置后移
			if(text.charAt(i+j) == pattern.charAt(j)){
				j++;
			}else{
				//不匹配，则比对下一个位置，模式串回溯到首位
				i++;
				j = 0;
			}
		}
		
		if(j>=psize)
			return i;
		return -1;
	}
	
	
	public static int forceMethod2(String text,String pattern){
		
		int start = 0; //保存 匹配的初始下标
		
		for (int i = 0; i < text.length(); i++) {
			start = i;
			for (int j = 0; j < pattern.length(); ) {
				//如果第一个字母匹配 继续比对下一个位置
				if (text.charAt(i) == pattern.charAt(j)) {
					j ++; // 模式串继续后移  
					i ++; // 原始串也要后移
					if (j >= pattern.length()){
						return start;
					}
				} else { //如果第一位字母，没有配对，则无需继续
					break;
				}
			}
		}
		
		return -1;
	}
	
	//测试
	public static void main(String[] args) {
		String text = "hjdahghajk";
		String pattern = "ah";
		int index = forceMethod(text,pattern);
		System.out.println(index);
		index = forceMethod2(text,pattern);
		System.out.println(index);

		
		
	}

}
