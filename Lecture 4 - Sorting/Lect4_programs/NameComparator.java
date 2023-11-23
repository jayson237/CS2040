import java.util.Comparator;

class NameComparator implements Comparator<Person> {

	public int compare(Person p1, Person p2) {
		// Compares its two arguments for order by name
		return p1.getName().compareTo(p2.getName());
	}

	public boolean equals(Object obj) {
		// Simply checks to see if we have the same object
		return this == obj;
	}
}

