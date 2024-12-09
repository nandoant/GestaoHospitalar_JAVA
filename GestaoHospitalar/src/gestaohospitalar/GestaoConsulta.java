package gestaohospitalar;

import gestaohospitalar.Utils.Console;
import gestaohospitalar.model.Consulta;
import gestaohospitalar.model.Medico;
import gestaohospitalar.model.Paciente;
import gestaohospitalar.model.PacienteStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoConsulta {
    private List<Consulta> consultas;
    private int contador = 1;
    private Scanner scanner;
    private GestaoMedico gestaoMedico;
    private GestaoPaciente gestaoPaciente;

    public GestaoConsulta(GestaoMedico gestaoMedico, GestaoPaciente gestaoPaciente) {
        this.consultas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.gestaoMedico = gestaoMedico;
        this.gestaoPaciente = gestaoPaciente;
        //adcionar uma consulta para teste
        Medico medico = new Medico(0, "Cardiologista", "123456", "123456", "123456", "Joao", "123456", "Rua 1", "123456");
        Paciente paciente = new Paciente(PacienteStatus.ENTRADA, "123456", "Unimed", 0, "Maria", "123456", "Rua 1", "123456");
        Consulta consulta = new Consulta(0, paciente, medico, "Consulta de rotina");
        consultas.add(consulta);
    }

    public void cadastrarConsulta() {
        Console.clear();
        System.out.println("=== Cadastro de Consulta ===");
        Consulta consulta = registrarConsulta();

        if (consulta != null) {
            consulta.setId(contador++);
            this.consultas.add(consulta);

            Console.clear();
            System.out.println("=== Cadastro de Consulta ===");
            System.out.println(consulta);
            System.out.println("Consulta cadastrada com sucesso");
            System.out.println("Pressione qualquer tecla para continuar...");
            scanner.nextLine();
        }
    }

    public void listarConsultas() {
        Console.clear();  
        System.out.println("=== Lista de Consultas ===");
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta cadastrada.");
        } else {
            for (Consulta consulta : consultas) {
                System.out.println("--------------------------------------------------------");
                System.out.println("CONSULTA #" + String.format("%03d", consulta.getId()));
                System.out.println("--------------------------------------------------------");
                System.out.println(consulta.toString());
            }
        }
        System.out.println("\nPressione qualquer tecla para continuar...");
        scanner.nextLine();
    }

    public void atualizarConsulta() {
        Console.clear();
        System.out.println("=== Atualizar Consulta ===");
        System.out.print("Digite o ID da consulta que deseja atualizar: ");
        int id = Console.lerInteiro();
        Consulta consulta = buscarConsulta(id);
        
        if (consulta != null) {
            System.out.println(consulta);
            try{
            modificarConsulta(consulta);

            Console.clear();
            System.out.println("=== Atualizar Consulta ===");
            System.out.println(consulta);

            System.out.println("Consulta atualizada com sucesso");
            System.out.println("Pressione qualquer tecla para continuar...");
            scanner.nextLine();
            }catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("Pressione qualquer tecla para continuar...");
                scanner.nextLine();
            }
        } else {
            System.out.println("Consulta nao encontrada");
            System.out.println("Pressione qualquer tecla para continuar...");
            scanner.nextLine();
        }
    }

    public void deletarConsulta() {
        System.out.println("=== Deletar Consulta ===");
        System.out.print("Digite o ID da consulta que deseja deletar: ");
        int id = Console.lerInteiro();
        Consulta consulta = buscarConsulta(id);
        if (consulta != null) {
            consultas.remove(consulta);
            System.out.println("Consulta deletada com sucesso");
        } else {
            System.out.println("Consulta nao encontrada");
        }
        System.out.println("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
    }

    private Consulta buscarConsulta(int consultaID) {
        for (Consulta consulta : consultas) {
            if (consulta.getId() == consultaID) {
                return consulta;
            }
        }
        return null;
    }

    private void modificarConsulta(Consulta consulta) throws Exception {
        System.out.print("Digite a nova descricao da consulta (ou pressione Enter para manter a mesma): ");
        String descricao = scanner.nextLine();
        if (!descricao.isEmpty()) {
            consulta.setDescricao(descricao);
        }

        System.out.print("Deseja alterar o medico? (s/n): ");
        String alterarMedico = scanner.nextLine();
        if (alterarMedico.equalsIgnoreCase("s")) {
            Medico medico = selecionarMedico();
            if (medico != null) {
                //gestaoMedico.buscarMedico(contador)
                consulta.setMedico(medico);
            } else {
                throw new Exception("\nMedico nao encontrado. O medico da consulta nao foi alterado.\n");
            }
        }

        System.out.print("Deseja alterar o paciente? (s/n): ");
        String alterarPaciente = scanner.nextLine();
        if (alterarPaciente.equalsIgnoreCase("s")) {
            Paciente paciente = selecionarPaciente();
            if (paciente != null) {
                consulta.setPaciente(paciente);
            }
        } else {
            throw new Exception("\nPaciente nao encontrado. O paciente da consulta nao foi alterado.\n");
        }
    }

    private Consulta registrarConsulta() {
        System.out.print("Digite a descricao da consulta: ");
        String descricao = scanner.nextLine();

        Medico medico = selecionarMedico();
        if (medico == null) {
            System.out.println("Medico nao encontrado. Cadastro de consulta cancelado.");
            System.out.println("Pressione qualquer tecla para continuar...");
            scanner.nextLine();
            return null;
        }

        Paciente paciente = selecionarPaciente();
        if (paciente == null) {
            System.out.println("Paciente nao encontrado. Cadastro de consulta cancelado.");
            System.out.println("Pressione qualquer tecla para continuar...");
            scanner.nextLine();
            return null;
        }

        return new Consulta(0, paciente, medico, descricao);
    }

    private Medico selecionarMedico() {
        gestaoMedico.exibirMedicos();
        System.out.print("Digite o ID do medico: ");
        int medicoId = Console.lerInteiro();
        return gestaoMedico.buscarMedico(medicoId);
    }

    private Paciente selecionarPaciente() {
        gestaoPaciente.listarPacientes();
        System.out.print("Digite o ID do paciente: ");
        int pacienteId = Console.lerInteiro();
        return gestaoPaciente.buscarPaciente(pacienteId);
    }

    public void buscarConsultaPorId() {
        Console.clear();
        System.out.println("=== Buscar Consulta por ID ===");
        System.out.print("Digite o ID da consulta: ");
        int id = Console.lerInteiro();
        
        Consulta consulta = buscarConsulta(id);
        if (consulta != null) {
            System.out.println("--------------------------------------------------------");
            System.out.println("CONSULTA #" + String.format("%03d", consulta.getId()));
            System.out.println("--------------------------------------------------------");
            System.out.println(consulta.toString());
        } else {
            System.out.println("Consulta não encontrada.");
        }
        
        System.out.println("\nPressione qualquer tecla para continuar...");
        scanner.nextLine();
    }
}