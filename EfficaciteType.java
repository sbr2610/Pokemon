public enum EfficaciteType {

    IMMUNE(0.0),
    PEU_EFFICACE(0.25),
    MOITIE_EFFICACE(0.5),
    NORMAL(1.0),
    SUPER_EFFICACE(2.0),
    HYPER_EFFICACE(4.0);

    private final double coefficient;

    EfficaciteType(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }
}