import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FibApp implements Runnable{
    private static int argument;
    private static int calculationCount;
    private static int threadCount;

    public static volatile List<Long> time = new ArrayList<Long>();

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Enter Fibbonacci argument:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        argument = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter number of calculation:");
        calculationCount = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter number of threads:");
        threadCount = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();
        System.out.println();

        PerformanceTesterImpl performanceTester = new PerformanceTesterImpl();
        PerformanceTestResult performanceTestResult = performanceTester.runPerformanceTest(new FibApp(), calculationCount, threadCount);
        System.out.println(performanceTestResult.toString());

    }


    @Override
    public void run() {
        FibCalcImpl fibCalc = new FibCalcImpl();
        fibCalc.fib(argument);

    }
}
