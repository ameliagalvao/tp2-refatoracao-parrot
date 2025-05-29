package parrot;

final class CryStrategyFactory {
    public static CryStrategy getStrategy(ParrotTypeEnum type) {
        return switch (type) {
            case EUROPEAN       -> new EuropeanCryStrategy();
            case AFRICAN        -> new AfricanCryStrategy();
            case NORWEGIAN_BLUE -> new NorwegianBlueCryStrategy();
        };
    }
}
