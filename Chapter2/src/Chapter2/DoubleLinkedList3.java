package Chapter2;



public class DoubleLinkedList3{
	//����˫������ڵ�
	private class Node2{
		Object data = null;
        Node2  next = null;
        Node2  prev = null;
        public Object getElement(){
			return data;
		}
        
	}
	
	 Node2 current;
	 Node2 head = null;
	 int size=1;
	
	public DoubleLinkedList3(){
		head = new Node2();
		head.data = null;
		head.prev = head;
		head.next = head;
		
	}

	public void insert(int i,Object data)throws Exception{
		
		Node2 node = new Node2();
		node.data = data;
		if(i<=0 ||i>size){
			throw new Exception("��������");
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
	
	void print()
    {
        System.out.print("��ӡ˫��ѭ������");
        Node2 temp = head;
        while(temp.next!=head)
        {
            System.out.print(temp.next.data+"\t");
            temp=temp.next;
        }
        System.out.println();
    }
	
//	public Object delete(int i)throws Exception{
//		if(size == 0){
//			throw new Exception("�����ѿգ���Ԫ��ɾ��");
//		}
//		if(i<0 ||i>size){
//			throw new Exception("��������");
//		}
//		//index(i-1);
//		Object obj = current.next.getElement();
//		current.next = current.next.next;
//		current.next.prev = current;
//		size--;
//		return obj;
//		
//	}
//	public Object getData(int i)throws Exception{
//		if(i<-1 ||i>size-1){
//			throw new Exception("��������");
//		}
//		//index(i);
//		return current.getElement();
//	}
	
	//����
	public static void main(String[] args) throws Exception {
		DoubleLinkedList3 dl = new DoubleLinkedList3();
		
		for(int i=0;i<10;i++){
			dl.insert(i, new Integer(i+1));
		}
		dl.print();
	}
	
   
}
