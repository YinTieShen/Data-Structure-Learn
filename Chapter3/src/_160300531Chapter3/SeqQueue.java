package _160300531Chapter3;
/*
 * 1.设计循环队列，标志位解决假溢出
 * 2.类包括构造函数，入队列，出队列，非空
 * 3.测试程序
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
			throw new Exception("队列已满");
		}
		data[rear] = obj;
		rear = (rear+1)%maxSize;
		//rear++;
		flag = 1;
	}
	public Object delete()throws Exception{
		if(rear == front && flag == 0){
			throw new Exception("队列已空");
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
