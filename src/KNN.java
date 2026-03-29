import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.sqrt;


public class KNN {
    public static double dist(double[] arr1, double[] arr2) {
        double dist = 0;
        for (int i = 0; i < arr1.length; i++) {
            dist += (arr1[i] - arr2[i]) * (arr1[i] - arr2[i]);
        }
        return sqrt(dist);
    }
    public static List<DataPoint> loadData(File file) throws FileNotFoundException
    {
        List<DataPoint> data = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine().trim();
            while(!line.isEmpty())
            {
                String[] parts = line.split(",");
                double[] features = new double[parts.length - 1];

                for (int i = 0; i < parts.length - 1; i++) {
                    features[i] = Double.parseDouble(parts[i]);
                }

                String label = parts[parts.length - 1];
                data.add(new DataPoint(features, label));
            }

        }
        System.out.print("COS");
        scanner.close();
        return data;
    }
}
