public class Anonymous {
    //2.메소드 내에서 지역변수로 활용
    static void method1()
    {
        Insect tar = new Insect(){
        @Override
        void build()
        {
            System.out.println("탈란툴라는 집을 만들지 않는다.");
        }
    };
        //지역 변수이기 때문에 곡 메소드 안에서 호출을 완료해 줘야한다.
        tar.build();

    }
    //3.메서드의 아규먼트 값으로 익명클래스 전달
    static void method2(Insect spi)
    {
        spi.build();
    }
    public static void main(String[] args)
    {
        //1.클래스 필드로 선언
        Insect wolf = new Insect(){
            @Override
            void build()
            {
                System.out.println("늑대거미는 대각선으로 집을 만든다.");
            }
            void run()
            {
                System.out.println("늑대거미는 느리게 달립니다.");
            }
        };
        wolf.build ();
        //wolf.run();

        //2. 지역변수로 활용
        method1();


        //3. 메서드의 아규먼트 값으로 익명클래스 전달
        method2(new Insect(){
            @Override
            void build()
            {
                System.out.println("검은독거미는 작은 집을 만든다.");
            }
        });

    }
}
