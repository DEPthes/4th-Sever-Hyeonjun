public class Annoymous_to_interface {
    public static void main(String[] args)
    {
        Animal dog = new Animal() {
            @Override
            public String bark() {
                return "멍멍";
            }

            @Override
            public String move() {
                return "쫑쫑";
            }
        };
    }
}
