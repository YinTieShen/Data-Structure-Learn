package Chapter2;
/*
 * 设计一个带头节点的循环单链表
 * 函数：取元素数据个数，插入，删除，取数据元素
 * 实现：模仿单链表，head.next = head,  current.next != null 改为 current.next != head
 */
public class CircularLinList {
	Node head;
	Node current;
	int size;
	
	public CircularLinList() {
		
		head = current = new Node(null);
		head.next = head;
		size = 0;
	}
	public void index(int i ) throws Exception{
		if(i<-1 || i>size-1){
			throw new Exception("参数错误");
		}
		if(i==-1)return;
		current = head.next;
		int j = 0;
		while((current != head)&& j<i){
			current = current.next;
			j++;
		}
	}
	public void insert(int i,Object obj)throws Exception{
		if(i<0 ||i>size){
			throw new Exception("参数错误");
		}
		index(i-1);
		current.setNext(new Node(obj,current.next));
		
		size++;
	}
	
	public Object delete(int i)throws Exception{
		if(size == 0){
			throw new Exception("链表已空，无元素删除");
		}
		if(i<0 ||i>size){
			throw new Exception("参数错误");
		}
		index(i-1);
		Object obj = current.next.getElement();
		current.setNext(current.next.next);
		size--;
		return obj;
		
	}
	public Object getData(int i)throws Exception{
		if(i<-1 ||i>size-1){
			throw new Exception("参数错误");
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
	//测试取元素数据个数，插入，删除，取数据元素函数
	public static void main(String[] args) throws Exception {
		CircularLinList ci = new CircularLinList();
		
		for(int i=0;i<10;i++){
			ci.insert(i, new Integer(i+1));
		}
		
		
		for (int i = 0; i < 10; i++) {
			System.out.print(ci.getData(i)+" ");
		}
		System.out.println();
		ci.delete(3);
		for (int i = 0; i < ci.size; i++) {
			System.out.print(ci.getData(i)+" ");
		}


		
	}
	
}
