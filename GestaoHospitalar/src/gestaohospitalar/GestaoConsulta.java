package gestaohospitalar;

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
        System.out.println("=== Cadastro de Consulta ===");
        Consulta consulta = registrarConsulta();
        if (consulta != null) {
            consulta.setId(contador++);
            this.consultas.add(consulta);
            System.out.println("Consulta cadastrada com sucesso");
        }
    }

    public void listarConsultas() {
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
    }

    public void atualizarConsulta() {
        System.out.println("=== Atualizar Consulta ===");
        System.out.print("Digite o ID da consulta que deseja atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Consulta consulta = buscarConsulta(id);
        if (consulta != null) {
            modificarConsulta(consulta);
            System.out.println("Consulta atualizada com sucesso");
        } else {
            System.out.println("Consulta nao encontrada");
        }
    }

    public void deletarConsulta() {
        System.out.println("=== Deletar Consulta ===");
        System.out.print("Digite o ID da consulta que deseja deletar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Consulta consulta = buscarConsulta(id);
        if (consulta != null) {
            consultas.remove(consulta);
            System.out.println("Consulta deletada com sucesso");
        } else {
            System.out.println("Consulta nao encontrada");
        }
    }

    private Consulta buscarConsulta(int consultaID) {
        for (Consulta consulta : consultas) {
            if (consulta.getId() == consultaID) {
                return consulta;
            }
        }
        return null;
    }

    private void modificarConsulta(Consulta consulta) {
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
                consulta.setMedico(medico);
            }
        }

        System.out.print("Deseja alterar o paciente? (s/n): ");
        String alterarPaciente = scanner.nextLine();
        if (alterarPaciente.equalsIgnoreCase("s")) {
            Paciente paciente = selecionarPaciente();
            if (paciente != null) {
                consulta.setPaciente(paciente);
            }
        }
    }

    private Consulta registrarConsulta() {
        System.out.print("Digite a descricao da consulta: ");
        String descricao = scanner.nextLine();

        Medico medico = selecionarMedico();
        if (medico == null) {
            System.out.println("Medico nao encontrado. Cadastro de consulta cancelado.");
            return null;
        }

        Paciente paciente = selecionarPaciente();
        if (paciente == null) {
            System.out.println("Paciente nao encontrado. Cadastro de consulta cancelado.");
            return null;
        }

        Medico novoMedico = medico;
        Paciente novoPaciente = paciente;

        return new Consulta(0, novoPaciente, novoMedico, descricao);
    }

    private Medico selecionarMedico() {
        gestaoMedico.listarMedicos();
        System.out.print("Digite o ID do medico: ");
        int medicoId = Integer.parseInt(scanner.nextLine());
        return gestaoMedico.buscarMedico(medicoId);
    }

    private Paciente selecionarPaciente() {
        gestaoPaciente.listarPacientes();
        System.out.print("Digite o ID do paciente: ");
        int pacienteId = Integer.parseInt(scanner.nextLine());
        return gestaoPaciente.buscarPaciente(pacienteId);
    }
}