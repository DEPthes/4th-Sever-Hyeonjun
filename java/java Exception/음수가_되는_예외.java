public class 음수가_되는_예외 extends Exception {

    @Override
    public String getMessage()
    {
        return "지금 음수가 되는 숫자를 입력하였습니다.";
    }

}
