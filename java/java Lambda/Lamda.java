//1.일반적으로 사용하는 방식
interface Add{
    int add(int a,int b);
}
class Myadd implements Add{
    @Override
    public int add(int a, int b)
    {
        return a+b;
    }
}
public class Lamda {
    public static void main(String[] args)
    {
        Add a = new Myadd();
        int x = a.add(3,4);
        System.out.println(x);
    }
}
