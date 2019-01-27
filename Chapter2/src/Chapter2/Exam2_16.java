package Chapter2;

public class Exam2_16 {
	public static SeqList inversion(SeqList l)throws Exception{
		
		int n = l.size;
		
		SeqList l2 = new SeqList(l.size);
		for (int i = 0; i < l.size; i++) {
			l2.insert(i, l.getdata(n-1-i));
		}
		return l2;
		
	}
	
	//²âÊÔ
	public static void main(String[] args) throws Exception {
		
		SeqList sq2  = new SeqList(100);
		
		for (int i = 0; i < 10; i++) {
			sq2.insert(i, new Integer(i+1));
		}
		for (int i = 0; i < 10; i++) {
			System.out.print(sq2.getdata(i)+" ");	
		}
		System.out.println();
		SeqList sq3 = inversion(sq2);
		System.out.println("ÄæÐòºóÊä³ö£º");
		for (int i = 0; i < 10; i++) {
			System.out.print(sq3.getdata(i)+" ");	
		}
		
	}
	
}
