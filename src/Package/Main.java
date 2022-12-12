package Package;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Parser parser=new Parser();
        LA la = new LA("D:\\LA.txt");
        String token;
        int i = 0;
       //SyntaxTree parseTree = new SyntaxTree("EXPRESSION");
        ParserM parserm = new ParserM(0, "D:\\LA.txt");
        ArrayList<String> TokenName = la.TokenName;
        ArrayList<Byte> TokenType = la.TokenType;
        Scanner input = new Scanner(System.in);
        System.out.println("1: nur Lexikalische Analyse");
        System.out.println("2: lexikalische Analyse und Parser");
        int Input = Integer.parseInt(input.nextLine());
        if (Input == 1) {
            while (true) {
                token = la.Nexttoken();
                System.out.println(token);
                System.out.println(la.CurrentState);

                if (token.equals("$")) {
                    break;
                }
            }

            for (int j = 0; j < TokenName.size(); j++) {
                System.out.println(j + " : " + TokenName.get(j) + "  " + TokenType.get(j));
            }
        } else if (Input == 2) {
            while (true) {
                token = la.Nexttoken();
                System.out.println(token);
                System.out.println(la.CurrentState);

                if (token.equals("$")) {
                    break;
                }
            }

            for (int j = 0; j < TokenName.size(); j++) {
                System.out.println(j + " : " + TokenName.get(j) + "  " + TokenType.get(j));
            }
            if (parserm.EXPRESSION(0)) {
                System.out.println("ok");
            }
            for (int j = 0; j < parserm.Childname.size(); j++) {
                for (int k = 0; k < parserm.Chilnummer.get(j); k++) {
                    System.out.print("\t");
                }
                System.out.println(parserm.Childname.get(j));
            }
        }
    }
}
