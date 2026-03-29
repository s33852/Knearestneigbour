import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File trainFile = new File("src/iris.data");
        File testFile = new File("src/iris.test.data");
        System.out.print("1");
        List<DataPoint> trainSet = KNN.loadData(trainFile);
        List<DataPoint> testSet = KNN.loadData(testFile);
        
        System.out.print("Cos");
    }
}