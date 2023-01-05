package spring.agenda.dto;

import spring.agenda.domain.Endereco;

import javax.persistence.Column;


public class EnderecoDTO {

    private Long id;

    private String logradouro;

    private Integer cep;

    private Integer numero;

    private String cidade;

    private Boolean enderecoPrincipal;

    private Long pessoaID;

    public EnderecoDTO(){

    }

    public EnderecoDTO(Long id, String logradouro, Integer cep, Integer numero,String cidade,Boolean enderecoPrincipal, Long pessoaID) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.enderecoPrincipal = enderecoPrincipal;
        this.pessoaID = pessoaID;
    }

    public EnderecoDTO(Endereco entity) {
        this.id = entity.getIdEndereco();
        this.logradouro = entity.getLogradouro();
        this.cep = entity.getCep();
        this.numero = entity.getNumero();
        this.cidade = entity.getCidade();
        this.enderecoPrincipal = entity.getEnderecoPrincipal();
        this.pessoaID = entity.getPessoa().getIdPessoa();
    }

    public EnderecoDTO(Endereco entity,Long pessoaID) {
        this.id = entity.getIdEndereco();
        this.logradouro = entity.getLogradouro();
        this.cep = entity.getCep();
        this.numero = entity.getNumero();
        this.cidade = entity.getCidade();
        this.enderecoPrincipal = entity.getEnderecoPrincipal();
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

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Boolean getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(Boolean enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }
}
