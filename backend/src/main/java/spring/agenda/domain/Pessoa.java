package spring.agenda.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PESSOAS")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PES_ID")
    private Long idPessoa;

    @Column(name = "PES_NOME")
    private String nomePessoa;

    @DateTimeFormat(pattern = "01-01-2000")
    @Column(name = "PES_DATA_NASCIMENTO")
    private LocalDateTime dataNascimento;

    @OneToMany(mappedBy = "pessoa")
    private List<Endereco> endereco;

    public Pessoa(){

    }

    public Pessoa(Long idPessoa, String nomePessoa, LocalDateTime dataNascimento, List<Endereco> endereco) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idPessoa.equals(pessoa.idPessoa) && Objects.equals(nomePessoa, pessoa.nomePessoa) && Objects.equals(dataNascimento, pessoa.dataNascimento) && Objects.equals(endereco, pessoa.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, nomePessoa, dataNascimento, endereco);
    }
}
