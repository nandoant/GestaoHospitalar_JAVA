package gestaohospitalar.model;

public class Consulta {
    private int id;
    Paciente paciente;
    Medico medico;
    String descricao;

    public Consulta(int id, Paciente paciente, Medico medico, String descricao) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PacienteStatus getStatusAtualPaciente() {
        return this.paciente.getStatusAtual();
    }
    
    
    
}
