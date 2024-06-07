import java.util.Scanner;

public class MagicalNumbersGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r;

        System.out.println("\nWelcome You! IN THE JARGON OF A NUMBER..");
        System.out.println("Press Enter to continue....");
        scanner.nextLine();
        System.out.println();
        System.out.println("Just think a number between 1 to 63 in your mind");
        System.out.println("Think on one");
        System.out.println("Do not enter that number");
        System.out.println("I will find that number on your mind....");
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        System.out.println();
        System.out.println("By Just answering few questions....");
        System.out.println("If your number is present in the numbers");
        System.out.println("shown on your screen,Then press P and if not present");
        System.out.println("then press N");
        System.out.println("But please be honest while entering the answer...");
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        System.out.println();

        r = generate(scanner);
        if (r == 0) {
            System.out.println("You didn't think of any number between 1 to 63");
            System.out.println("So try again...");
        } else {
            System.out.println("Your number is " + r);
            System.out.println("Surprised! But friends it is not a magic,");
            System.out.println("it just involves some mathematical computation....");
            System.out.println("so guys just try to find out the method.");
            System.out.println("Thank You!");
        }
    }

    public static int generate(Scanner scanner) {
        int a, i, j, f, n, r = 0;
        int[] num = new int[6];
        char[] ch = new char[6];

        for (j = 0; j <= 5; j++) {
            f = fun(j);
            for (i = 1; i <= 63; i++) {
                a = i & f;
                if (a == f)
                    System.out.print("\t" + i);
            }

            System.out.println("\nLet me remind you if the number is present then");
            System.out.println("press P otherwise press N");
            System.out.print("Enter your answer: ");
            ch[j] = scanner.next().charAt(0);
            System.out.println("Press Enter to continue....");
            scanner.nextLine();

            if (ch[j] == 'p' || ch[j] == 'P') {
                num[j] = 1;
                n = fun(j);
                r = r + n;
            } else
                num[j] = 0;

            scanner.nextLine();
        }

        System.out.println(r);
        return r;
    }

    public static int fun(int j) {
        if (j == 0)
            return 1;
        else
            return 2 * fun(j - 1);
    }
}
