//3. 람다식을 사용하는 방법
interface Add2{
    int add(int a,int b);
}
public class Lamda2 {
    public static void main(String[] args)
    {
        Add2 a2 = (a,b) -> a+b;
        int x = a2.add(3,4);
        System.out.println(x);
    }
}
