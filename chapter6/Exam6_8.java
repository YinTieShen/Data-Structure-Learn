public class Exam6_8{
	public static void main(String[] args){
		String fileName = "Maze1.dat";
		Maze m = new Maze(fileName);
		int start = 1;
		
		if(m.travMaze(start)){
			System.out.println();
			System.out.println("���Թ���һ��ͨ·������ʾ");
		}
		else{
			System.out.println("���Թ���ͨ·������");
		}
	}	
}