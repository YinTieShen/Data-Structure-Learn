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
			System.out.println("当前栈顶元素为："+mySeqStack.getTop());
			System.out.println("出栈元素序列为：");
			while(mySeqStack.notEmpty())
				System.out.print(mySeqStack.pop()+" ");
		}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		
	}
}
