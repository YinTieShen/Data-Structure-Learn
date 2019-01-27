package _160300531Chapter3;
/*
 * 1.���ѭ�����У���־λ��������
 * 2.��������캯��������У������У��ǿ�
 * 3.���Գ���
 */

public class SeqQueue {
	static final int defdaultSize = 10;
	public int front;
	public int rear;
	int flag;
	Object[] data;
	int maxSize;
	
	public SeqQueue(){
		initiate(defdaultSize);
	}
	public SeqQueue(int sz){
		initiate(sz);
	}
	private void initiate(int sz){
		front = rear =0;
		flag = 0;
		maxSize = sz;
		data = new Object[sz];
	}
	
	public void append(Object obj)throws Exception{
		if(rear == front && flag == 1){
			throw new Exception("��������");
		}
		data[rear] = obj;
		rear = (rear+1)%maxSize;
		//rear++;
		flag = 1;
	}
	public Object delete()throws Exception{
		if(rear == front && flag == 0){
			throw new Exception("�����ѿ�");
		}
		Object temp = data[front];
		front = (front+1)% maxSize;
		flag = 0;
		return temp;
	}
	public boolean isEmpty(){
		return (rear == front && flag == 0);
	}
}
