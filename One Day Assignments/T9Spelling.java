import java.util.*;

class T9Spelling {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine();

        Hashtable<Character, String> dict = new Hashtable<Character, String>();
        dict.put('a', "2");
        dict.put('b', "22");
        dict.put('c', "222");
        dict.put('d', "3");
        dict.put('e', "33");
        dict.put('f', "333");
        dict.put('g', "4");
        dict.put('h', "44");
        dict.put('i', "444");
        dict.put('j', "5");
        dict.put('k', "55");
        dict.put('l', "555");
        dict.put('m', "6");
        dict.put('n', "66");
        dict.put('o', "666");
        dict.put('p', "7");
        dict.put('q', "77");
        dict.put('r', "777");
        dict.put('s', "7777");
        dict.put('t', "8");
        dict.put('u', "88");
        dict.put('v', "888");
        dict.put('w', "9");
        dict.put('x', "99");
        dict.put('y', "999");
        dict.put('z', "9999");
        dict.put(' ', "0");

        String stdOut = "";

        for (int i = 0; i < cases; i++) {
            String word = sc.nextLine();
            char[] wordArr = word.toCharArray();
            StringBuilder out = new StringBuilder();
            out.append(dict.get(wordArr[0]));

            for (int j = 1; j < wordArr.length; j++) {
                String currCharValue = dict.get(wordArr[j]);
                if (out.charAt(out.length() - 1) == currCharValue.charAt(0)) {
                    out.append(" " + dict.get(wordArr[j]));
                } else {
                    out.append(dict.get(wordArr[j]));
                }
            }
            if (i != cases - 1) {
                stdOut += "Case #" + (i + 1) + ": " + out + "\n";
            } else {
                stdOut += "Case #" + (i + 1) + ": " + out;
            }
        }
        System.out.print(stdOut);
    }
}
