package Chapter3;

/*
 * 使用队列和堆栈判断一个字符是否是回文
 */
public class Exam3_3 {
	public static void huiWen(String s) throws Exception{
		int n = s.length();
		SeqStack sqt = new SeqStack(n);
		SeqQueue squ = new SeqQueue(n);
		for (int i = 0; i < n; i++) {
			sqt.push(s.substring(i, i+1));
			squ.append(s.substring(i,i+1));
			
		}
		while(sqt.notEmpty() && squ.notEmpty()){
			if(!sqt.pop().equals(squ.delete())){
				System.out.println("字符串"+s+"不是回文字符串");
				return;
			}
				
		}
		System.out.println("字符串"+s+"是回文字符串");
	}
	//test
	public static void main(String[] args) throws Exception {
		String s1 = "asdfgfdsa";
		String s2 = "asdfghjkl";
		
		huiWen(s1);
		
		huiWen(s2);
	}
}
