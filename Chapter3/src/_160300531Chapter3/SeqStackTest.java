package Chapter3;

public class SeqStackTest {
	public static void main(String[] args) {
		SeqStack mySeqStack = new SeqStack();
		int test[] = {1,3,5,7,9};
		int n = 5;
		try{
			for (int i = 0; i < test.length; i++) {
				mySeqStack.push(test[i]);
			}
			System.out.println("��ǰջ��Ԫ��Ϊ��"+mySeqStack.getTop());
			System.out.println("��ջԪ������Ϊ��");
			while(mySeqStack.notEmpty())
				System.out.print(mySeqStack.pop()+" ");
		}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		
	}
}
