package gestaohospitalar.model;

public class Consulta {
    private int id;
    Paciente paciente;
    Medico medico;
    String descricao;
    PacienteStatus statusConsulta;

    public Consulta(int id, Paciente paciente, Medico medico, String descricao) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.descricao = descricao;
        this.statusConsulta = null;
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

    public PacienteStatus getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(PacienteStatus statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    @Override
    public String toString() {
        return  "--------------------------------------------------------\n"+
                "CONSULTA #" + String.format("%03d", getId()) +
                "\n--------------------------------------------------------\n" +
                "STATUS: " + (statusConsulta != null ? statusConsulta : "Consulta nao iniciada") + "\n" +
                "PACIENTE:\n" +
                "\t- ID: " + paciente.getId() + "\n" +
                "\t- Nome: " + paciente.getNome() + "\n" +
                "\t- CPF: " + paciente.getCpf() + "\n" +
                "\t- Convenio: " + paciente.getNomeConvenio() + "\n" +
                "\t- Numero Convenio: " + paciente.getNumeroConvenio() + "\n" +
                "\n\n"+
                "MEDICO:\n" +
                "\t- ID: " + medico.getId() + "\n" +
                "\t- Nome: " + medico.getNome() + "\n" +
                "\t- Especialidade: " + medico.getEspecialidade() + "\n"+
                "\t- CRM: " + medico.getCrm() + "\n" + 
                "\nDESCRICAO:\n" +
                "\t- " + descricao + "\n";
    }
    
    
    
}
