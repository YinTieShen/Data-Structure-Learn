package _160300531Chapter3;

/*
 * 1.���ѭ�����У���־λ��������
 * 2.��������캯��������У������У��ǿ�
 * 3.���Գ���
 */
public class Exam3_16 {
	public static void main(String[] args) throws Exception {
		SeqQueue sq = new SeqQueue(10);
		for (int i = 0; i < 10; i++) {
			sq.append(new Integer(i));
		}
	
		for(int i = sq.front;i<10;i++){
			System.out.print(sq.data[i]+" ");
		}
		System.out.println();
		sq.delete();
		
		sq.delete();
	
		for(int i = sq.front;i<10;i++){
			System.out.print(sq.data[i]+" ");
		}
		while(!sq.isEmpty()){
			sq.delete();
			
		}
		System.out.println();
		System.out.println(sq.rear);
		System.out.println(sq.front);
		
		
		
		
		
		
	}
}
