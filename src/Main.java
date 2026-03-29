import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        File trainFile = new File("src/iris.data");
        File testFile = new File("src/iris.test.data");

        List<DataPoint> trainSet = KNN.loadData(trainFile);
        List<DataPoint> testSet = KNN.loadData(testFile);

        while (true) {
            System.out.print("Write your k: ");
            int k = input.nextInt();
            input.nextLine();
            System.out.println("\nChoose option:");
            System.out.println("1 - Test accuracy");
            System.out.println("2 - Classify your own vector");
            System.out.println("0 - Exit");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    int correct = 0;

                    for (DataPoint testPoint : testSet) {
                        String predicted = KNN.classify(k, trainSet, testPoint);

                        if (predicted.equals(testPoint.label)) {
                            correct++;
                        }
                    }

                    double accuracy = (double) correct / testSet.size();
                    System.out.println("Accuracy: " + accuracy);
                    break;

                case 2:
                    System.out.println("Enter features separated by space:");

                    String line = input.nextLine();
                    String[] parts = line.split(" ");
                    double[] features = new double[parts.length];

                    for (int i = 0; i < parts.length; i++) {
                        features[i] = Double.parseDouble(parts[i]);
                    }

                    DataPoint userPoint = new DataPoint(features, "?");

                    String result = KNN.classify(k, trainSet, userPoint);
                    System.out.println("Predicted class: " + result);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}