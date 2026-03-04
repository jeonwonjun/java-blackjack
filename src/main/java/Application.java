public class Application {
    private static final int COURT_SCORE = 10;
    private static final int ACE_SCORE = 11;
    private static final int CARD_MIN = 1;
    private static final int CARD_MAX = 11;
    public static void main(String[] args) {
    }

    public static int cardScore(String firstCard, String secondCard) {
        int firstCardScore = parseScore(firstCard);
        int secondCardScore = parseScore(secondCard);
        validateScore(firstCardScore);
        validateScore(secondCardScore);
        return firstCardScore + secondCardScore;
    }

    public static void validateScore(int score) {
        if (score < CARD_MIN || score > CARD_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private static int parseScore(String card) {
        if (card.equals("J") || card.equals("Q") || card.equals("K")) {
            return COURT_SCORE;
        }

        if (card.equals("A")) {
            return ACE_SCORE;
        }

        return Integer.parseInt(card);
    }
}
