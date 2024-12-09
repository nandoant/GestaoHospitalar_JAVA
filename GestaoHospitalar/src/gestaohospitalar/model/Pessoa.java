package gestaohospitalar.model;

import java.lang.reflect.Executable;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public Pessoa(int id, String nome, String cpf, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Pessoa(){

    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        validacaoSimples(nome, nome);
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        validacaoSimples(cpf, cpf);
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws Exception {
        validacaoSimples(endereco, endereco);
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        validacaoSimples(telefone, telefone);
        this.telefone = telefone;
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
    
    public void exibir(){
        System.out.println("\n\t Id: " + id);
        System.out.println("\t Nome: " + nome);
        System.out.println("\t CPF: " + cpf);
        System.out.println("\t Endereço: " + endereco);
        System.out.println("\t Telefone: " + telefone);
    }
}
