public class TestMyStringBuffer{
	public static void main(String[] args){
		MyStringBuffer msb1=new MyStringBuffer("lihonglei");
		MyStringBuffer msb2=new MyStringBuffer("zhangxuhui");

		System.out.print("msb1������ǰ���ֵ��");
		msb1.myPrint();
		MyStringBuffer msb3=msb1.concat(msb2);
		System.out.print("msb1�����Ӻ����ֵ��");
		msb1.myPrint();
		System.out.print("msb3�����ֵ��    ��");
		msb3.myPrint();
	}
}
