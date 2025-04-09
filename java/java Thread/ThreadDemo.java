public class ThreadDemo {
    public static void main(String[] args)
    {
        MyThread t1 = new MyThread("1번 쓰레드");
        MyThread t2 = new MyThread("2번 쓰레드");
        MyThread t3 = new MyThread("3번 쓰레드");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("main함수가 종료되엇습니다.");
    }
}
