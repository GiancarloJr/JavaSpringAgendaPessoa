package spring.agenda;

import spring.agenda.domain.Endereco;
import spring.agenda.domain.Pessoa;
import spring.agenda.dto.EnderecoDTO;
import spring.agenda.dto.PessoaDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class EntitiesForTests {

    public static Pessoa createPessoa(){
        Pessoa pessoa = new Pessoa(1L,"Giancarlo",LocalDate.parse("03/12/1992", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        pessoa.getEndereco().add(new Endereco(1L,"Casa",12345,1,"Palmas",true,pessoa));
        return pessoa;
    }

    public static PessoaDTO createPessoaDTO(){
        List<EnderecoDTO> enderecoList = new ArrayList<>();
        enderecoList.add(createEnderecoDTO());
        return new PessoaDTO(createPessoa());
    }

    public static Endereco createEndereco(){
        Endereco endereco = new Endereco(1L,"Casa",12345,1,"Palmas",true);
        return endereco;
    }

    public static EnderecoDTO createEnderecoDTO(){
        return new EnderecoDTO(createEndereco(),1L);
    }
}
