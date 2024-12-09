package gestaohospitalar.Utils;

import java.util.Scanner;

public class Console {
    public static void clear(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static int lerInteiro(String mensagem){
        Scanner scanner = new Scanner(System.in);
        int valor = 0;
        boolean valido = false;
        do {
            System.out.print(mensagem);
            try {
                valor = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (Exception e) {
                System.out.println("Valor invalido. Tente novamente.");
            }
        } while (!valido);
        scanner.close();
        return valor;
    }

    public static int lerInteiro(){
        Scanner scanner = new Scanner(System.in);
        int valor = 0;
        boolean valido = false;
        do {
            try {
                valor = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (Exception e) {
                System.out.println("Valor invalido. Tente novamente.");
            }
        } while (!valido);


        return valor;
    }
}
