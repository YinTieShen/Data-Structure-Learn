public class HashTable{
	private HashItem[] ht; 							//哈希表数组
	private int tableSize; 							//哈希表的长度
	private int currentSize; 						//当前的表项个数
	
	HashTable(int m){								//构造函数
		tableSize = m;
		ht = new HashItem[tableSize];
		currentSize = 0;
	}
	
	public boolean isIn(int x){						//x是否已存在
		int i = find(x);
		if(i >= 0)
			return true;
		else
			return false;	
	}
	
	public int getValue(int i){						//取数据元素值
		return ht[i].data;
	}
	
	public int find(int x){							//查找
		int i = x % tableSize;
		int j = i;
		
		if(ht[j] == null) ht[j] = new HashItem(0);
		while(ht[j].info == 1 && ht[j].data != x){ //说明存在冲突
			j = (j + 1) % tableSize;			//得到下一个哈希地址
			if(j == i) return - tableSize;		
//若j == i表示已查找完了整个哈希表的数组，返回- tableSize
		}
		if(ht[j].info == 1) 					//此条件成立表示查找到
			return j;							//返回该数据元素的下标
		else 									//此时表示没有查找到
			return - j;					//返回该数据元素哈希地址的负值
	}
	
	public void insert(int x) throws Exception{	//插入
		int i = find(x); 			//查找x	是否已存在，并返回数组下标

		if(i > 0){ 								//如果x存在
			throw new Exception("该数据已存在");
		}
		
		else if(i != -tableSize){				//如果x不存在
			ht[-i] = new HashItem(x , 1);		//在该位置插入哈希表项
			currentSize ++;						//当前元素个数加1
		}
		else {					//如果i等于-tableSize，表示哈希表已满
			throw new Exception("哈希表已满无法插入");
		}		
	}
	
	public void delete(int x) throws Exception{	//删除
		int i = find(x); 			//查找x	是否已存在，并返回数组下标	
		
		if(i >= 0){ 							//如果x存在
			ht[i].info = 0;						//置为空闲状态
			currentSize --;						//当前元素个数减1	
		}
		else {									//如果x不存在
			throw new Exception("该数据不存在");
		}
	}
}