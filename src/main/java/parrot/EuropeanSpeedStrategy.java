package parrot;

class EuropeanSpeedStrategy implements SpeedStrategy {
    @Override
    public double calculateSpeed(int numberOfCoconuts, double voltage, boolean isNailed) {
        return FlightConfig.BASE_SPEED;
    }
}
