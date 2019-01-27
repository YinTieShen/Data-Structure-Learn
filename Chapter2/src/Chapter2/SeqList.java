package Chapter2;

public class SeqList {
	
	final int defaultSize = 10;
	int maxsize;
	int size;
	Object[] listArray;

	public SeqList(){
		initiate(defaultSize);
	}
	
	public SeqList(int size){
		initiate(size);
	}
	
	public void initiate(int sz){
		maxsize = sz;
		size = 0;
		listArray = new Object[sz];
	}
	
	public void insert(int i ,Object obj) throws Exception{
		if(size == maxsize){
			throw new Exception("空间已满，无法插入");
		}
		if(i<0 || i>size){
			throw new Exception("插入下标参数错误");
		}
		
		for(int j=size;j>i;j++){
			listArray[j] = listArray[j-1];
		}
		listArray[i] = obj;
		size++;
	}
	public Object delete(int i) throws Exception{
		if(size == 0)
			throw new Exception("顺序表为空，无法插入");
		if(i<0 ||i>size-1){
			throw new Exception("下标元素不存在");
		}
		for(int j=i;j<size-1;j++){
			listArray[j] = listArray[j+1];
		}
		size--;
		return listArray[i];
	
	}
	public Object getdata(int i) throws Exception{
		if(i<0 || i>=size){
			throw new Exception("下标元素不存在");
		}
		return listArray[i];
	}
	
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public void setData(int i,Object x){
		listArray[i] = x;
	}
	
	public int MoreDataDelete(SeqList L,Object x) throws Exception{
		int tag = 0;
		for(int i=0;i<L.size;i++){
			if(x.equals(L.getdata(i))){
				L.delete(i);
				i--;
				tag = 1;
			}
		}
		return tag;
	}
	
	
}


















