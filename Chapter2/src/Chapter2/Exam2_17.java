package Chapter2;

public class Exam2_17 {
	
	public static void ownInversion(SeqList l)throws Exception{
		
		int n = l.size;
		for (int i = 0; i < n/2; i++) {
			Object temp = l.getdata(i);
			l.setData(i, l.getdata(n-1-i));
			l.setData(n-1-i, temp);	
			
		}

	}
	
	//测试
	public static void main(String[] args) throws Exception {
		
		SeqList sq2  = new SeqList(100);
		
		for (int i = 0; i < 10; i++) {
			sq2.insert(i, new Integer(i+1));
		}
		for (int i = 0; i < 10; i++) {
			System.out.print(sq2.getdata(i)+" ");	
		}
		System.out.println();
		ownInversion(sq2);
		System.out.println("就地逆序后输出：");
		for (int i = 0; i < 10; i++) {
			System.out.print(sq2.getdata(i)+" ");	
		}
		
	}
}
