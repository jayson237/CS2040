import java.util.*;

class CardTrading {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int k = sc.nextInt();
        HashMap<Integer, Integer> deck = new HashMap<>();
        for (int i = 0; i < t; i++) {
            deck.put(i + 1, 0);
        }

        for (int i = 0; i < n; i++) {
            int cardType = sc.nextInt();
            int currentFrequency = deck.getOrDefault(cardType, 0);
            deck.put(cardType, currentFrequency + 1);
        }

        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            long buy = sc.nextLong();
            long sell = sc.nextLong();
            cards.add(new Card(i + 1, (2 - deck.get(i + 1)) * buy, deck.get(i + 1) * sell));
        }

        cards.sort(new CardPriceComparator());
        long profit = 0;
        for (int i = 0; i < k; i++) {
            Card card = cards.get(i);
            profit -= card.buyPrice;
        }

        for (int i = k; i < t; i++) {
            Card card = cards.get(i);
            profit += card.sellPrice;
        }
        System.out.println(profit);
    }

    static class Card {
        int type;

        long buyPrice, sellPrice;

        Card(int type, long buyPrice, long sellPrice) {
            this.type = type;
            this.buyPrice = buyPrice;
            this.sellPrice = sellPrice;
        }
    }

    static class CardPriceComparator implements Comparator<Card> {
        @Override
        public int compare(Card c1, Card c2) {
            long c1cost = c1.sellPrice + c1.buyPrice;
            long c2cost = c2.sellPrice + c2.buyPrice;
            if (c1cost < c2cost) return -1;
            if (c1cost > c2cost) return 1;
            if (c1.buyPrice < c2.buyPrice) return -1;
            if (c1.buyPrice > c2.buyPrice) return 1;
            return 0;
        }
    }
}