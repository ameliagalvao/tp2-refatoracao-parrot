package parrot;

public class Parrot {

    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    // Eliminação dos magic number em getSpeed
    private static final double BASE_SPEED = 12.0;
    private static final double LOAD_FACTOR = 9.0;
    private static final double MAX_SPEED = 24.0;


    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    // Retirada da lógica de cada cálculo para cada uma das
    // espécies numa mesma função
    public double getSpeed() {
        return switch (type) {
            case EUROPEAN       -> calculateEuropeanSpeed();
            case AFRICAN        -> calculateAfricanSpeed();
            case NORWEGIAN_BLUE -> calculateNorwegianBlueSpeed();
        };
    }

    // ----- Lógicas de cálculo para cada papagaio ------

    private double calculateEuropeanSpeed() {
        return BASE_SPEED;
    }

    private double calculateAfricanSpeed() {
        // Subtrai carga (cocos) da velocidade base, mas nunca abaixo de zero
        double unloadedSpeed = BASE_SPEED - (LOAD_FACTOR * numberOfCoconuts);
        return Math.max(0, unloadedSpeed);
    }

    private double calculateNorwegianBlueSpeed() {
        // Se estiver nailed, não voa
        if (isNailed) {
            return 0;
        }
        // Caso contrário, aumenta a tensão até o máximo permitido
        return calculateSpeedByVoltage(voltage);
    }

    private double calculateSpeedByVoltage(double voltage) {
        // Evita extrapolar o limite máximo de velocidade
        return Math.min(MAX_SPEED, voltage * BASE_SPEED);
    }

    // --------------------------------------------------

    private double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    private double getLoadFactor() {
        return 9.0;
    }

    private double getBaseSpeed() {
        return 12.0;
    }

    public String getCry() {
        return switch (type) {
            case EUROPEAN -> "Sqoork!";
            case AFRICAN -> "Sqaark!";
            case NORWEGIAN_BLUE -> voltage > 0 ? "Bzzzzzz" : "...";
        };
    }
}