package tag;

import java.util.Stack;

public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tag = "[()]{}";
		
		test(tag);
		
		
		test("[(([{}]))]{}");
		
		test("[(([{}))]{}");

	}
	
	public static void test(String tag){
		boolean result = checker(tag);
		System.out.println(tag + " result " + result);
		
	}
	
	public static boolean checker(String tag){
		Stack<Character> s = new Stack<>();
		
		int index = 0;
		while(index < tag.length()){
			Character c = tag.charAt(index);
			index++;
			if(c == '[' || c == '(' || c == '{'){
				s.push(c);
				
			}else{
				Character prev = s.pop();
				if(prev == '[' && c ==']'){
					continue;
				}else if (prev == '{' && c =='}'){
					continue;
				}else if (prev == '(' && c ==')'){
					continue;
				}else{
					return false;
				}			
			}
		}
		
		
		
		return true;
	}

}
