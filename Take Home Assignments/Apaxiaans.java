import java.util.Scanner;

class Apaxiaans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        char[] arr = in.toCharArray();
        char temp;
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i-1];
            char curr = arr[i];
            if (curr != temp) {
                System.out.print(curr);
            }
        }

    }
}