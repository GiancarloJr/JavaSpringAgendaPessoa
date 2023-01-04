package spring.agenda.dto;

import spring.agenda.domain.Endereco;


public class EnderecoDTO {

    private Long id;

    private String logradouro;

    private String cep;

    private Integer numero;

    private Long pessoaID;

    public EnderecoDTO(){

    }

    public EnderecoDTO(Long id, String logradouro, String cep, Integer numero, Long pessoaID) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.pessoaID = pessoaID;
    }

    public EnderecoDTO(Endereco entity) {
        this.id = entity.getIdEndereco();
        this.logradouro = entity.getLogradouro();
        this.cep = entity.getCep();
        this.numero = entity.getNumero();
        this.pessoaID = entity.getPessoa().getIdPessoa();
    }

    public EnderecoDTO(Endereco entity,Long pessoaID) {
        this.id = entity.getIdEndereco();
        this.logradouro = entity.getLogradouro();
        this.cep = entity.getCep();
        this.numero = entity.getNumero();
        this.pessoaID = pessoaID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Long getPessoaID() {
        return pessoaID;
    }

    public void setPessoaID(Long pessoaID) {
        this.pessoaID = pessoaID;
    }
}
