import static java.lang.Math.sqrt;

public class KNN {
    public static double dist(double[] arr1, double[] arr2) {
        double dist = 0;
        for (int i = 0; i < arr1.length; i++) {
            dist += (arr1[i] - arr2[i]) * (arr1[i] - arr2[i]);
        }
        return sqrt(dist);
    }
    public static
}
