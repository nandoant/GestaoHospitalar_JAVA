
package gestaohospitalar;

import java.util.Scanner;


public class GestaoHospitalar {
    private static GestaoMedico gestaoMedico;
    private static GestaoPaciente gestaoPaciente = new GestaoPaciente();
    private static GestaoConsulta gestaoConsulta;
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int op;
        do{
             op = menu();
               switch(op){
                  case 1-> gestaoPaciente.menu();
                  case 2-> System.out.println("Ainda não foi implementado");
                  case 3-> System.out.println("Ainda não foi implementado");
                  default-> System.out.println("Opcao Invalida!");
              }
        }while(op != 4);    
    }
    
    public static int menu(){
        int op;
        System.out.println("Informe uma opcao: \n\t 1-Paciente \n\t 2-Medico \n\t 3-Consulta \n\t 4-Sair");
        op = input.nextInt();
        return op;
    }
    
}
