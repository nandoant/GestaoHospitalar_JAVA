package gestaohospitalar.model;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String identidade;
    private String cpf;
    private String endereco;
    private String telefone;

    public Pessoa(int id, String nome, String identidade, String cpf, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.identidade = identidade;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
}
