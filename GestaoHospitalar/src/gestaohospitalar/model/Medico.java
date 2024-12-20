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

    public Medico() {
    }
    
    

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) throws Exception {
        validacaoSimples(especialidade, "Especialidade");

        this.especialidade = especialidade;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) throws Exception {
        validacaoSimples(ctps, "CTPS");
        this.ctps = ctps;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) throws Exception {
        validacaoSimples(crm, "CRM");
        this.crm = crm;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws Exception {
        validacaoSimples(senha, "Senha");
        this.senha = senha;
    }
    
    private void validacaoSimples(String valor, String campo) throws Exception{
        valor = valor.trim();
        if(valor.isEmpty()){
            throw new Exception(campo + " nao pode ser vazio");
        }
        if(valor.length() < 3){
            throw new Exception(campo + " deve ter no minimo 3 caracteres");
        }
    }

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
                + "Endereco: " + getEndereco() + "\n"
                + "-----------------------------\n"
                + "Senha: " + senha + "\n"
                + "-----------------------------\n";
    }

}
