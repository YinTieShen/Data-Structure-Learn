package Chapter3;

class Element{
	private Object elem;
	private int priority;
	
	public Element(Object obj,int i) {
		elem = obj;
		priority = i;
	}
	public Object getElem(){
		return elem;
	}
	public void setElem(Object obj){
		elem = obj;
	}
	public int getPrority(){
		return priority;
	}
	public void setPrority(int i){
		priority = i;
	}
	
}

public class SeqPQueue {
	static final int defaultSize = 10;
	int front;
	int rear;
	int count;
	int maxSize;
	Element[] data;
	
	public SeqPQueue(){
		this.initiate(10);
	}
	public SeqPQueue(int sz){
		this.initiate(sz);
	}
	private void initiate(int sz){
		maxSize = sz;
		front = rear = 0;
		count = 0;
		data = new Element[sz];
	}
	
	public void append(Object obj)throws Exception{
		if(count >= maxSize)
			throw new Exception("队列已满");
		data[rear] = (Element)obj;
		rear = rear + 1;
		count++;
	}
	public Element delete()throws Exception{
		if(count == 0){
			throw new Exception("队列为空");
		}
		Element min = data[0];
		int minIndex = 0;
		for (int i = 0; i < count; i++) {
			if(data[i].getPrority()<min.getPrority()){
				min = data[i];
				minIndex = i;
			}
		}
		for(int i = minIndex +1; i<count; i++){
			data[i-1] = data[i]; 
		}
		rear = rear -1;
		count--;
		return min;
	}
	
	public Object getFont()throws Exception{
		if(count == 0){
			throw new Exception("队列为空");
		}
		Element min = data[0];
		int minIndex = 0;
		for(int i = 0;i<count; i++ ){
			if(data[i].getPrority()<min.getPrority()){
				min =data[i];
				minIndex = i;
				
			}
		}
		rear = rear-1;
		count--;
		return min;
	}
	public boolean notEmpty(){
		return count != 0;
	}
	
	
}
