package Sep_week01;

import java.util.ArrayList;

public class test {
	
	static class Info{
		int age;
		ArrayList<Integer> list;
		public Info(int age) {
			list= new ArrayList<Integer>();
			this.age=age;
		}
		@Override
		public String toString() {
			return "Info [age=" + age + ", list=" + list + "]";
		}
		
		
		
	}
	public static void main(String[] args) {
		Info a = new Info(10);
		a.list.add(1);
		a.list.add(2);
		a.list.add(3);
		System.out.println(a);
		
		System.out.println("===list 실험 ");
		ArrayList<Integer> b = a.list;
		b.remove(0);
		System.out.println("b: "+b);
		System.out.println("a.list: "+a.list);
		
		System.out.println();
		System.out.println("===age 실험 ");
		int age1=a.age;
		age1--;
		System.out.println("age : "+age1);
		System.out.println("a.age: "+a.age);
		
		System.out.println("객체로 실험 ");
		Info b2 = a;
		b2.age=b2.age-5;
		System.out.println("a.age: "+a.age);
		
	}

}
