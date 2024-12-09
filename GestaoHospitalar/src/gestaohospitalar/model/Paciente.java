package gestaohospitalar.model;

public class Paciente extends Pessoa{
    private PacienteStatus statusAtual;
    private String numeroConvenio;
    private String nomeConvenio;

    public Paciente(PacienteStatus statusAtual, String numeroConvenio, String nomeConvenio, int id, String nome, String cpf, String endereco, String telefone) {
        super(id, nome, cpf, endereco, telefone);
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
        return "=============================\n"
                + "PACIENTE #" + String.format("%03d", getId()) + "\n"
                + "=============================\n"
                + "Nome: " + getNome() + "\n"
                + "-----------------------------\n"
                + "CPF: " + getCpf() + "\n"
                + "-----------------------------\n"
                + "Endereço: " + getEndereco() + "\n"
                + "-----------------------------\n"
                + "Telefone: " + getTelefone() + "\n"
                + "-----------------------------\n"
                + "Status: " + statusAtual + "\n"
                + "-----------------------------\n"
                + "Numero Convenio: " + numeroConvenio + "\n"
                + "-----------------------------\n"
                + "Nome Convenio: " + nomeConvenio + "\n"
                + "-----------------------------\n";
    }

    
}
