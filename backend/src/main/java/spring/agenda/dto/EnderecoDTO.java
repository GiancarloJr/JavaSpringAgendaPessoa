package spring.agenda.dto;

import spring.agenda.domain.Endereco;
import spring.agenda.domain.Pessoa;

import javax.persistence.*;
import java.util.Objects;

public class EnderecoDTO {

    private Long idEndereco;

    private String logradouro;

    private String cep;

    private Integer numero;

    private Pessoa pessoa;

    public EnderecoDTO(){

    }

    public EnderecoDTO(Long idEndereco, String logradouro, String cep, Integer numero, Pessoa pessoa) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.pessoa = pessoa;
    }

    public EnderecoDTO(Endereco entity) {
        this.idEndereco = entity.getIdEndereco();
        this.logradouro = entity.getLogradouro();
        this.cep = entity.getCep();
        this.numero = entity.getNumero();
        this.pessoa = entity.getPessoa();
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoDTO that = (EnderecoDTO) o;
        return idEndereco.equals(that.idEndereco) && Objects.equals(logradouro, that.logradouro) && Objects.equals(cep, that.cep) && Objects.equals(numero, that.numero) && Objects.equals(pessoa, that.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEndereco, logradouro, cep, numero, pessoa);
    }
}
