package spring.agenda.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ENDERECOS")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "END_ID")
    private Long idEndereco;

    @Column(name = "END_LOGRADOURO")
    private String logradouro;

    @Column(name = "END_CEP")
    private Integer cep;

    @Column(name = "END_NUMERO")
    private Integer numero;

    @Column(name = "END_CIDADE")
    private String cidade;

    @Column(name = "END_PRINCIPAL")
    private Boolean enderecoPrincipal;

    @ManyToOne
    @JoinColumn(name = "PESSOA_ID", referencedColumnName = "PES_ID")
    private Pessoa pessoa;

    public Endereco(){

    }

    public Endereco(Long idEndereco, String logradouro, Integer cep, Integer numero,String cidade,Boolean enderecoPrincipal, Pessoa pessoa) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.enderecoPrincipal = enderecoPrincipal;
        this.pessoa = pessoa;
    }

    public Endereco(Long idEndereco, String logradouro, Integer cep, Integer numero,String cidade,Boolean enderecoPrincipal) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.enderecoPrincipal = enderecoPrincipal;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Boolean getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(Boolean enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(idEndereco, endereco.idEndereco) && Objects.equals(logradouro, endereco.logradouro) && Objects.equals(cep, endereco.cep) && Objects.equals(numero, endereco.numero) && Objects.equals(cidade, endereco.cidade) && Objects.equals(pessoa, endereco.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEndereco, logradouro, cep, numero, cidade, pessoa);
    }
}
