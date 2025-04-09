class wolfSpider extends Insect{
    @Override
    void build()
    {
        System.out.println("늑대거미는 대각선으로 집을 만든다.");
    }
}

class tarantula extends Insect{
    @Override
    void build()
    {
        System.out.println("탈란툴라는 집을 만들지 않는다.");

    }
}
class blackTarantula extends Insect{
    @Override
    void build()
    {
        System.out.println("검은독거미는 작은 집을 만든다.");

    }
}
class ghostSpider extends Insect{
    @Override
    void build()
    {
        System.out.println("유령거미는 얇은 거미줄로 집을 만든다.");

    }
}

public class General {
    public static void main(String[] args)
    {
        Insect wolf = new wolfSpider();
        wolf.build();
        Insect tar = new tarantula();
        tar.build();
        Insect btar = new blackTarantula();
        btar.build();
        Insect ghost = new ghostSpider();
        ghost.build();
    }
}
