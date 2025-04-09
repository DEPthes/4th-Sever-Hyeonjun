public class HambugerProgram {
    public static void main(String[] args)
    {
        try{
            HambugerCook hamcook = new HambugerCook(50);
            new Thread(hamcook,"A").start();
            new Thread(hamcook,"B").start();
            new Thread(hamcook,"C").start();
            new Thread(hamcook,"D").start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class HambugerCook implements Runnable{

    private int hambugerNum;
    private String[] burners ={"_","_","_","_"};

    public HambugerCook(int count)
    {
        hambugerNum = count;
    }
    @Override
    public void run() {
        while(hambugerNum>0)
        {
            //한번에 하나의 쓰레드만 접근 가능함.
            synchronized(this){
                this.hambugerNum--;
                System.out.println(Thread.currentThread().getName() +" : " + hambugerNum+"개 남았습니다.");
            }
            for(int i=0;i<burners.length;i++)
            {
                if(!burners[i].equals("_")) continue;
                synchronized (this){
                    burners[i] = Thread.currentThread().getName();
                    System.out.println("                     "+Thread.currentThread().getName()+": ["+(i+1)+"]번 버너 ON");
                    showBurners();
                }
                try {
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (this){
                    burners[i] = "_";
                    System.out.println("                     "+Thread.currentThread().getName()+": ["+(i+1)+"]번 버너 OFF");
                    showBurners();
                }
                break;
            }
            try {
                Thread.sleep(Math.round(1000*Math.random()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void showBurners()
    {
        String toPrint = "";
        for(int i=0;i<burners.length;i++)
        {
            toPrint+=(" "+burners[i]);
        }
        System.out.println(toPrint);
    }
}
