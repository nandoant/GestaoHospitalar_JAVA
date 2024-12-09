package gestaohospitalar.model;

public class Medico extends Pessoa{
    private String especialidade;
    private String ctps;
    private String crm;
    private String senha;

    public Medico(int id, String especialidade, String crm, String ctps, String senha, String nome, String cpf, String endereco, String telefone) {
        super(id, nome, cpf, endereco, telefone );
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
    
    //Fazer um toString que exiba nesse formato abaixo, porem mostrando todos os dados dele:
    /*
    ============================
    MEDICO #001 
    ============================
    Nome: Fernando      
    -----------------------------
    Especialidade: Cardiologista          
    -----------------------------
     */
    @Override
    public String toString() {
        return "=============================\n"
                + "MEDICO #" + String.format("%03d", getId()) + "\n"
                + "=============================\n"
                + "Nome: " + getNome() + "\n"
                + "-----------------------------\n"
                + "Especialidade: " + especialidade + "\n"
                + "-----------------------------\n"
                + "CRM: " + crm + "\n"
                + "-----------------------------\n"
                + "CTPS: " + ctps + "\n"
                + "-----------------------------\n"
                + "CPF: " + getCpf() + "\n"
                + "-----------------------------\n"
                + "Telefone: " + getTelefone() + "\n"
                + "-----------------------------\n"
                + "Endereço: " + getEndereco() + "\n"
                + "-----------------------------\n"
                + "Senha: " + senha + "\n"
                + "-----------------------------\n";

    }

}
