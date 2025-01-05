public class ClientTest {
    public static void main(String[] args) {
        HardCandy hardCandy = (HardCandy) CandyFactory.getCandy(CandyType.HARD);
        System.out.println(hardCandy.getCandyName());

        System.out.println("========================");

        Candy mintyCandy = CandyFactory.getCandy(CandyType.MINTY);
        System.out.println(mintyCandy.getCandyName());

        System.out.println("========================");

        Candy otherCandy  = CandyFactory.getCandy(null);
        System.out.println(otherCandy);

    }
}