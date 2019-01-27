public class MyString{
	private char[] value;			//˽�г�Ա�������ַ�����
	private int count; 				//˽�г�Ա�������ַ�����
       
    private static void arrayCopy(char[] src,int srcPos,
		char[] dst,int dstPos,int length){			//�ַ����鿽��
 	//srcΪԴ�����ַ����飬srcPosΪԴ������ʼ�±�
	//dstΪĿ�괮���ַ����飬srcPosΪĿ�괮����ʼ�±�
	//lengthΪ�´��ĳ���
    	if(src.length - srcPos < length || dst.length - dstPos < length)
    	   throw new StringIndexOutOfBoundsException(length);
    	for(int i = 0; i < length; i++){
    		dst[dstPos++] = src[srcPos++];
    	}
    }
 	
	public MyString(){							//���캯��1
		value = new char[0];
		count = 0;
	}
	
	public MyString(char[] value,int offset,int count){ //���캯��2
	//valueΪ�ַ����飬offsetΪ������ʼ�±꣬countΪ����
	//����value�����д�offset�±�ʼ������Ϊcount���ַ�����������
		if (offset < 0) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        if (count < 0) {
            throw new StringIndexOutOfBoundsException(count);
        }       
        if (offset > value.length - count) {
            throw new StringIndexOutOfBoundsException(offset + count);
        }

        this.value = new char[count];
        this.count = count;
        arrayCopy(value, offset, this.value, 0, count);	//����Ԫ�ؿ���
	}
	
	public MyString(char[] value){						//���캯��3
		this.count = value.length;
        this.value = new char[count];
        arrayCopy(value, 0, this.value, 0, count); 		//����Ԫ�ؿ���
	}
	
	public MyString(String str){ 						//���캯��4
	//�˹��캯����Ϊ�˸�����ʼ����ֵ���㣬��������в���ʹ��
//��ͬMyString ms4 = new MyString("zhangxuhui")�����
		char[] chararray = str.toCharArray();
		value = chararray;
		count = chararray.length;
	}
	
	public char charAt(int index) {						//ȡ�ַ�
        if ((index < 0) || (index >= count)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }
    
    public int compareTo(MyString anotherString) {		//�Ƚϴ�
	//����ǰ����Ĵ�ֵ����anotherString�Ĵ�ֵ��������һ��������
	//����ǰ����Ĵ�ֵ����anotherString�Ĵ�ֵ��������0
	//����ǰ����Ĵ�ֵС��anotherString�Ĵ�ֵ��������һ��������
    	int len1 = count;
	    int len2 = anotherString.count;
	    int n = Math.min(len1, len2); 	//nΪlen1��len2�Ľ�С��
	    char v1[] = value;
	    char v2[] = anotherString.value;
	    int i = 0;
	    int j = 0;
	     
	    int k = i;
	    int lim = n + i;
	    while (k < lim) {
	   	   char c1 = v1[k];
		   char c2 = v2[k];
		   if (c1 != c2) {
		       return c1 - c2;			//���ص�һ��������ַ�����ֵ��
		    }
		   k++;
	    }

	   	//��ǰ�߲����ַ��Ƚ�ȫ�����ʱ
	   	return len1 - len2;	    			//���������ַ������ȵ���ֵ��
    }
        
    public int length() {								//ȡ������
        return count;
    }
        
    public MyString concat(MyString str) {				//����
	    int otherLen = str.length();
	    char[] strarray = str.toArray();
	    if (otherLen == 0) {
	       return this;
	    }
	    char buf[] = new char[count + otherLen];
	    arrayCopy(value,0,buf,0,count); 	    				//�ַ����鿽��
		arrayCopy(strarray,0,buf,count,otherLen); 	    	//�ַ����鿽��
	    return new MyString(buf);
    }

    public MyString substring(int beginIndex, int endIndex) {//ȡ�Ӵ�
	//��ȡ�Ӵ����±�beginIndex��ʼ���±�endIndex��ǰһλ��
		if (beginIndex < 0) {
	    		throw new StringIndexOutOfBoundsException(beginIndex);
		}
		if (endIndex > count) {
	    		throw new StringIndexOutOfBoundsException(endIndex);
		}
		if (beginIndex > endIndex) {
	   		throw new StringIndexOutOfBoundsException(endIndex - beginIndex);
	   	}

		return ((beginIndex == 0) && (endIndex == count)) ? this :
	    		new MyString(value,beginIndex, endIndex - beginIndex);
    }
    
    public MyString substring(int beginIndex) {			//ȡ�Ӵ�
	//��ȡ�Ӵ����±�beginIndex��ʼ������ĩβ
		return substring(beginIndex, count);
    }
     
    public char[] toArray(){						//ת�����ַ�����
    	char[] buf = new char[count];
    	arrayCopy(value,0,buf,0,count);
    	return buf;
    }
    
    public MyString insert(MyString str,int pos){		//�����Ӵ�
	//�ڵ�ǰ�����ַ������pos�±꿪ʼ����str������ַ���
    	if(pos < 0 || pos > count)
    	    throw new StringIndexOutOfBoundsException(pos);
    	if(pos != 0){
    		MyString str1 = this.substring(0,pos);//ȡ��������ǰһ����
    		MyString str2 = this.substring(pos); //ȡ�������ĺ�һ����
    		MyString res1 = str1.concat(str); 	//����str1��str
    		MyString res2 = res1.concat(str2); 	//����str1��str2
    		return res2;							//����str2
    	}
    	else
    	   return str.concat(this);
    }       
    
    public MyString delete(int beginIndex,int endIndex){ //ɾ���Ӵ�
	//ɾ����ǰ������±�beginIndex��ʼ���±�endIndex��ǰһλ�õ��Ӵ�
        if (beginIndex < 0) {
	    		throw new StringIndexOutOfBoundsException(beginIndex);
		}
		if (endIndex > count) {
	    		throw new StringIndexOutOfBoundsException(endIndex);
		}
		if (beginIndex > endIndex) {
	    		throw new StringIndexOutOfBoundsException(endIndex - beginIndex);
		}
		if ((beginIndex == 0) && (endIndex == count)) 
			return new MyString();				//���ش�ֵΪ�յĶ���
		else{
			MyString str1 = this.substring(0,beginIndex);
												//ȡ��������ǰһ����
			MyString str2 = this.substring(endIndex);
												//ȡ�������ĺ�һ����
			return str1.concat(str2); 		//����str1��str2������
		}
	}
    
    public void myPrint(){						//�����ֵ
    	for(int i = 0; i < count; i++){
    		System.out.print(value[i]);
    	}
    	System.out.println();
    }
    
	public int indexOf_BF(MyString subStr,int start){
	//���ҵ�ǰ���󣨼��������д�startʼ���Ӵ�subStr
	//�ҵ����򷵻��Ӵ�subStr�������Ŀ�ʼ�ַ��±꣬���򷵻�-1
		int i = start,j = 0,v ;    
  	
		while(i < this.length() && j < subStr.length()){
			if(this.charAt(i) == subStr.charAt(j)){
				i ++ ;
				j ++ ;    			
			}
			else{
				i = i - j + 1 ;
				j = 0 ;
			}
		}
 	
		if(j == subStr.length()) v = i - subStr.length() ;
		else v = -1 ; 
		return v;
	}
    
	public int indexOf_KMPA(MyString subStr,int start){
	//���ҵ�ǰ���󣨼��������д�startʼ���Ӵ�subStr
	//�ҵ����򷵻��Ӵ�subStr�������Ŀ�ʼ�ַ��±꣬���򷵻�-1
  		int[] next = getNext(subStr); 	//���Ӵ�subStr��next[j]ֵ
   		int i = start,j = 0,v;
   	
   		while(i < this.length() && j < subStr.length()){
   			if(j == -1 || this.charAt(i) == subStr.charAt(j)){
   				i ++ ;
   				j ++ ;
   			}
   			else j = next[j];
   		}
   	
   		if(j == subStr.length()) v = i - subStr.length();
   		else v = -1;
   		return v;
	}
    
	public int indexOf_KMPB(MyString subStr,int start){
   		int[] next = getNext(subStr);
   		int i = start,j = 0,v;
   	
   		while(i < this.length() && j < subStr.length()){
   			if(this.charAt(i) == subStr.charAt(j)){
   				i ++ ;
   				j ++ ;
   			}
   			else if(j == 0) i ++ ;
   			else j = next[j];
   		}
   	
   		if(j == subStr.length()) v = i - subStr.length();
   		else v = -1;
   		return v;
	}
      
	private int[] getNext(MyString str){
	//��ģʽ��str��next[j]����ֵ�������鷵��
   		int j = 1,k = 0 ;
   		int[] next = new int[str.length()];
  	
   		next[0] = -1 ;
   		next[1] = 0 ;
   		while(j < str.length() - 1){
   			if(str.charAt(j) == str.charAt(k)){
   				next[j + 1] = k + 1 ;
   				j ++ ;
   				k ++ ;
   			}
   			else if(k == 0){
   				next[j + 1] = 0 ;
   				j ++ ;
   			}
   			else
   		   		k = next[k];
   		}
   		return next ;
	}
	
	public int indexOf_BF_Count(MyString subStr,int start){
	//���ҵ�ǰ���󣨼��������д�startʼ���Ӵ�subStr
	//�ҵ����򷵻��Ӵ�subStr�������Ŀ�ʼ�ַ��±꣬���򷵻�-1
		int i = start,j = 0,v ; 
		int count = 0;   
  	
		while(i < this.length() && j < subStr.length()){
			if(this.charAt(i) == subStr.charAt(j)){
				i ++ ;
				j ++ ;    			
			}
			else{
				i = i - j + 1 ;
				j = 0 ;
			}
			count++;
		}
 	
		return count;
	}
    
	public int indexOf_KMPB_Count(MyString subStr,int start){
   		int[] next = getNext(subStr);
   		int i = start,j = 0,v;
		int count = 0;   
   	
   		while(i < this.length() && j < subStr.length()){
   			if(this.charAt(i) == subStr.charAt(j)){
   				i ++ ;
   				j ++ ;
   			}
   			else if(j == 0) i ++ ;
   			else j = next[j];
 			count++;
  		}
   	
		return count;
	}
}