package Chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Yue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("��������������");
        int totalNum = scanner.nextInt();
        System.out.print("�������ʼ����m�Ĵ�С��");
        int cycleNum = scanner.nextInt();
        
        System.out.print("������"+totalNum+"���˵�����ֵ(���Ÿ���)��");
        String str=new Scanner(System.in).nextLine();
        String[] srr=str.split(",");
        ArrayList<Number> list=new ArrayList<>();
        //list.add(0);
        for (int i = 0; i < srr.length; i++) {
            list.add(Integer.valueOf(srr[i]));
        }
        //System.out.println(list);
        yuesefu(totalNum, cycleNum,list);
        //scanner.close();
    }

    public static void yuesefu(int totalNum, int countNum,ArrayList<Number> li) {
        // ��ʼ������
        List<Integer> start = new ArrayList<Integer>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        // �ӵ�K����ʼ����
        int k = 0;
        //while (start.size() > 0) {
            k = k + countNum;
            // ��m�˵�����λ��
            k = k % (start.size()) - 1;
            // �ж��Ƿ񵽶�β
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.print(start.get(k)+" ");
                start.remove(k);
            }
        //}
        while (start.size() > 0) {
        	int i = 0;
        	k = k + countNum ;
            // ��m�˵�����λ��
            k = k % (start.size()) - 1;
            // �ж��Ƿ񵽶�β
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
                countNum = li.get(i).intValue();
                i++;
            } else {
                System.out.print(start.get(k)+" ");
                start.remove(k);
                countNum = li.get(i).intValue();
                i++;
            }
        	
        }
    }
}
