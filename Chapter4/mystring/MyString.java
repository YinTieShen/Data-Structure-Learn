public class MyString{
	private char[] value;			//˽�г�Ա�������ַ�����
	private int count; 				//˽�г�Ա�������ַ�����
       
    private static void arrayCopy(char[] src,int srcPos,
char[] dst,int dstPos,int length){			//�ַ����鿽��
 			//srcΪԴ�����ַ����飬srcPosΪԴ������ʼ�±�
			//dstΪĿ�괮���ַ����飬srcPosΪĿ�괮����ʼ�±�
			//lengthΪ�������´��ĳ���
    	if(src.length-srcPos<length||dst.length-dstPos<length)
    	   throw new StringIndexOutOfBoundsException(length);
    	for(int i = 0; i < length; i++){
    		dst[dstPos++] = src[srcPos++];
    	}
    }
 	
	public MyString(){							//���캯��1
		value=new char[0];
		count=0;
	}
	
	public MyString(char[] value,int offset,int count){
	//���캯��2��valueΪ�ַ����飬offsetΪ������ʼ�±꣬countΪ����
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
	//�˹��캯����Ϊ�˸�����ʼ����ֵ���㣬������Գ����в���ʹ�����
//      MyString ms4 = new MyString("yangjinfeng");
		char[] chararray=str.toCharArray();
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
	    int n = Math.min(len1, len2);
	    char v1[] = value;
	    char v2[] = anotherString.value;
	    int i = 0;
	    int j = 0;

	    if (i == j) {   
	       int k = i;
	       int lim = n + i;
	       while (k < lim) {
	   	      char c1 = v1[k];
		      char c2 = v2[k];
		      if (c1 != c2) {
		          return c1 - c2;
		      }
		      k++;
	       }
	    } else {
	       while (n-- != 0) {
		      char c1 = v1[i++];
		      char c2 = v2[j++];
		      if (c1 != c2) {
		          return c1 - c2;
		      }
	       }
	    }
	   	return len1 - len2;	    
    }
        
    public MyString concat(MyString str) {					//����
	    int otherLen = str.length();
	    char[] strarray=str.toArray();
	    if (otherLen == 0) {
	       return this;
	    }
	    char buf[] = new char[count + otherLen];
	    arrayCopy(value,0,buf,0,count); 	    				//�ַ����鿽��
	arrayCopy(strarray,0,buf,count,otherLen); 	    	//�ַ����鿽��
	    return new MyString(buf);
    }
        
     public int length() {								//ȡ������
        return count;
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
    	return value;
    }
    
    public MyString insert(MyString str,int pos){		//�����Ӵ�
	//�ڵ�ǰ�����ַ������pos�±꿪ʼ����str������ַ���
    	if(pos < 0 || pos > count)
    	    throw new StringIndexOutOfBoundsException(pos);
    	if(pos != 0){
    		MyString str1 = this.substring(0,pos);
    		MyString str2 = this.substring(pos);
    		MyString res1 = str1.concat(str);
    		MyString res2 = res1.concat(str2);
    		return res2;
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
return new MyString();
		else{
			MyString str1 = this.substring(0,beginIndex);
			MyString str2 = this.substring(endIndex);
			return str1.concat(str2);
		}
	}
    
    public void myPrint(){								//�����ֵ
    	for(int i=0;i<count;i++){
    		System.out.print(value[i]);
    	}
    	System.out.println();
    }
 }
