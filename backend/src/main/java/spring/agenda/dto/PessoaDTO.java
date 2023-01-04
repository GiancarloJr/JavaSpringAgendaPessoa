package spring.agenda.dto;

import spring.agenda.domain.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaDTO {

    private Long id;

    private String nomePessoa;

    private String dataNascimento;

    private List<EnderecoDTO> enderecos = new ArrayList<>();

    public PessoaDTO(){

    }

    public PessoaDTO(Long id, String nomePessoa, String dataNascimento, List<EnderecoDTO> enderecos) {
        this.id = id;
        this.nomePessoa = nomePessoa;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos;
    }

    public PessoaDTO(Pessoa entity) {
        this.id = entity.getIdPessoa();
        this.nomePessoa = entity.getNomePessoa();
        this.dataNascimento = entity.getDataNascimentoFormatada();
        this.enderecos = entity.getEndereco().stream().map(x -> new EnderecoDTO(x)).collect(Collectors.toList());
    }

    public PessoaDTO(Pessoa entity, List<EnderecoDTO> enderecos) {
        this.id = entity.getIdPessoa();
        this.nomePessoa = entity.getNomePessoa();
        this.dataNascimento = entity.getDataNascimentoFormatada();
        this.enderecos = enderecos;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }
}
