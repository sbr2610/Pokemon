public class CalculDegats {

    public static int calculerPVPerdus(int niv, double att, double pui, double def,
                                       double stab, double efficacite,
                                       double coupCritique, double autresParams) {
        double aleatoire = 0.85 + Math.random() * 0.15;
        double cm = stab * efficacite * coupCritique * autresParams * aleatoire;

        double etape1 = Math.floor(niv * 0.4 + 2);
        double etape2 = Math.floor(etape1 * att * pui / def);
        double etape3 = Math.floor(etape2 / 50);
        double etape4 = etape3 + 2;
        return (int) Math.floor(etape4 * cm);
    }

    public static int calculerPVPerdus(int niv, double att, double pui, double def,
                                       double stab, EfficaciteType efficaciteType,
                                       double coupCritique, double autresParams) {
        return calculerPVPerdus(niv, att, pui, def, stab, efficaciteType.getCoefficient(), coupCritique, autresParams);
    }
}