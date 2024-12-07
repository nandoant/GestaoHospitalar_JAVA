package gestaohospitalar;

import java.io.Console;
import java.util.Scanner;

public class GestaoHospitalar {
    private static GestaoMedico gestaoMedico = new GestaoMedico();
    private static GestaoPaciente gestaoPaciente = new GestaoPaciente();
    private static GestaoConsulta gestaoConsulta = new GestaoConsulta();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenu();
    }

    private static void exibirMenu() {
        boolean sair = false;
        while(!sair){
            System.out.println("=== Menu Gestao Hospitalar ===");
            System.out.println("0. Encerrar Programa");
            System.out.println("1. Medico");
            System.out.println("2. Paciente");
            System.out.println("3. Consulta");
            System.out.println("Escolha uma opcao: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    exibirMedico();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcao Invalida, Digite novamente");
                    break;
            }
        }
    }

    private static void exibirMedico(){
        boolean sair = false;
        while (!sair) {

            System.out.println("\n=== Menu Medico ===");
            System.out.println("0. Voltar");
            System.out.println("1. Cadastrar Medico");
            System.out.println("2. Listar Medicos");
            System.out.println("3. Atualizar Medico");
            System.out.println("4. Deletar Medico");
            System.out.println("Escolha uma opcao: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    gestaoMedico.cadastrarMedico();
                    break;
                case 2:
                    gestaoMedico.listarMedicos();
                    break;
                case 3:
                    gestaoMedico.atualizarMedico();
                    break;
                case 4:
                    gestaoMedico.deletarMedico();
                    break;
                default:
                    System.out.println("Opcao Invalida, Digite novamente");
                    break;
            }
        }
    }
    
}
