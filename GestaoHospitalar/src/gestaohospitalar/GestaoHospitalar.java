
package gestaohospitalar;


import gestaohospitalar.Utils.Console;
import gestaohospitalar.model.Medico;
import gestaohospitalar.model.Paciente;
import java.util.Scanner;

public class GestaoHospitalar {
    private static GestaoMedico gestaoMedico = new GestaoMedico();
    private static GestaoPaciente gestaoPaciente = new GestaoPaciente(gestaoMedico);
    private static GestaoConsulta gestaoConsulta = new GestaoConsulta(gestaoMedico, gestaoPaciente);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenu();
    }

    private static void exibirMenu() {
        boolean sair = false;
        while(!sair){
            Console.clear();
            System.out.println("=== Menu Gestao Hospitalar ===");
            System.out.println("0. Encerrar Programa");
            System.out.println("1. Medico");
            System.out.println("2. Paciente");
            System.out.println("3. Consulta");
            System.out.println("Escolha uma opcao: ");
            int opcao = Console.lerInteiro();

            switch (opcao) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    exibirMedico();
                    break;
                case 2:
                    exibirPaciente();
                    break;
                case 3:
                    exibirConsulta();
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
            Console.clear();
            System.out.println("\n=== Menu Medico ===");
            System.out.println("0. Voltar");
            System.out.println("1. Cadastrar Medico");
            System.out.println("2. Listar Medicos");
            System.out.println("3. Atualizar Medico");
            System.out.println("4. Deletar Medico");
            System.out.println("5. Buscar por um Medico");
            System.out.print("Escolha uma opcao: ");
            int opcao = Console.lerInteiro();

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
                    deletarMedico();
                    break;
                case 5:
                    gestaoMedico.buscarMedicoById();
                    break;
                default:
                    System.out.println("Opcao Invalida, Digite novamente");
                    break;
            }
        }
    }

    private static void exibirPaciente(){
        boolean sair = false;
        while (!sair) {
            Console.clear();
            System.out.println("\n=== Menu Paciente ===");
            System.out.println("0. Voltar");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Atualizar Paciente");
            System.out.println("4. Deletar Paciente");
            System.out.println("5. Buscar por um Paciente");
            System.out.println("Escolha uma opcao: ");
            int opcao = Console.lerInteiro();

            switch (opcao) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    gestaoPaciente.cadastrarPaciente();
                    break;
                case 2:
                    gestaoPaciente.listarPacientes();
                    break;
                case 3:
                    gestaoPaciente.atualizarPaciente();
                    break;
                case 4:
                    deletarPaciente();
                    break;
                case 5:
                    gestaoPaciente.buscarPacientePorId();
                    break;
                default:
                    System.out.println("Opcao Invalida, Digite novamente");
                    break;
            }
        }
    }

    private static void exibirConsulta(){
        boolean sair = false;
        while (!sair) {
            Console.clear();
            System.out.println("\n=== Menu Consulta ===");
            System.out.println("0. Voltar");
            System.out.println("1. Cadastrar Consulta");
            System.out.println("2. Listar Consultas");
            System.out.println("3. Atualizar Consulta");
            System.out.println("4. Deletar Consulta");
            System.out.println("5. Buscar por uma Consulta");
            System.out.println("Escolha uma opcao: ");
            int opcao = Console.lerInteiro();

            switch (opcao) {
                case 0:
                    sair = true;
                    break;
                case 1:
                    gestaoConsulta.cadastrarConsulta();
                    break;
                case 2:
                    gestaoConsulta.listarConsultas();
                    break;
                case 3:
                    gestaoConsulta.atualizarConsulta();
                    break;
                case 4:
                    gestaoConsulta.deletarConsulta();
                    break;
                case 5:
                    gestaoConsulta.buscarConsultaPorId();
                    break;
                default:
                    System.out.println("Opcao Invalida, Digite novamente");
                    break;
            }
        }    
    }
    
    private static void deletarPaciente() {
        Console.clear();
        System.out.println("=== Deletar Paciente ===");
        System.out.print("Digite o ID do paciente que deseja deletar: ");
        int id = Console.lerInteiro();
        Paciente paciente = gestaoPaciente.buscarPaciente(id);
        if (paciente != null) {
            if(!gestaoConsulta.possuiPaciente(paciente)){
                gestaoPaciente.remover(paciente);
                System.out.println("Paciente deletado com sucesso");
            }else{
                System.out.println("Paciente nao pode ser deletado: Ele esta registrado em uma consulta");
            }
        } else {
            System.out.println("Paciente nao encontrado");
        }
        System.out.println("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
    }
    
    public static void deletarMedico() {
        Console.clear();
        System.out.println("=== Deletar Medico ===");
        System.out.print("Digite o ID do medico que deseja deletar: ");
        int id = Console.lerInteiro();
        Medico medico = gestaoMedico.buscarMedico(id);
        if (medico != null) {
            if(!gestaoConsulta.possuiMedico(medico)){
                gestaoMedico.remover(medico);
                System.out.println("Medico deletado com sucesso");
            }else {
                System.out.println("Medico nao pode ser deletado: Ele esta registrado em uma consulta");
            }
        } else {
            System.out.println("Medico nao encontrado");
        }
        System.out.println("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
    }
}
