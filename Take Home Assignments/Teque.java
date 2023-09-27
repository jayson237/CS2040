import java.io.*;
import java.util.HashMap;

class Teque {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int operations = Integer.parseInt(br.readLine());
        HashMap<Integer, String> frontArr = new HashMap<>();
        HashMap<Integer, String> backArr = new HashMap<>();

        int frontArrFrontIndex = -1,  backArrFrontIndex = -1;
        int frontArrBackIndex = 0, backArrBackIndex = 0;

        for (int i = 0; i < operations; i++) {
            String input = br.readLine();
            String[] inputArr = input.split(" ");
            String command = inputArr[0];
            String index = inputArr[1];

            if (command.equals("push_back")) {
                backArr.put(backArrBackIndex++, index);
            } else if (command.equals("push_front")) {
                frontArr.put(frontArrFrontIndex--, index);
            } else if (command.equals("push_middle")) {
                frontArr.put(frontArrBackIndex++, index);
            } else if (command.equals("get")) {
                if (Integer.parseInt(index) >= frontArr.size()) {
                    pw.write(backArr.get(Integer.parseInt(index) - frontArr.size() + backArrFrontIndex + 1));
                    pw.write("\n");
                } else {
                    pw.write(frontArr.get(Integer.parseInt(index) + frontArrFrontIndex + 1));
                    pw.write("\n");
                }
            }

            if (backArr.size() > frontArr.size()) {
                frontArr.put(frontArrBackIndex, backArr.get(backArrFrontIndex + 1));
                frontArrBackIndex++;
                backArrFrontIndex++;
                backArr.remove(backArrFrontIndex);
            }

            if (frontArr.size() - 1 > backArr.size()) {
                backArr.put(backArrFrontIndex, frontArr.get(frontArrBackIndex - 1));
                backArrFrontIndex--;
                frontArrBackIndex--;
                frontArr.remove(frontArrBackIndex);
            }
        }
        pw.flush();
        pw.close();
    }
}