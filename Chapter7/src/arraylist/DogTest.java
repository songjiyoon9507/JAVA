package arraylist;

import java.util.ArrayList;

public class DogTest {
	public static void main(String[] args) {
		
		ArrayList<Dog> dog = new ArrayList<Dog>();
		
		dog.add(new Dog("감자", "시츄"));
		dog.add(new Dog("바둑이", "달마시안"));
		dog.add(new Dog("두부", "말티즈"));
		dog.add(new Dog("초코", "푸들"));
		dog.add(new Dog("구찌", "비숑"));
		
		for(Dog doglist : dog) {
			System.out.println(doglist.showInfo());
		}
	}
}
