package parrot;

public class Parrot {
    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;
    private final SpeedStrategy speedStrategy;
    private final CryStrategy cryStrategy;

    public Parrot(ParrotTypeEnum type,
                  int numberOfCoconuts,
                  double voltage,
                  boolean isNailed) {
        this.type             = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage          = voltage;
        this.isNailed         = isNailed;
        this.speedStrategy    = SpeedStrategyFactory.getStrategy(type);
        this.cryStrategy      = CryStrategyFactory.getStrategy(type);
    }

    public double getSpeed() {
        return speedStrategy.calculateSpeed(numberOfCoconuts, voltage, isNailed);
    }

    public String getCry() {
        return cryStrategy.getCry(numberOfCoconuts, voltage, isNailed);
    }
}
