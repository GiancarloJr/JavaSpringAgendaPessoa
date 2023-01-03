package spring.agenda.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import spring.agenda.domain.Endereco;
import spring.agenda.domain.Pessoa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class PessoaDTO {

    private Long idPessoa;

    private String nomePessoa;

    private LocalDateTime dataNascimento;

    @JsonIgnore
    private List<Endereco> endereco;

    public PessoaDTO(){

    }

    public PessoaDTO(Long idPessoa, String nomePessoa, LocalDateTime dataNascimento, List<Endereco> endereco) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public PessoaDTO(Pessoa entity) {
        this.idPessoa = entity.getIdPessoa();
        this.nomePessoa = entity.getNomePessoa();
        this.dataNascimento = entity.getDataNascimento();
        this.endereco = entity.getEndereco();
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
        PessoaDTO pessoaDTO = (PessoaDTO) o;
        return idPessoa.equals(pessoaDTO.idPessoa) && Objects.equals(nomePessoa, pessoaDTO.nomePessoa) && Objects.equals(dataNascimento, pessoaDTO.dataNascimento) && Objects.equals(endereco, pessoaDTO.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, nomePessoa, dataNascimento, endereco);
    }
}
