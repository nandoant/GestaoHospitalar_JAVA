package gestaohospitalar;

import gestaohospitalar.Utils.ConsoleUI;
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
        //adcionar um paciente para teste
        Paciente paciente = new Paciente(PacienteStatus.ENTRADA, "123456", "Unimed", 0, "Maria", "123456", "Rua 1", "123456");
        pacientes.add(paciente);
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
        System.out.println("=== Lista de Pacientes ===");
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
          int id = ConsoleUI.lerInteiro();
          Paciente paciente = buscarPaciente(id);
          if (paciente != null) {
              modificarPaciente(paciente);
              System.out.println("Paciente atualizado com sucesso");
          } else {
              System.out.println("Paciente nao encontrado");
          }
      }
    
    public Paciente buscarPaciente (int pacienteID) {
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
        int id = ConsoleUI.lerInteiro();
        Paciente paciente = buscarPaciente(id);
        if (paciente != null) {
            pacientes.remove(paciente);
            System.out.println("Paciente deletado com sucesso");
        } else {
            System.out.println("Paciente nao encontrado");
        }
    }
    
    private void modificarPaciente(Paciente paciente) {
        try{
            System.out.print("Digite o novo nome do paciente (ou pressione Enter para manter o mesmo): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) {
                paciente.setNome(nome);
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
            if(res.equalsIgnoreCase("S") || !res.isEmpty()){
                atualizarStatus(paciente);
            }
        } catch (Exception e) {
        System.out.println("Erro ao atualizar paciente: " + e.getMessage());
    }
    }

    
    private Paciente registrarPaciente() {
        
        String nome,cpf,endereco,telefone,numeroConvenio,nomeConvenio;
        PacienteStatus statusAtual;
       
        
        System.out.print("Digite o nome do paciente: ");
        nome = scanner.nextLine();

      
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
        
        if (nome.isEmpty() || cpf.isEmpty() || nomeConvenio.isEmpty() || numeroConvenio.isEmpty() || telefone.isEmpty() || endereco.isEmpty()) {
            System.out.println("Campos obrigatorios nao preenchidos");
            return null;
        }
        
        statusAtual = PacienteStatus.ENTRADA;
        return new Paciente(statusAtual, numeroConvenio, nomeConvenio,0,nome, cpf,endereco,telefone);
    }
    
    
    private boolean validarCpf(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return false;
            }
        }
        return true;
    }

    private void atualizarStatus(Paciente paciente){
  
        System.out.print("Informe o CRM do medico:");
        String crm = scanner.nextLine();
        System.out.print("Informe a senha do medico:");
        String senha = scanner.nextLine();
        
        var medicoEncontrado = medico.validarMedico(crm, senha);
        
        System.out.println("Verificando Medico...");

        if(medicoEncontrado == null){
            System.out.println("Acesso negado!");
            
        } else {
            System.out.println("Medico autenticado! \n");
            
            System.out.print("Digite o numero do novo status do paciente (ou pressione Enter para manter o mesmo): ");
            System.out.println("\nSTATUS \n\t 1 - ENTRADA \n\t 2 - TRATAMENTO_CLINICO_GERAL \n\t 3 - PREPARACAO_PRE_CIRURGICA \n\t 4 - CIRURGIA \n\t 5 - POS_CIRURGIA \n\t 6- ALTA_CLINICA;");
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
                         System.out.println("Opção inválida! Status não alterado.");
                         break;
                 }
             } else {
                 System.out.println("Nenhuma alteração de status foi feita.");
             }

            
        }
    }   
 }
    

