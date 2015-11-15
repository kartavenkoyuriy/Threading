public class FibCalcImpl implements FibCalc {

    @Override
    public long fib(int arg) {
        if(arg == 0){
            return 0;
        }
        if(arg == 1){
            return 1;
        }
        return fib(arg - 2) + fib(arg - 1);

    }
}
