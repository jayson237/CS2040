import java.util.HashMap;

public class TestHash {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		// placing items into the hashmap
		hm.put("Mike", 52);
		hm.put("Janet", 46);
		hm.put("Jack", 46);
		// retrieving item from the hashmap
		System.out.println("Janet => " + hm.get("Janet"));
	}
}
