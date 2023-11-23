import java.util.*;

public class TestComparator {

	public static void main(String[] args) { 
		NameComparator nameComp = new NameComparator();
		AgeComparator ageComp = new AgeComparator();
		Person[] p = new Person[5];

		p[0] = new Person("Michael", 15);
		p[1] = new Person("Mimi", 9);
		p[2] = new Person("Sarah", 12);
		p[3] = new Person("Andrew", 15);
		p[4] = new Person("Mark", 12);
		List<Person> list = Arrays.asList(p);

		System.out.println("Sorting by age:");
		Collections.sort(list, ageComp);
		System.out.println(list + "\n");

		List<Person> list2 = Arrays.asList(p);
		System.out.println("Sorting by name:");
		Collections.sort(list2, nameComp);
		System.out.println(list2 + "\n");

		System.out.println("Now sort by age, then sort by name:");
		Collections.sort(list2, ageComp); // list2 is already sorted by name
		System.out.println(list2);
	}
}

