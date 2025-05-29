package parrot;

class AfricanCryStrategy implements CryStrategy {
    @Override
    public String getCry(int numberOfCoconuts, double voltage, boolean isNailed) {
        return "Sqaark!";
    }
}

