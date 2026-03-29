import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Math.sqrt;
import static java.util.Map.entry;


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
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine().trim();

                if(!line.isEmpty())
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

        }
        scanner.close();
        return data;
    }
    public static String classify(int k, List<DataPoint> trainData, DataPoint point)
    {
        Map<String, Double> neighbours = new HashMap<>(); // <key,value>
        for(DataPoint trainPoint : trainData)
        {
            double d = dist(trainPoint.feature,point.feature);
            neighbours.put(trainPoint.label,d);
        }
        List<Map.Entry<String, Double>> distances = new ArrayList<>(neighbours.entrySet());
        distances.sort(Map.Entry.comparingByValue());

        Map<String, Integer> votes = new HashMap<>();
        for(int i = 0; i<k; i++)
        {
            String label = distances.get(i).getKey();
            votes.put(label, votes.getOrDefault(label, 0) + 1);
        }
        return Collections.max(votes.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

}
