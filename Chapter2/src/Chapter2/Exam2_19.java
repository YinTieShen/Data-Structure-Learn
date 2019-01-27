package Chapter2;
/*
 * 带头节点A链表逆置后储存到B链表中
 */
public class Exam2_19 {
	
	public static LinList reverse2(LinList l) throws Exception{
		
		LinList li2 = new LinList();
		int n = l.size;
		for (int i = 0; i < n; i++) {
			li2.insert(i, l.getData(n-1-i));
		
		}
		return li2;
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		LinList li = new LinList();
		int s[] = {1,3,5,7,9};
		for (int i = 0; i < s.length; i++) {
			li.insert(i, new Integer(s[i]));	
		}
		System.out.println("排序前数据元素");
		
		for (int i = 0; i <li.size; i++) {
			System.out.print(li.getData(i)+" ");
		}
		System.out.println();
		
		LinList li3 = reverse2(li);
		System.out.println("排序后数据元素");
		for (int i = 0; i <li3.size; i++) {
			System.out.print(li3.getData(i)+" ");
		}
		
	}
}
