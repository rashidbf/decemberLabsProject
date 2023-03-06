package utils;

public enum TimeSeconds {

    ONE_SECOND(1),

    TWO_SECOND(2),

    THREE_SECOND(3),

    FOUR_SECOND(4),

    FIVE_SECOND(5),

    SIX_SECOND(6);

    private final int seconds;

    private TimeSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }
}
