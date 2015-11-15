public class PerformanceTesterImpl implements PerformanceTester {
    @Override
    public PerformanceTestResult runPerformanceTest(Runnable task, int executionCount, int threadPoolSize) throws InterruptedException {
        for (int i = 0; i < threadPoolSize; i++) {
            long startTime = System.currentTimeMillis();
            for (int j = 0; j < executionCount; j++) {
                task.run();
            }
            long endTime = System.currentTimeMillis();
            FibApp.time.add(endTime - startTime);
        }
        long totalTime = 0;
        long minTime = Long.MAX_VALUE;
        long maxTime = Long.MIN_VALUE;
        for (Long aLong : FibApp.time) {
            totalTime += aLong;
            if(minTime > aLong){
                minTime = aLong;
            }
            if(maxTime < aLong){
                maxTime = aLong;
            }
        }

        return new PerformanceTestResult(totalTime, minTime, maxTime);
    }
}
