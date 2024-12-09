package gestaohospitalar;

import gestaohospitalar.model.Medico;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoMedico {
    private List<Medico> medicos;
    private int contador = 1;
    private static GestaoMedico instance;
    private Scanner scanner;

    public GestaoMedico() {
        this.medicos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        //adcionar um medico para teste
        Medico medico = new Medico(0, "Cardiologista", "123456", "123456", "123456", "Joao", "123456", "Rua 1", "123456");
        medicos.add(medico);
    }
    
  

    public void cadastrarMedico() {
        System.out.println("=== Cadastro de Medico ===");
        Medico medico = registrarMedico();
        if (medico != null) {
            medico.setId(contador++);
            this.medicos.add(medico);
            System.out.println("Medico cadastrado com sucesso");
        }
    }

    public void listarMedicos() {
        System.out.println("=== Lista de Medicos ===");
        if (medicos.isEmpty()) {
            System.out.println("Nenhum medico cadastrado.");
        } else {
            for (Medico medico : medicos) {
                System.out.println(medico);
                System.out.println("-----------------------------");
            }
        }
    }

    public void atualizarMedico() {
        System.out.println("=== Atualizar Medico ===");
        System.out.print("Digite o ID do medico que deseja atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Medico medico = buscarMedico(id);
        if (medico != null) {
            modificarMedico(medico);
            System.out.println("Medico atualizado com sucesso");
        } else {
            System.out.println("Medico nao encontrado");
        }
    }

    public void deletarMedico() {
        System.out.println("=== Deletar Medico ===");
        System.out.print("Digite o ID do medico que deseja deletar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Medico medico = buscarMedico(id);
        if (medico != null) {
            medicos.remove(medico);
            System.out.println("Medico deletado com sucesso");
        } else {
            System.out.println("Medico nao encontrado");
        }
    }

    public Medico buscarMedico(int medicoID) {
        for (Medico medico : medicos) {
            if (medico.getId() == medicoID) {
                return medico;
            }
        }
        return null;
    }

    private void modificarMedico(Medico medico) {
        System.out.print("Digite o novo nome do medico (ou pressione Enter para manter o mesmo): ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) {
            medico.setNome(nome);
        }

        System.out.print("Digite o novo CRM do medico (ou pressione Enter para manter o mesmo): ");
        String crm = scanner.nextLine();
        if (!crm.isEmpty() && validarCrm(crm)) {
            medico.setCrm(crm);
        } else if (!crm.isEmpty()) {
            System.out.println("CRM ja cadastrado");
        }

        System.out.print("Digite o novo CTPS do medico (ou pressione Enter para manter o mesmo): ");
        String ctps = scanner.nextLine();
        if (!ctps.isEmpty() && validarCtps(ctps)) {
            medico.setCtps(ctps);
        } else if (!ctps.isEmpty()) {
            System.out.println("CTPS ja cadastrado");
        }

        System.out.print("Digite o novo CPF do medico (ou pressione Enter para manter o mesmo): ");
        String cpf = scanner.nextLine();
        if (!cpf.isEmpty() && validarCpf(cpf)) {
            medico.setCpf(cpf);
        } else if (!cpf.isEmpty()) {
            System.out.println("CPF ja cadastrado");
        }

        System.out.print("Digite a nova especialidade do medico (ou pressione Enter para manter a mesma): ");
        String especialidade = scanner.nextLine();
        if (!especialidade.isEmpty()) {
            medico.setEspecialidade(especialidade);
        }

        System.out.print("Digite o novo telefone do medico (ou pressione Enter para manter o mesmo): ");
        String telefone = scanner.nextLine();
        if (!telefone.isEmpty()) {
            medico.setTelefone(telefone);
        }

        System.out.print("Digite o novo endereco do medico (ou pressione Enter para manter o mesmo): ");
        String endereco = scanner.nextLine();
        if (!endereco.isEmpty()) {
            medico.setEndereco(endereco);
        }

        System.out.print("Digite a nova senha do medico (ou pressione Enter para manter a mesma): ");
        String senha = scanner.nextLine();
        if (!senha.isEmpty()) {
            medico.setSenha(senha);
        }
    }

    private Medico registrarMedico() {
        System.out.print("Digite o nome do medico: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CRM do medico: ");
        String crm = scanner.nextLine();
        if (!validarCrm(crm)) {
            System.out.println("CRM ja cadastrado");
            return null;
        }

        System.out.print("Digite o CTPS do medico: ");
        String ctps = scanner.nextLine();
        if (!validarCtps(ctps)) {
            System.out.println("CTPS ja cadastrado");
            return null;
        }

        System.out.print("Digite o CPF do medico: ");
        String cpf = scanner.nextLine();
        if (!validarCpf(cpf)) {
            System.out.println("CPF ja cadastrado");
            return null;
        }

        System.out.print("Digite a especialidade do medico: ");
        String especialidade = scanner.nextLine();

        System.out.print("Digite o telefone do medico: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite o endereco do medico: ");
        String endereco = scanner.nextLine();

        System.out.print("Digite a senha do medico: ");
        String senha = scanner.nextLine();

        if (nome.isEmpty() || crm.isEmpty() || ctps.isEmpty() || cpf.isEmpty() || especialidade.isEmpty() || senha.isEmpty() || endereco.isEmpty()) {
            System.out.println("Campos obrigatorios nao preenchidos");
            return null;
        }

        return new Medico(0, especialidade, crm, ctps, senha, nome, cpf, endereco, telefone);
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

