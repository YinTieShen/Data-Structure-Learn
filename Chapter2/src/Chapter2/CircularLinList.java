package Chapter2;
/*
 * ���һ����ͷ�ڵ��ѭ��������
 * ������ȡԪ�����ݸ��������룬ɾ����ȡ����Ԫ��
 * ʵ�֣�ģ�µ�����head.next = head,  current.next != null ��Ϊ current.next != head
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
			throw new Exception("��������");
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
			throw new Exception("��������");
		}
		index(i-1);
		current.setNext(new Node(obj,current.next));
		
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
	//����ȡԪ�����ݸ��������룬ɾ����ȡ����Ԫ�غ���
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
