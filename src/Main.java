import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File trainFile = new File("src/iris.data");
        File testFile = new File("src/iris.test.data");

        List<DataPoint> trainSet = KNN.loadData(trainFile);
        List<DataPoint> testSet = KNN.loadData(testFile);
        int k;
        System.setOut("Write your k:");
        for(DataPoint trainPoint: testSet)
        {

        }

    }
}