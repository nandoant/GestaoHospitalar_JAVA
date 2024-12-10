package gestaohospitalar;

import gestaohospitalar.Utils.Console;
import gestaohospitalar.model.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoPaciente {
    private List<Paciente> pacientes;
    private Scanner scanner;
    private int contador = 1;

    public GestaoPaciente() {
        this.pacientes = new ArrayList<>();
        scanner = new Scanner(System.in);
        // adicionar um paciente para teste
        Paciente paciente = new Paciente( "123456", "Unimed", 0, "Maria", "123456", "Rua 1", "123456");
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

    private Paciente registrarPaciente() {
        Paciente paciente = new Paciente();
    
        while (true) {
            try {
                // Nome
                while (true) {
                    try {
                        System.out.print("Digite o nome do paciente: ");
                        paciente.setNome(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
    
                // CPF
                while (true) {
                    System.out.print("Digite o CPF do paciente: ");
                    String cpf = scanner.nextLine();
                    if (validarCpf(cpf)) {
                        paciente.setCpf(cpf);
                        break;
                    }
                    System.out.println("CPF invalido ou ja cadastrado. Tente novamente.");
                }
    
                // Nome do Convenio
                while (true) {
                    try {
                        System.out.print("Digite o nome do convenio do paciente: ");
                        paciente.setNomeConvenio(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
    
                // Numero do Convenio
                while (true) {
                    try {
                        System.out.print("Digite o numero do convenio do paciente: ");
                        paciente.setNumeroConvenio(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
    
                // Telefone
                while (true) {
                    try {
                        System.out.print("Digite o telefone do paciente: ");
                        paciente.setTelefone(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
    
                // Endereco
                while (true) {
                    try {
                        System.out.print("Digite o endereco do paciente: ");
                        paciente.setEndereco(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
    
                return paciente;
    
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                System.out.print("Deseja tentar novamente? (S/N): ");
                if (!scanner.nextLine().equalsIgnoreCase("S")) {
                    return null;
                }
            }
        }
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

    public void modificarPacienteInfo(Paciente paciente) {
        boolean continuarAtualizacao = true;
    
        while (continuarAtualizacao) {
            try {
                // Nome
                boolean nomeAtualizado = false;
                while (!nomeAtualizado) {
                    System.out.print("Digite o novo nome do paciente (ou pressione Enter para manter o mesmo): ");
                    String nome = scanner.nextLine();
                    if (nome.isEmpty()) {
                        nomeAtualizado = true;
                    } else if (nome.trim().length() > 0) {
                        paciente.setNome(nome);
                        nomeAtualizado = true;
                    } else {
                        System.out.println("Nome invalido. Tente novamente.");
                    }
                }
    
                // CPF
                boolean cpfAtualizado = false;
                while (!cpfAtualizado) {
                    System.out.print("Digite o novo CPF do paciente (ou pressione Enter para manter o mesmo): ");
                    String cpf = scanner.nextLine();
                    if (cpf.isEmpty()) {
                        cpfAtualizado = true;
                    } else if (validarCpf(cpf)) {
                        paciente.setCpf(cpf);
                        cpfAtualizado = true;
                    } else {
                        System.out.println("CPF invalido ou ja cadastrado. Tente novamente.");
                    }
                }
    
                // Endereco
                boolean enderecoAtualizado = false;
                while (!enderecoAtualizado) {
                    System.out.print("Digite o novo endereco do paciente (ou pressione Enter para manter o mesmo): ");
                    String endereco = scanner.nextLine();
                    if (endereco.isEmpty()) {
                        enderecoAtualizado = true;
                    } else if (endereco.trim().length() > 0) {
                        paciente.setEndereco(endereco);
                        enderecoAtualizado = true;
                    } else {
                        System.out.println("Endereco invalido. Tente novamente.");
                    }
                }
    
                // Telefone
                boolean telefoneAtualizado = false;
                while (!telefoneAtualizado) {
                    System.out.print("Digite o novo telefone do paciente (ou pressione Enter para manter o mesmo): ");
                    String telefone = scanner.nextLine();
                    if (telefone.isEmpty()) {
                        telefoneAtualizado = true;
                    } else if (telefone.trim().length() > 0) {
                        paciente.setTelefone(telefone);
                        telefoneAtualizado = true;
                    } else {
                        System.out.println("Telefone invalido. Tente novamente.");
                    }
                }
    
                // Numero do Convenio
                boolean numeroConvenioAtualizado = false;
                while (!numeroConvenioAtualizado) {
                    System.out.print("Digite o novo numero do convenio do paciente (ou pressione Enter para manter o mesmo): ");
                    String numeroConvenio = scanner.nextLine();
                    if (numeroConvenio.isEmpty()) {
                        numeroConvenioAtualizado = true;
                    } else if (numeroConvenio.trim().length() > 0) {
                        paciente.setNumeroConvenio(numeroConvenio);
                        numeroConvenioAtualizado = true;
                    } else {
                        System.out.println("Numero do convenio invalido. Tente novamente.");
                    }
                }
    
                // Nome do Convenio
                boolean nomeConvenioAtualizado = false;
                while (!nomeConvenioAtualizado) {
                    System.out.print("Digite o novo nome do convenio do paciente (ou pressione Enter para manter o mesmo): ");
                    String nomeConvenio = scanner.nextLine();
                    if (nomeConvenio.isEmpty()) {
                        nomeConvenioAtualizado = true;
                    } else if (nomeConvenio.trim().length() > 0) {
                        paciente.setNomeConvenio(nomeConvenio);
                        nomeConvenioAtualizado = true;
                    } else {
                        System.out.println("Nome do convenio invalido. Tente novamente.");
                    }
                }
    
                continuarAtualizacao = false;
    
            } catch (Exception e) {
                System.out.println("Erro ao atualizar paciente: " + e.getMessage());
                System.out.print("Deseja tentar novamente? (S/N): ");
                String resposta = scanner.nextLine();
                if (!resposta.equalsIgnoreCase("S")) {
                    continuarAtualizacao = false;
                }
            }
        }
    }
}
