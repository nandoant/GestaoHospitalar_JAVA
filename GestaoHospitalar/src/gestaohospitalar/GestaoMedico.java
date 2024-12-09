package gestaohospitalar;

import gestaohospitalar.Utils.ConsoleUI;
import gestaohospitalar.model.Medico;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoMedico {
    private List<Medico> medicos;
    private int contador = 1;
    private Scanner scanner;

    public GestaoMedico() {
        this.medicos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        //adcionar um medico para teste
        Medico medico = new Medico(0, "Cardiologista", "123456", "123456", "123456", "Joao", "123456", "Rua 1", "123456");
        medicos.add(medico);
    }


    public void listarMedicos() {
        ConsoleUI.clear();
        System.out.println("=== Lista de Medicos ===");
        exibirMedicos();
        System.out.println("\nPressione qualquer tecla para continuar...");
        scanner.nextLine();
    }

    public void exibirMedicos(){
        if (medicos.isEmpty()) {
            System.out.println("Nenhum medico cadastrado.");
        } else {
            for (Medico medico : medicos) {
                System.out.println(medico);
            }
        }
    }

    public void cadastrarMedico() {
        ConsoleUI.clear();
        System.out.println("=== Cadastro de Medico ===");
        Medico medico = coletarDadosMedico(null);
        medico.setId(contador++);
        medicos.add(medico);

        ConsoleUI.clear();
        System.out.println("=== Cadastro de Medico ===");
        System.out.println(medico);
        System.out.println("Medico cadastrado com sucesso");
        System.out.println("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
    }
    
    private void modificarMedico(Medico medico) {
        coletarDadosMedico(medico);
    }

    public void atualizarMedico() {
        ConsoleUI.clear();
        System.out.println("=== Atualizar Medico ===");
        System.out.print("Digite o ID do medico que deseja atualizar: ");
        int id = ConsoleUI.lerInteiro();
        Medico medico = buscarMedico(id);
        if (medico != null) {
            ConsoleUI.clear();
            System.out.println("=== Atualizar Medico ===");
            System.out.println(medico);
            modificarMedico(medico);

            ConsoleUI.clear();
            System.out.println("=== Atualizar Medico ===");
            System.out.println(medico);
            System.out.println("Medico atualizado com sucesso");
            System.out.println("Pressione qualquer tecla para continuar...");
            scanner.nextLine();
        } else {
            System.out.println("Medico nao encontrado");
        }
    }

    public void deletarMedico() {
        ConsoleUI.clear();
        System.out.println("=== Deletar Medico ===");
        System.out.print("Digite o ID do medico que deseja deletar: ");
        int id = ConsoleUI.lerInteiro();
        Medico medico = buscarMedico(id);
        if (medico != null) {
            medicos.remove(medico);
            System.out.println("Medico deletado com sucesso");
        } else {
            System.out.println("Medico nao encontrado");
        }
        System.out.println("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
    }

    public Medico buscarMedico(int medicoID) {
        for (Medico medico : medicos) {
            if (medico.getId() == medicoID) {
                return medico;
            }
        }
        return null;
    }

    private Medico coletarDadosMedico(Medico medicoExistente) {
        Medico medico = medicoExistente != null ? medicoExistente : new Medico();
        String[] campos = {"nome", "CRM", "CTPS", "CPF", "especialidade", "telefone", "endereco", "senha"};
        
        for (String campo : campos) {
            boolean valido = false;
    
            while (!valido) {
                System.out.print("Digite o " + campo + " do medico" + (medicoExistente != null ? " (ou Enter para manter o mesmo)" : "") + ": ");
                String valor = scanner.nextLine();
    
                try{
                if (valor.isEmpty() && medicoExistente != null) {
                    // Mantem o valor atual
                    valido = true;
                } else if (!valor.isEmpty() || medicoExistente == null) {
                    switch (campo) {
                        case "nome":
                        case "especialidade":
                        case "telefone":
                        case "endereco":
                        case "senha":
                            setCampoMedico(medico, campo, valor);
                            valido = true;
                            break;
                        case "CRM":
                            if (validarCrm(valor)) {
                                
                                setCampoMedico(medico, campo, valor);
                                valido = true;
                            } else {
                                System.out.println("CRM ja cadastrado. Tente novamente.");
                            }
                            break;
                        case "CTPS":
                            if (validarCtps(valor)) {
                                setCampoMedico(medico, campo, valor);
                                valido = true;
                            } else {
                                System.out.println("CTPS ja cadastrado. Tente novamente.");
                            }
                            break;
                        case "CPF":
                            if (validarCpf(valor)) {
                                setCampoMedico(medico, campo, valor);
                                valido = true;
                            } else {
                                System.out.println("CPF ja cadastrado. Tente novamente.");
                            }
                            break;
                    }
                }} catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return medico;
    }

    private void setCampoMedico(Medico medico, String campo, String valor) throws Exception {
        switch (campo) {
            case "nome":
                medico.setNome(valor);
                break;
            case "CRM":
                medico.setCrm(valor);
                break;
            case "CTPS":
                medico.setCtps(valor);
                break;
            case "CPF":
                medico.setCpf(valor);
                break;
            case "especialidade":
                medico.setEspecialidade(valor);
                break;
            case "telefone":
                medico.setTelefone(valor);
                break;
            case "endereco":
                medico.setEndereco(valor);
                break;
            case "senha":
                medico.setSenha(valor);
                break;
        }
    }
    

    private boolean validarCrm(String crm) {
        for (Medico medico : medicos) {
            if (medico.getCrm().equals(crm)) {
                return false;
            }
        }
        return true;
    }

    private boolean validarCtps(String ctps) {
        for (Medico medico : medicos) {
            if (medico.getCtps().equals(ctps)) {
                return false;
            }
        }
        return true;
    }

    private boolean validarCpf(String cpf) {
        for (Medico medico : medicos) {
            if (medico.getCpf().equals(cpf)) {
                return false;
            }
        }
        return true;
    }
    
     
   public Medico validarMedico(String crm, String senha){
        for(Medico medico: medicos){
            if(medico.getCrm().equals(crm) && medico.getSenha().equals(senha)){
                return medico;
            }
        }
        return null;
   }
}

