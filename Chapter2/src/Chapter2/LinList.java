package Chapter2;

import java.util.List;

public class LinList {
	
	Node head;
	Node current;
	int size;
	
	LinList(){
		head = current = new Node(null);
		size = 0;
	}
	public void index(int i ) throws Exception{
		if(i<-1 || i>size-1){
			throw new Exception("��������");
		}
		if(i==-1)return;
		current = head.next;
		int j = 0;
		while((current != null)&& j<i){
			current = current.next;
			j++;
		}
	}
	public void insert(int i,Object obj)throws Exception{
		if(i<0 ||i>size){
			throw new Exception("��������");
		}
		index(i-1);
		current.setNext(new Node(obj,current.next));
//		Node node = new Node(obj,current.next);
//		current.next = node;
		size++;
	}
	public Object delete(int i)throws Exception{
		if(size == 0){
			throw new Exception("�����ѿգ���Ԫ��ɾ��");
		}
		if(i<0 ||i>size){
			throw new Exception("��������");
		}
		index(i-1);
		Object obj = current.next.getElement();
		current.setNext(current.next.next);
		size--;
		return obj;
		
	}
	public Object getData(int i)throws Exception{
		if(i<-1 ||i>size-1){
			throw new Exception("��������");
		}
		index(i);
		return current.getElement();
	}
	public int getSize(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	
	
	
	
}
