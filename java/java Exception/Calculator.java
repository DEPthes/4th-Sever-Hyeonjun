public class Calculator {

    public int add(int x, int y) throws 천을_넘는_예외, 음수가_되는_예외 {
        int result = x+y;
        if(result>1000)
        {
            throw new 천을_넘는_예외();

        }
        if(result<0)
        {
            throw new 음수가_되는_예외();
        }
        return x+y;
    }

    public int sub(int x, int y) {
        return x-y;
    }

    public int multi(int x, int y) {
        return x*y;
    }

    public int div(int x, int y) {
        return x/y;
    }
}
