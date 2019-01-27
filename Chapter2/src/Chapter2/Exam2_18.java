package Chapter2;

/*
 * 带头结点单链表A中数据元素就地逆置
 */

public class Exam2_18 {
	
	public static void reverse(Node head){
		
		if (head==null||head.next==null||head.next.next==null){
	        return;
	    }
	   
	    Node cur=head.next.next;
	    head.next.next=null;
	    while (cur!=null){
	       
	        Node temp=cur.next;
	       
	        cur.next=head.next;
	     
	        head.next=cur;
	            
	        cur=temp;
	    }
	}

		
		
	
	//测试
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
		
		reverse(li.head);
		System.out.println("排序后数据元素");
		for (int i = 0; i <li.size; i++) {
			System.out.print(li.getData(i)+" ");
		}
		
	}
	
}
	
