import java.util.Comparator;

class AgeComparator implements Comparator<Person> {

	public int compare(Person p1, Person p2) {
		// Returns the difference:
		// if positive, age of p1 is greater than p2
		// if zero, the ages are equal
		// if negative, age of p1 is less than p2
		return p1.getAge() - p2.getAge();
	}

	public boolean equals(Object obj) {
		// Simply checks to see if we have the same object
		return this == obj;
	}
}

