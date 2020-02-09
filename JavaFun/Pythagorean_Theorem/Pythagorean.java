import java.lang.Math;
public class Pythagorean {
    public double calculateHypotenuse (double legA, double legB) {
        double legASquared = legA * legA;
        double legBSquared = legB * legB;
        double sum = legASquared + legBSquared;
        double squareroot = Math.sqrt(sum);
        return squareroot;
    }
}
