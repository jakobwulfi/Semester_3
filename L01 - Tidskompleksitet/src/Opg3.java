import java.util.Arrays;

public class Opg3 {


    public static double[] prefixAverage(int[] inputTal) {
        double[] averagePrefix = new double[inputTal.length];
        for (int i = 0; i < inputTal.length; i++) {
            double sum = 0;
            for (int j = 0; j < i+1; j++) {
                sum += inputTal[j];
            }
            sum = sum/(i+1);
            averagePrefix[i] = sum;
        }
        return averagePrefix;
    }

    public static void main(String[] args) {
        int[] intArray = {5, 10, 5, 6, 4, 9, 8};
        System.out.println(Arrays.toString(prefixAverage(intArray)));
    }
}
