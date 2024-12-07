package gestaohospitalar.model;

public class Medico extends Pessoa{
    private String especialidade;
    private String ctps;
    private String crm;
    private String senha;

    public Medico(int id, String especialidade, String ctps, String crm, String senha, String nome, String cpf, String endereco, String telefone) {
        super(id, nome, cpf, endereco, telefone);
        this.especialidade = especialidade;
        this.ctps = ctps;
        this.crm = crm;
        this.senha = senha;
    }
    

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nId: " + getId());
        sb.append("\nMedico: " + getNome());
        sb.append("\nEspecialidade: " + getEspecialidade());
        sb.append("\nCTPS: " + getCtps());
        sb.append("\nCRM: " + getCrm());
        sb.append("\nCPF: " + getCpf());
        sb.append("\nEndereco: " + getEndereco());
        sb.append("\nTelefone: " + getTelefone());
        sb.append("\nSenha: " + getSenha());    
        return sb.toString();
    }
}
