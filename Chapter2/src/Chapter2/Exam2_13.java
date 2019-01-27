package Chapter2;

public class Exam2_13 {
	public static int findIndex(SeqList l,Object x)throws Exception{
		int i;
		for (i = 0; i < l.size; i++) {
			if(x.equals(l.getdata(i))){
				break;
			}
		}
		if(i == l.size) return -1;
		return i;
	}
	
	//开始测试
	public static void main(String[] args) throws Exception {
		SeqList sq  = new SeqList(100);
		
		for (int i = 0; i < 10; i++) {
			sq.insert(i, new Integer(i+1));
		}
		for (int i = 0; i < 10; i++) {
			System.out.print(sq.getdata(i)+" ");
			
		}
		Integer a = new Integer(3);
		System.out.println();
		int b = findIndex(sq,new Integer(3));
		System.out.println(a+" 在顺序表中的位置是"+b);
		
	}
}
