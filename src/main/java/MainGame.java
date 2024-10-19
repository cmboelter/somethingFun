import java.util.Arrays;

public class MainGame {
    public static void main(String []args)
    {
        System.out.println("       ┏━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("       ┃───────────────────┃");
        System.out.println("━━━━━━━┛ ║─────────────────┃");
        System.out.println("         ║─────────────────┃");
        System.out.println("━━━━━━━┓ ║─────────────────┃");
        System.out.println("       ┃───────────────────┃");
        System.out.println("       ┃───────────────────┃");
        System.out.println("       ┗━━━━━━━━━━━━━━━━━━━┛");



        Characters blompy1 = new Characters("Blompy", "B");
        blompy1.setLocation(0, 0, blompy1.getSymbol());


        System.out.println(blompy1.getSymbol());
        System.out.println(Arrays.deepToString(blompy1.getLocation()));




    }




};

