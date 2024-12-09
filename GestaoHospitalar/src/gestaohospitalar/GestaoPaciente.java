package gestaohospitalar;

import gestaohospitalar.Utils.Console;
import gestaohospitalar.model.Paciente;
import gestaohospitalar.model.PacienteStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoPaciente {
    private List<Paciente> pacientes;
    private GestaoMedico medico;
    private Scanner scanner;
    private int contador = 1;

    public GestaoPaciente(GestaoMedico medico) {
        this.pacientes = new ArrayList<>();
        scanner = new Scanner(System.in);
        this.medico = medico;
        // adicionar um paciente para teste
        Paciente paciente = new Paciente(PacienteStatus.ENTRADA, "123456", "Unimed", 0, "Maria", "123456", "Rua 1", "123456");
        pacientes.add(paciente);
    }

    public List<Paciente> getPaciente() {
        return pacientes;
    }

    public void cadastrarPaciente() {
        Console.clear();
        System.out.println("=== Cadastro de Paciente ===");
        Paciente paciente = registrarPaciente();
        if (paciente != null) {
            paciente.setId(contador++);
            this.pacientes.add(paciente);
            Console.clear();
            System.out.println("=== Cadastro de Paciente ===");
            System.out.println(paciente);
            System.out.println("Paciente cadastrado com sucesso");
        } else {
            System.out.println("Falha ao cadastrar paciente. Campos obrigatorios nao preenchidos ou CPF ja cadastrado.");
        }
        System.out.println("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
    }

    public void listarPacientes() {
        Console.clear();
        System.out.println("=== Lista de Pacientes ===");
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
        System.out.println("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
    }
    
    public void exibirPacientes(){
        Console.clear();
        System.out.println("=== Lista de Pacientes ===");
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
    }

    public void atualizarPaciente() {
        Console.clear();
        System.out.println("=== Atualizar Paciente ===");
        System.out.print("Digite o ID do paciente que deseja atualizar: ");
        int id = Console.lerInteiro();
        Paciente paciente = buscarPaciente(id);
        if (paciente != null) {
            Console.clear();
            System.out.println("=== Atualizar Paciente ===");
            System.out.println(paciente);
            modificarPaciente(paciente);
            Console.clear();
            System.out.println("=== Atualizar Paciente ===");
            System.out.println(paciente);
            System.out.println("Paciente atualizado com sucesso");
        } else {
            System.out.println("Paciente nao encontrado");
        }
        System.out.println("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
    }

    public void remover(Paciente paciente){
        pacientes.remove(paciente);
    }

    public void buscarPacientePorId() {
        Console.clear();
        System.out.println("=== Buscar Paciente por ID ===");
        System.out.print("Digite o ID do paciente: ");
        int id = Console.lerInteiro();
        
        Paciente paciente = buscarPaciente(id);
        if (paciente != null) {
            System.out.println(paciente);
        } else {
            System.out.println("Paciente nao encontrado");
        }
        
        System.out.println("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
    }

    public Paciente buscarPaciente(int pacienteID) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == pacienteID) {
                return paciente;
            }
        }
        return null;
    }

    private void modificarPaciente(Paciente paciente) {
        try {
            System.out.print("Digite o novo nome do paciente (ou pressione Enter para manter o mesmo): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) {
                paciente.setNome(nome);
            }

            System.out.print("Digite o novo CPF do paciente (ou pressione Enter para manter o mesmo): ");
            String cpf = scanner.nextLine();
            if (!cpf.isEmpty()) {
                if (validarCpf(cpf)) {
                    paciente.setCpf(cpf);
                } else {
                    System.out.println("CPF ja cadastrado. CPF nao alterado.");
                }
            }

            System.out.print("Digite o novo endereco do paciente (ou pressione Enter para manter o mesmo): ");
            String endereco = scanner.nextLine();
            if (!endereco.isEmpty()) {
                paciente.setEndereco(endereco);
            }

            System.out.print("Digite o novo telefone do paciente (ou pressione Enter para manter o mesmo): ");
            String telefone = scanner.nextLine();
            if (!telefone.isEmpty()) {
                paciente.setTelefone(telefone);
            }

            System.out.print("Digite o novo número do convenio do paciente (ou pressione Enter para manter o mesmo): ");
            String numeroConvenio = scanner.nextLine();
            if (!numeroConvenio.isEmpty()) {
                paciente.setNumeroConvenio(numeroConvenio);
            }

            System.out.print("Digite o novo nome do convenio do paciente (ou pressione Enter para manter o mesmo): ");
            String nomeConvenio = scanner.nextLine();
            if (!nomeConvenio.isEmpty()) {
                paciente.setNomeConvenio(nomeConvenio);
            }

            System.out.print("Deseja alterar o status do paciente? (pressione S para confirmar): ");
            String res = scanner.nextLine().toUpperCase();
            if (res.equalsIgnoreCase("S")) {
                atualizarStatus(paciente);
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar paciente: " + e.getMessage());
        }
    }

    private Paciente registrarPaciente() {
        String nome, cpf, endereco, telefone, numeroConvenio, nomeConvenio;
        PacienteStatus statusAtual;

        System.out.print("Digite o nome do paciente: ");
        nome = scanner.nextLine();

        System.out.print("Digite o CPF do paciente: ");
        cpf = scanner.nextLine();
        if (!validarCpf(cpf)) {
            return null;
        }

        System.out.print("Digite o nome do convenio do paciente: ");
        nomeConvenio = scanner.nextLine();

        System.out.print("Digite o número do convenio do paciente: ");
        numeroConvenio = scanner.nextLine();

        System.out.print("Digite o telefone do paciente: ");
        telefone = scanner.nextLine();

        System.out.print("Digite o endereco do paciente: ");
        endereco = scanner.nextLine();

        if (nome.isEmpty() || cpf.isEmpty() || nomeConvenio.isEmpty() || numeroConvenio.isEmpty() || telefone.isEmpty() || endereco.isEmpty()) {
            return null;
        }

        statusAtual = PacienteStatus.ENTRADA;
        return new Paciente(statusAtual, numeroConvenio, nomeConvenio, 0, nome, cpf, endereco, telefone);
    }

    private boolean validarCpf(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                System.out.println("CPF ja cadastrado. Operacao cancelada.");
                return false;
            }
        }
        return true;
    }

    private void atualizarStatus(Paciente paciente) {
        System.out.print("Informe o CRM do médico: ");
        String crm = scanner.nextLine();
        System.out.print("Informe a senha do médico: ");
        String senha = scanner.nextLine();

        var medicoEncontrado = medico.validarMedico(crm, senha);

        System.out.println("Verificando Médico...");

        if (medicoEncontrado == null) {
            System.out.println("Acesso negado!");
        } else {
            System.out.println("Médico autenticado!\n");
            System.out.println("STATUS:");
            System.out.println("\t1 - ENTRADA");
            System.out.println("\t2 - TRATAMENTO_CLINICO_GERAL");
            System.out.println("\t3 - PREPARACAO_PRE_CIRURGICA");
            System.out.println("\t4 - CIRURGIA");
            System.out.println("\t5 - POS_CIRURGIA");
            System.out.println("\t6 - ALTA_CLINICA");
            System.out.print("Digite o número do novo status do paciente: ");
            String status = scanner.nextLine();

            if (!status.isEmpty()) {
                int opcao = Integer.parseInt(status);
                switch (opcao) {
                    case 1:
                        paciente.setStatusAtual(PacienteStatus.ENTRADA);
                        break;
                    case 2:
                        paciente.setStatusAtual(PacienteStatus.TRATAMENTO_CLINICO_GERAL);
                        break;
                    case 3:
                        paciente.setStatusAtual(PacienteStatus.PREPARACAO_PRE_CIRURGICA);
                        break;
                    case 4:
                        paciente.setStatusAtual(PacienteStatus.CIRURGIA);
                        break;
                    case 5:
                        paciente.setStatusAtual(PacienteStatus.POS_CIRURGIA);
                        break;
                    case 6:
                        paciente.setStatusAtual(PacienteStatus.ALTA_CLINICA);
                        break;
                    default:
                        System.out.println("Opcao invalida! Status nao alterado.");
                        break;
                }
            } else {
                System.out.println("Nenhuma alteracao de status foi feita.");
            }
        }
    }
}