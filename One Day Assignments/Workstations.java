import java.util.*;

class Workstations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Comparator<Researcher> comparator = Comparator.comparingInt(x -> x.arrivalTime);
        PriorityQueue<Integer> workStation = new PriorityQueue<>();
        PriorityQueue<Researcher> stationQueue = new PriorityQueue<>(n, comparator);

        for (int i = 0; i < n; i++) {
            stationQueue.add(new Researcher(sc.nextInt(), sc.nextInt()));
        }

        int numOfUnlockings = 0;
        while (!stationQueue.isEmpty()) {
            Researcher currentResearcher = stationQueue.poll();

            while (!workStation.isEmpty() && workStation.peek() + m < currentResearcher.arrivalTime) {
                workStation.poll();
            }

            if (!workStation.isEmpty() && currentResearcher.arrivalTime <= workStation.peek() + m && workStation.peek() <= currentResearcher.arrivalTime) {
                workStation.poll();
                numOfUnlockings++;
            }

            workStation.add(currentResearcher.getStationAvailableTime());
        }
        System.out.println(numOfUnlockings);
    }

    static class Researcher {
        int arrivalTime;
        int stayingTime;

        Researcher(int arrivalTime, int stayingTime) {
            this.arrivalTime = arrivalTime;
            this.stayingTime = stayingTime;
        }

        int getStationAvailableTime() {
            return this.arrivalTime + this.stayingTime;
        }
    }
}