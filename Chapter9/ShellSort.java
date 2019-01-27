public class ShellSort{
	public static void shellSort(int[] a, int[] d, int numOfD){
		int i, j, k, m, span;
		int temp;
		int n = a.length;

		for(m = 0; m < numOfD; m ++){				//��numOfD��ѭ��
			span = d[m]; 							//ȡ���ε�����ֵ
			for(k = 0; k < span; k ++){				//��span��С��
				for(i = k; i < n-span; i = i + span){
					temp = a[i+span];
					j = i;
					while(j > -1 && temp <= a[j]){
						a[j + span] = a[j];
						j = j - span;
					}
					a[j + span] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] test = {65, 34, 25, 87, 12, 38, 56, 46, 14, 77, 92, 23};
		int n = test.length;
		int numOfD = 3;
		int[] d = {6, 3, 1};
		
		shellSort (test, d, numOfD);
		for(int i = 0; i < n; i++)
			System.out.print(test[i] + "  ");
	}
}