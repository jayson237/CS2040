import java.util.*;

class BestRelay {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int numOfRunners = sc.nextInt();
        ArrayList<Runner> runners = new ArrayList<>();
        for (int i = 0; i < numOfRunners; i++) {
            String runner = sc.next();
            double value1 = sc.nextDouble();
            double value2 = sc.nextDouble();
            runners.add(new Runner(runner, value1, value2));
        }

        runners.sort(new RunnerComparator());
        double fastest = Double.MAX_VALUE;
        ArrayList<Runner> finalTeam = new ArrayList<>();

        for (int i = 0; i < numOfRunners; i++) {
            ArrayList<Runner> tempTeam = new ArrayList<>();
            tempTeam.add(runners.get(i));
            double totalTime = runners.get(i).value1;

            for (int j = 0; j < numOfRunners && tempTeam.size() < 4; j++) {
                if (i != j) {
                    tempTeam.add(runners.get(j));
                    totalTime += runners.get(j).value2;
                }
            }

            if (totalTime < fastest) {
                fastest = totalTime;
                finalTeam = new ArrayList<>(tempTeam);
            }
        }
        System.out.println(fastest);
        finalTeam.forEach(runner -> System.out.println(runner.name));
    }

    static class RunnerComparator implements Comparator<Runner> {
        public int compare(Runner r1, Runner r2) {
            if (r1.value2 > r2.value2) return 1;
            if (r1.value2 < r2. value2) return -1;
            return 0;
        }
    }

    static class Runner {
        public String name;
        public double value1, value2;

        Runner(String name, double value1, double value2) {
            this.name = name;
            this.value1 = value1;
            this.value2 = value2;
        }
    }
}