package Chapter2;

/*
 * ��ͷ��㵥����A������Ԫ�ؾ͵�����
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

		
		
	
	//����
	public static void main(String[] args) throws Exception {
		LinList li = new LinList();
		int s[] = {1,3,5,7,9};
		for (int i = 0; i < s.length; i++) {
			li.insert(i, new Integer(s[i]));	
		}
		System.out.println("����ǰ����Ԫ��");
		
		for (int i = 0; i <li.size; i++) {
			System.out.print(li.getData(i)+" ");
		}
		System.out.println();
		
		reverse(li.head);
		System.out.println("���������Ԫ��");
		for (int i = 0; i <li.size; i++) {
			System.out.print(li.getData(i)+" ");
		}
		
	}
	
}
	
