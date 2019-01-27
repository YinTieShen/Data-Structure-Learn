public class HashTable{
	private HashItem[] ht; 							//��ϣ������
	private int tableSize; 							//��ϣ��ĳ���
	private int currentSize; 						//��ǰ�ı������
	
	HashTable(int m){								//���캯��
		tableSize = m;
		ht = new HashItem[tableSize];
		currentSize = 0;
	}
	
	public boolean isIn(int x){						//x�Ƿ��Ѵ���
		int i = find(x);
		if(i >= 0)
			return true;
		else
			return false;	
	}
	
	public int getValue(int i){						//ȡ����Ԫ��ֵ
		return ht[i].data;
	}
	
	public int find(int x){							//����
		int i = x % tableSize;
		int j = i;
		
		if(ht[j] == null) ht[j] = new HashItem(0);
		while(ht[j].info == 1 && ht[j].data != x){ //˵�����ڳ�ͻ
			j = (j + 1) % tableSize;			//�õ���һ����ϣ��ַ
			if(j == i) return - tableSize;		
//��j == i��ʾ�Ѳ�������������ϣ������飬����- tableSize
		}
		if(ht[j].info == 1) 					//������������ʾ���ҵ�
			return j;							//���ظ�����Ԫ�ص��±�
		else 									//��ʱ��ʾû�в��ҵ�
			return - j;					//���ظ�����Ԫ�ع�ϣ��ַ�ĸ�ֵ
	}
	
	public void insert(int x) throws Exception{	//����
		int i = find(x); 			//����x	�Ƿ��Ѵ��ڣ������������±�

		if(i > 0){ 								//���x����
			throw new Exception("�������Ѵ���");
		}
		
		else if(i != -tableSize){				//���x������
			ht[-i] = new HashItem(x , 1);		//�ڸ�λ�ò����ϣ����
			currentSize ++;						//��ǰԪ�ظ�����1
		}
		else {					//���i����-tableSize����ʾ��ϣ������
			throw new Exception("��ϣ�������޷�����");
		}		
	}
	
	public void delete(int x) throws Exception{	//ɾ��
		int i = find(x); 			//����x	�Ƿ��Ѵ��ڣ������������±�	
		
		if(i >= 0){ 							//���x����
			ht[i].info = 0;						//��Ϊ����״̬
			currentSize --;						//��ǰԪ�ظ�����1	
		}
		else {									//���x������
			throw new Exception("�����ݲ�����");
		}
	}
}