public class TestMyString{
	public static void main(String[] args){
		char[] var1={'d','u','j','i','a','n','h','u','a'};
		char[] var2={'y','a','n','g','j','i','n','f','e','n','g'};
		int length1 = var1.length;

		MyString ms1 = new MyString(var1, 0, length1);	//�ù��캯��2
		MyString ms2 = new MyString(var2);				//�ù��캯��3
		MyString ms3 = new MyString("lihonglei");		//�ù��캯��4
		MyString ms4 = new MyString("zhangxuhui");		//�ù��캯��4
	
		MyString ms5 = ms1.concat(ms2);
		ms5.myPrint();

		MyString ms6 = ms4.substring(0,4);
		ms6.myPrint();

		MyString ms7 = ms4.insert(new MyString("123"),4);
		ms7.myPrint();

		MyString ms8 = ms4.delete(3,6);
	    ms8.myPrint();
	}
}
