package _160300531Chapter3;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/*
 * 借助堆栈把中缀表达式变成后缀表达式
 */


public class Exam3_18 {
	
	static Stack<Character> stack = new Stack<>();
	
	public static String getrp(String s){
		char[] arr = s.toCharArray();
		String out = "";
		
		for(int i=0; i<arr.length;i++){
			char ch = arr[i];
			if(ch == ' ')
				continue;
			if(ch >='0' && ch<='9'){
				out = out+ch;
				continue;
			}
			if(ch == '(') stack.push(ch);
			if(ch == '+' || ch == '-'){
				while(!stack.isEmpty() && stack.peek() != '('){
					out += stack.pop();
				}
				stack.push(ch);
				continue;
			}
			if(ch == '*' || ch == '/'){
				while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/'))
					out += stack.pop();
				stack.push(ch);
				continue;
			}
			if(ch == ')'){
				while(!stack.isEmpty() && stack.peek() != '(')
					out += stack.pop();
				stack.pop();
			}
			
		}
		while(!stack.isEmpty()) out += stack.pop();
		return out;	
	}
	public static void main(String[] args){
    	System.out.println("请输入一串中缀表达式（空格结束）：");
       Scanner in = new Scanner(System.in);
        String exp = in.nextLine();
        System.out.println((getrp(exp)));
    }
	
}
