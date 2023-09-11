import java.util.ArrayList;
import java.util.Scanner;

class PeaSoup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfRestaurants = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < numOfRestaurants; i++) {
            int numOfMenus = sc.nextInt();
            sc.nextLine();
            String restaurant = sc.nextLine();
            boolean hasPeaSoup = false;
            boolean hasPancakes = false;

            for (int j = 0; j < numOfMenus; j++) {
                String dish = sc.nextLine();
                if (dish.contains("pea soup")) {
                    hasPeaSoup = true;
                }
                if (dish.contains("pancakes")) {
                    hasPancakes = true;
                }

                if (hasPeaSoup && hasPancakes) {
                    list.add(restaurant);
                    break;
                }
            }
        }
        
        if (list.isEmpty()) {
            System.out.println("Anywhere is fine I guess");
        } else {
            System.out.println(list.get(0));
        }
    }
}