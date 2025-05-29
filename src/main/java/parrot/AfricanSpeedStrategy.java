package parrot;

class AfricanSpeedStrategy implements SpeedStrategy {
    @Override
    public double calculateSpeed(int numberOfCoconuts, double voltage, boolean isNailed) {
        double load = FlightConfig.LOAD_FACTOR * numberOfCoconuts;
        double speedAfterLoad = FlightConfig.BASE_SPEED - load;
        return Math.max(0, speedAfterLoad);
    }
}