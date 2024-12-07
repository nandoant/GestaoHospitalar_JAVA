package gestaohospitalar.model;

public class Paciente extends Pessoa{
    private PacienteStatus statusAtual;
    private String numeroConvenio;
    private String nomeConvenio;

    public Paciente(PacienteStatus statusAtual, String numeroConvenio, String nomeConvenio, int id, String nome, String identidade, String cpf, String endereco, String telefone) {
        super(id, nome, identidade, cpf, endereco, telefone);
        this.statusAtual = statusAtual;
        this.numeroConvenio = numeroConvenio;
        this.nomeConvenio = nomeConvenio;
    }

    public PacienteStatus getStatusAtual() {
        return statusAtual;
    }

    public void setStatusAtual(PacienteStatus statusAtual) {
        this.statusAtual = statusAtual;
    }

    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }
    
    @Override
    public void exibir(){
        super.exibir();
        System.out.println("\t Status: " + statusAtual);
        System.out.println("\t Numero Convenio: " + numeroConvenio);
        System.out.println("\t Nome Convenio: " + nomeConvenio);
        System.out.println(" ");
    }  
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nId: " + getId());
        sb.append("\nPaciente: " + getNome());
        sb.append("\nIdentidade: " + getIdentidade());
        sb.append("\nCPF: " + getCpf());
        sb.append("\nEndereco: " + getEndereco());
        sb.append("\nTelefone: " + getTelefone());
        sb.append("\nNome do Convenio: " + getNomeConvenio());
        sb.append("\nNumero do Convenio: " + getNumeroConvenio());
        sb.append("\nStatus do Paciente: " + getStatusAtual());
        return sb.toString();
    }
    
}
