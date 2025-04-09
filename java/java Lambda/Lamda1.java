//2.익명 클래스를 사용하는 방식
interface Add1{
    int add(int a,int b);
}
public class Lamda1 {
    public static void main(String[] args)
    {
        Add1 a = new Add1(){
            @Override
            public int add(int a, int b)
            {
                return a+b;
            }
        };
        int x = a.add(3,4);
        System.out.println(x);
    }
}
