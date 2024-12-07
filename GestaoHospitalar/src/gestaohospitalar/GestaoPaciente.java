package gestaohospitalar;

import gestaohospitalar.model.Paciente;
import gestaohospitalar.model.PacienteStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestaoPaciente {
    private List<Paciente> pacientes;
    private Scanner input;
    private static int contador = 0;

    public GestaoPaciente() {
        this.pacientes = new ArrayList<>();
        input = new Scanner(System.in);
    }
    
    public List<Paciente> getPaciente(){
        return pacientes;
    }
    
    public void cadastrarPaciente(){
        String nome,identidade,cpf,endereco,telefone,numeroConvenio,nomeConvenio;
        PacienteStatus statusAtual;
       
        System.out.println("===== CADASTRO PACIENTE ====");
        System.out.println("\nNome:  " );
        nome = input.nextLine();
        System.out.println("Identidade: ");
        identidade = input.nextLine();
        System.out.println("CPF: ");
        cpf = input.nextLine();
        System.out.println("Endereco: ");
        endereco = input.nextLine();
        System.out.println("Telefone: ");
        telefone = input.nextLine();
        System.out.println("Numero Convênio: ");
        numeroConvenio = input.nextLine();
        System.out.println("Nome Convênio");
        nomeConvenio = input.nextLine();
        statusAtual = PacienteStatus.ENTRADA;
        
        if(nome.isEmpty() || identidade.isEmpty() || cpf.isEmpty() || endereco.isEmpty() || telefone.isEmpty() || numeroConvenio.isEmpty() || nomeConvenio.isEmpty()){
            System.out.println("Esse campo não pode estar vazio!");
        }else{
            Paciente paciente = new Paciente(statusAtual, numeroConvenio, nomeConvenio, contador++ ,nome ,identidade ,cpf , endereco, telefone);
            paciente.setId(contador);
            if(pacientes.add(paciente)){
                System.out.println("Paciente Cadastradado com sucesso!");
            }else{
                System.out.println("Erro ao cadastrar paciente!");
            }   
        }
        
       
    }
    
    public void buscarPacientePorId(){
        int id;
        System.out.println("==== Buscando Paciente por ID ====");
        System.out.println("Informe o id do paciente: ");
        id = input.nextInt();
        
        for(Paciente paciente : pacientes){
            if(paciente.getId() == id){
                paciente.exibir();
            }else{
                System.out.println("Paciente nao encontrado.");
            }
        }
        
    }
    
    public void listarPacientes(){
        if(pacientes.isEmpty()){
            System.out.println("Nao ha nenhum paciente cadastrado");
        }else{
            System.out.println("==== Lista de Pacientes =====");
            for(Paciente paciente : pacientes){
                paciente.exibir();
            }
        }
    }
    
    public void atualizarPaciente(){
        String nome,identidade,cpf,endereco,telefone,numeroConvenio,nomeConvenio;
        int id, res ;
        
        System.out.println("==== Atualização de Paciente =====");
        System.out.println("Informe o id do paciente: ");
        id = input.nextInt();
        input.nextLine();
        for(Paciente paciente: pacientes){
            if(paciente.getId() == id){
                System.out.println("Informe o dado que voce deseja alterar: \n\t 0-Voltar \n\t 1-Nome \n\t 2-Identidade \n\t 3-CPF \n\t 4-Endereco \n\t 5-Telefone \n\t 6-Numero Convenio \n\t 7-Nome convenio");
                res = input.nextInt();
                input.nextLine();
                switch(res){
                    case 1 -> {
                        System.out.println("Informe o novo nome:");
                        nome = input.nextLine();
                        paciente.setNome(nome);
                    }
                    case 2 -> {
                        System.out.println("Informe a nova identidade:");
                        identidade = input.nextLine();
                        paciente.setIdentidade(identidade);
                    }
                    case 3 -> {
                        System.out.println("Informe o novo CPF:");
                        cpf = input.nextLine();
                        paciente.setCpf(cpf);
                    }
                    case 4 -> {
                        System.out.println("Informe o novo endereco:");
                        endereco = input.nextLine();
                        paciente.setEndereco(endereco);
                    }
                    case 5 -> {
                        System.out.println("Informe o novo telefone:");
                        telefone = input.nextLine();
                        paciente.setTelefone(telefone);
                    }
                    case 6 -> {
                        System.out.println("Informe o novo Numero do Convenio:");
                        numeroConvenio = input.nextLine();
                        paciente.setNumeroConvenio(numeroConvenio);
                    }
                    case 7 -> {
                        System.out.println("Informe o novo nome do Convenio:");
                        nomeConvenio = input.nextLine();
                        paciente.setNomeConvenio(nomeConvenio);
                    }
                    default -> System.out.println("Opçcao invalida!");     
                }
                
             System.out.println("Dados atualizados com sucesso!");       
            }else{
                System.out.println("Paciente nao encontrado!");
            }
         }
     }
    
    
    
    public void excluirPaciente(){
        System.out.println("==== Exclusão de Paciente ====");
        System.out.println("Informe o id do paciente: ");
        int id = input.nextInt();
        Paciente pacienteEncontrado = null;
        
        for(Paciente paciente : pacientes){
            if(paciente.getId() == id){
                pacienteEncontrado = paciente;
            }
        }
        if(pacienteEncontrado != null){
            pacientes.remove(pacienteEncontrado);
            System.out.println("Paciente com ID:" + id + " foi removido.");
        }else{
            System.out.println("Não foi possível encontrar um paciente com o ID " + id + ".");
        }
        
        
    }
    
    
      public void menu(){
        int op;
        do{
            System.out.println("Informe uma opcao: ");
            System.out.println("\t 0 - voltar \n\t 1- Cadastrar Paciente \n\t 2- Atualizar Paciente \n\t 3- Listar Pacientes \n\t 4- Buscar Paciente por Id \n\t 5- Excluir Paciente");
            op = input.nextInt();
            input.nextLine();
            
            switch(op){
                case 1-> cadastrarPaciente();
                case 2-> atualizarPaciente();
                case 3-> listarPacientes();
                case 4-> buscarPacientePorId();
                case 5-> excluirPaciente();
                default-> System.out.println("Opcao invalida");
                }
        }while(op != 6);
    }   
}
