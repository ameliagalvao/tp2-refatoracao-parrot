package parrot;

class NorwegianBlueSpeedStrategy implements SpeedStrategy {
    @Override
    public double calculateSpeed(int numberOfCoconuts, double voltage, boolean isNailed) {
        if (isNailed) {
            return 0;
        }
        double raw = voltage * FlightConfig.BASE_SPEED;
        return Math.min(FlightConfig.MAX_SPEED, raw);
    }
}