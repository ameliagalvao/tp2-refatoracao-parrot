package parrot;

public class Parrot {

    // ----- Eliminação dos magic numbers ----
    private static final double BASE_SPEED = 12.0;
    private static final double LOAD_FACTOR = 9.0;
    private static final double MAX_SPEED = 24.0;
    private static final double NOISE_THRESHOLD_VOLTAGE = 0.0;
    // ---------------------------------------

    // ----- Gritos de cada tipo de papagaio --
    private static final String CRY_EUROPEAN = "Sqoork!";
    private static final String CRY_AFRICAN = "Sqaark!";
    private static final String CRY_NORWEGIAN_BLUE_BUZZ = "Bzzzzzz";
    private static final String CRY_NORWEGIAN_BLUE_SILENT = "...";
    // ----------------------------------------

    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

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
            case EUROPEAN -> calculateEuropeanSpeed();
            case AFRICAN -> calculateAfricanSpeed();
            case NORWEGIAN_BLUE -> calculateNorwegianBlueSpeed();
            default -> throw new IllegalStateException("Tipo de papagaio desconhecido: " + type);
        };
    }

    // ----- Lógicas de cálculo para cada papagaio ------

    private double calculateEuropeanSpeed() {
        return BASE_SPEED;
    }

    private double calculateAfricanSpeed() {
        double unloadedSpeed = BASE_SPEED - (LOAD_FACTOR * numberOfCoconuts);
        return Math.max(0, unloadedSpeed);
    }

    private double calculateNorwegianBlueSpeed() {
        if (isNailed) {
            return 0;
        }
        return calculateSpeedByVoltage(voltage);
    }

    private double calculateSpeedByVoltage(double voltage) {
        return Math.min(MAX_SPEED, voltage * BASE_SPEED);
    }

    // --------------------------------------------------

    private String getNorwegianBlueCry() {
        return (voltage > NOISE_THRESHOLD_VOLTAGE)
                ? CRY_NORWEGIAN_BLUE_BUZZ
                : CRY_NORWEGIAN_BLUE_SILENT;
    }

    public String getCry() {
        return switch (type) {
            case EUROPEAN -> CRY_EUROPEAN;
            case AFRICAN -> CRY_AFRICAN;
            case NORWEGIAN_BLUE -> getNorwegianBlueCry();
            default -> throw new IllegalStateException("Tipo de papagaio desconhecido: " + type);
        };
    }
}