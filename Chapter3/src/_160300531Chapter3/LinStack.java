package Chapter3;

public class LinStack {
	Node head;
	int size;
	
	public void Linstack(){
		head = null;
		size = 0;
	}
	
	public void push(Object obj){
		head = new Node(obj,head);
		size++;
	}
	public Object pop()throws Exception{
		if(size == 0){
			throw new Exception("¶ÑÕ»ÒÑ¿Õ");
		}
		Object obj = head.data;
		head = head.next;
		size--;
		return obj;
		
	}
	public boolean notEmpty(){
		return head != null;
	}
	public Object getTop(){
		return head.data;
	}
}
