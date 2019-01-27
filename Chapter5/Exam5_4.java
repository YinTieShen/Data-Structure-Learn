public class Exam5_4{
	public static void main(String[] args){
		SynmeMatrix matrixA = new SynmeMatrix(3);
		SynmeMatrix matrixB = new SynmeMatrix(3);
		SynmeMatrix matrixC;

		double[][] a = {{1,0,0},{2,3,0},{4,5,6}};
		double[] b = {1,2,3,4,5,6};
		
		matrixA.evaluateMatrix(a);
		matrixB.evaluateMatrix(b);
		
		System.out.println("matrixA¾ØÕóÎª£º");
		matrixA.print();
		System.out.println("matrixB¾ØÕóÎª£º");
		matrixB.print();
		matrixC = matrixA.add(matrixB);
		System.out.println("matrixC¾ØÕóÎª£º");
		matrixC.print();
	}
}