public class Main {
    public static void main(String[] args){
        Calculator calc = new Calculator();
        try{
            calc.add(3,-12);
        }
        catch (천을_넘는_예외 e)
        {
            System.out.println("지금 1000을 넘는 값을 입력하였습니다.");
        }
        catch (음수가_되는_예외 e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e){
        }
        finally {
            System.out.println("어떠한 오류가 발생하였습니다.");
        }

        calc.sub(3,4);

        calc.multi(3,4);
        calc.div(3,3);



    }
}
