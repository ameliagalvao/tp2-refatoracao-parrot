package parrot;

public class SpeedStrategyFactory {
    public static SpeedStrategy getStrategy(ParrotTypeEnum type) {
        return switch (type) {
            case EUROPEAN       -> new EuropeanSpeedStrategy();
            case AFRICAN        -> new AfricanSpeedStrategy();
            case NORWEGIAN_BLUE -> new NorwegianBlueSpeedStrategy();
        };
    }
}
