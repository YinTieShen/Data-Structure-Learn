package Chapter2;
import java.util.Scanner;





public class DoubleLinkedList2{
	//定义双向链表节点
	private class Node2{
		Object data;
        Node2  next;
        Node2  prev;
        
        private Node2()
        {
      	data=null;
      	prev=null;
      	next=null;
      	}
      private Node2(Object data){
      	this.data=data;
      	this.prev=null;
      	this.next=null;
      }
      private Node2(Object data,Node2 prev,Node2 next){
      	this.data=data;
      	this.prev=prev;
          this.next=next;
         }
      public Object getElement(){
  		return data;
  	}
	}
	
	 Node2 current;
	 Node2 head ;
	 int size=1;
	
	public DoubleLinkedList2(){
		head = new Node2();
		head.data = null;
		head.prev = head;
		head.next = head;
		
	}
//	public void index(int i ) throws Exception{
//		if(i<-1 || i>size-1){
//			throw new Exception("参数错误");
//		}
//		if(i==-1)return;
//		current = head.next;
//		int j = 0;
//		while((current != head)&& j<i){
//			current = current.next;
//			j++;
//		}
//	}
	public void insert(int i,Object data)throws Exception{
		
		Node2 node = new Node2(data);
		if(i<=0 ||i>size){
			throw new Exception("参数错误");
		}
		if(head.prev == head){
			node.prev = head;
			node.next = head;
			head.next = node;
			head.prev = node;
		}else if(i == size){
			node.next=head;
            node.prev=head.prev;
            head.prev.next=node;
            head.prev=node;
		}else
        {
            Node2 temp = head;
            int count=0;
            while(temp.next!=head)
            {
                count++;
                if(count == i)
                {
                    node.prev=temp;
                    node.next=temp.next;
                    temp.next.prev=node;
                    temp.next=node;
                }
                temp=temp.next;
            }
        }
		size++;
	}
	
	public Object delete(int i)throws Exception{
		if(size == 0){
			throw new Exception("链表已空，无元素删除");
		}
		if(i<0 ||i>size){
			throw new Exception("参数错误");
		}
		//index(i-1);
		Object obj = current.next.getElement();
		current.next = current.next.next;
		current.next.prev = current;
		size--;
		return obj;
		
	}
	public Object getData(int i)throws Exception{
		if(i<-1 ||i>size-1){
			throw new Exception("参数错误");
		}
		//index(i);
		return current.getElement();
	}
	
	//测试
	public static void main(String[] args) throws Exception {
		DoubleLinkedList2 dl = new DoubleLinkedList2();
		
		dl.insert(1, new Integer(1));
		
//		for(int i=1;i<10;i++){
//			dl.insert(i, new Integer(i+1));
//		}
	}
	
   
}
