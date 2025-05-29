package parrot;

class EuropeanCryStrategy implements CryStrategy {
    @Override
    public String getCry(int numberOfCoconuts, double voltage, boolean isNailed) {
        return "Sqoork!";
    }
}
