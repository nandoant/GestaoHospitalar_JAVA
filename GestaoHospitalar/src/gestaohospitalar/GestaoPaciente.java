package gestaohospitalar;

import gestaohospitalar.model.Medico;
import gestaohospitalar.model.Paciente;

import gestaohospitalar.model.PacienteStatus;
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
    }
    
    public List<Paciente> getPaciente(){
        return pacientes;
    }
    
    public void cadastrarPaciente() {
        System.out.println("=== Cadastro de Paciente ===");
        Paciente paciente = registrarPaciente();
        if (paciente != null) {
            paciente.setId(contador++);
            this.pacientes.add(paciente);
            System.out.println("Paciente cadastrado com sucesso");
        }
    }
    
    public void listarPacientes() {
        System.out.println("=== Lista de Medicos ===");
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
                System.out.println("-----------------------------");
            }
        }
    }
    
    public void atualizarPaciente() {
          System.out.println("=== Atualizar Paciente ===");
          System.out.print("Digite o ID do paciente que deseja atualizar: ");
          int id = Integer.parseInt(scanner.nextLine());
          Paciente paciente = buscarPaciente(id);
          if (paciente != null) {
              modificarPaciente(paciente);
              System.out.println("Paciente atualizado com sucesso");
          } else {
              System.out.println("Paciente nao encontrado");
          }
      }
    
    private Paciente buscarPaciente (int pacienteID) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == pacienteID) {
                return paciente;
            }
        }
        return null;
    }
    
    
   
    public void deletarPaciente() {
        System.out.println("=== Deletar Paciente ===");
        System.out.print("Digite o ID do paciente que deseja deletar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Paciente paciente = buscarPaciente(id);
        if (paciente != null) {
            pacientes.remove(paciente);
            System.out.println("Paciente deletado com sucesso");
        } else {
            System.out.println("Paciente nao encontrado");
        }
    }
    
    private void modificarPaciente(Paciente paciente) {
        System.out.print("Digite o novo nome do paciente (ou pressione Enter para manter o mesmo): ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) {
            paciente.setNome(nome);
        }

        System.out.print("Digite a nova identidade do paciente (ou pressione Enter para manter o mesmo): ");
        String identidade = scanner.nextLine();
        if (!identidade.isEmpty() && validarIdentidade(identidade)) {
           paciente.setIdentidade(identidade);
        } else if (!identidade.isEmpty()) {
            System.out.println("Identidade ja cadastrada");
        }

        System.out.print("Digite o novo CPF do paciente (ou pressione Enter para manter o mesmo): ");
        String cpf = scanner.nextLine();
        if (!cpf.isEmpty() && validarCpf(cpf)) {
            paciente.setCpf(cpf);
        } else if (!cpf.isEmpty()) {
            System.out.println("CPF ja cadastrado");
        }

        System.out.print("Digite o novo endereco do paciente (ou pressione Enter para manter a mesma): ");
        String endereco = scanner.nextLine();
        if (!endereco.isEmpty()) {
            paciente.setEndereco(endereco);
        }

        System.out.print("Digite o novo telefone do paciente (ou pressione Enter para manter o mesmo): ");
        String telefone = scanner.nextLine();
        if (!telefone.isEmpty()) {
            paciente.setTelefone(telefone);
        }

        System.out.print("Digite o novo numero do convenio do paciente (ou pressione Enter para manter o mesmo): ");
        String numeroConvenio = scanner.nextLine();
        if (!numeroConvenio.isEmpty()) {
            paciente.setNumeroConvenio(numeroConvenio);
        }

        System.out.print("Digite o novo nome do convenio do paciente (ou pressione Enter para manter a mesma): ");
        String nomeConvenio = scanner.nextLine();
        if (!nomeConvenio.isEmpty()) {
            paciente.setNomeConvenio(nomeConvenio);
        }
        
        System.out.println("Deseja alterar o status do paciente? (pressione S para confirmar)");
        String res = scanner.nextLine().toUpperCase();
        if(res.equals("S") && !res.isEmpty()){
            atualizarStatus(paciente);
        }
        
    }

    
    private Paciente registrarPaciente() {
        
        String nome,identidade,cpf,endereco,telefone,numeroConvenio,nomeConvenio;
        PacienteStatus statusAtual;
       
        
        System.out.print("Digite o nome do paciente: ");
        nome = scanner.nextLine();

        System.out.print("Digite a identidade do paciente: ");
        identidade = scanner.nextLine();
        if (!validarIdentidade(identidade)) {
            System.out.println("Identidade ja cadastrada");
            return null;
        }

      
        System.out.print("Digite o CPF do paciente: ");
        cpf = scanner.nextLine();
        if (!validarCpf(cpf)) {
            System.out.println("CPF ja cadastrado");
            return null;
        }

        System.out.print("Digite o nome do convenio do paciente: ");
        nomeConvenio = scanner.nextLine();

        System.out.print("Digite o numero do convenio do paciente: ");
        numeroConvenio = scanner.nextLine();
        
        System.out.print("Digite o telefone do paciente: ");
        telefone = scanner.nextLine();

        System.out.print("Digite o endereco do paciente ");
        endereco = scanner.nextLine();
        
        if (nome.isEmpty() || identidade.isEmpty() || cpf.isEmpty() || nomeConvenio.isEmpty() || numeroConvenio.isEmpty() || telefone.isEmpty() || endereco.isEmpty()) {
            System.out.println("Campos obrigatorios nao preenchidos");
            return null;
        }
        
        statusAtual = PacienteStatus.ENTRADA;
        return new Paciente(statusAtual, numeroConvenio, nomeConvenio,0,nome, identidade, cpf,endereco,telefone);
    }
    
    
    private boolean validarCpf(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return false;
            }
        }
        return true;
    }
    
     private boolean validarIdentidade(String identidade) {
        for (Paciente paciente : pacientes) {
            if (paciente.getIdentidade().equals(identidade)) {
                return false;
            }
        }
        return true;
    }

    private void atualizarStatus(Paciente paciente){
        GestaoMedico medico = new GestaoMedico();
 
        System.out.println("Informe o CRM do medico:");
        String crm = scanner.nextLine();
        System.out.println("Informe a senha do medico:");
        String senha = scanner.nextLine();
        
        Medico medicoEncontrado = medico.validarMedico(crm, senha);
        
        if(medicoEncontrado != null){
              System.out.print("Digite o numero do novo status do paciente (ou pressione Enter para manter o mesmo): ");
              System.out.println(" \n STATUS PACIENTE: \n\t 1 - ENTRADA \n\t 2 - TRATAMENTO_CLINICO_GERAL \n\t 3 -PREPARACAO_PRE_CIRURGICA \n\t 4 - CIRURGIA \n\t 5 - POS_CIRURGIA \n\t 6- ALTA_CLINICA;");
              String status = scanner.nextLine();
              
             if (!status.isEmpty()) {
               int opcao = Integer.parseInt(status);
                    if (opcao >= 1 && opcao <= PacienteStatus.values().length) {
                        PacienteStatus novoStatus = PacienteStatus.values()[opcao - 1];
                        paciente.setStatusAtual(novoStatus);
                        System.out.println("Status atualizado com sucesso!");
                        } else {
                            System.out.println("Opção inválida! Nenhuma alteração foi feita.");
                        }
                    }
                    System.out.println("Status atualizado com sucesso!");
                    } else {
                        System.out.println("Acesso negado!");
                }
            }   
        }
    

