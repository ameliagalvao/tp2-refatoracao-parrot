package parrot;

class NorwegianBlueCryStrategy implements CryStrategy {
    @Override
    public String getCry(int numberOfCoconuts, double voltage, boolean isNailed) {
        return voltage > 0 ? "Bzzzzzz" : "...";
    }
}