package stringAlgorithmic;

/**
 * �ַ���ƥ��
 * 	1)������ⷨ  Brute Force BF
 * 		ʱ�临�Ӷ�O(m*n)
 */
public class ForceAlgorithmic {
	
	/**
	 * ������
	 * @param text  ԭʼ��
	 * @param pattern ģʽ��
	 * @return ƥ��� ��ʼ�±�
	 */
	public static int forceMethod(String text,String pattern){
		int i = 0;//��ǰƥ�䵽��ԭʼ����λ
		int j = 0;//ģʽ����ƥ��λ��
		int size = text.length();
		int psize = pattern.length();
		
		while((i<size)&&(j<psize)){
			//��ƥ�䣬��ģʽ��ƥ��λ�ú���
			if(text.charAt(i+j) == pattern.charAt(j)){
				j++;
			}else{
				//��ƥ�䣬��ȶ���һ��λ�ã�ģʽ�����ݵ���λ
				i++;
				j = 0;
			}
		}
		
		if(j>=psize)
			return i;
		return -1;
	}
	
	
	public static int forceMethod2(String text,String pattern){
		
		int start = 0; //���� ƥ��ĳ�ʼ�±�
		
		for (int i = 0; i < text.length(); i++) {
			start = i;
			for (int j = 0; j < pattern.length(); ) {
				//�����һ����ĸƥ�� �����ȶ���һ��λ��
				if (text.charAt(i) == pattern.charAt(j)) {
					j ++; // ģʽ����������  
					i ++; // ԭʼ��ҲҪ����
					if (j >= pattern.length()){
						return start;
					}
				} else { //�����һλ��ĸ��û����ԣ����������
					break;
				}
			}
		}
		
		return -1;
	}
	
	//����
	public static void main(String[] args) {
		String text = "hjdahghajk";
		String pattern = "ah";
		int index = forceMethod(text,pattern);
		System.out.println(index);
		index = forceMethod2(text,pattern);
		System.out.println(index);

		
		
	}

}
