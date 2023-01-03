package spring.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import spring.agenda.domain.Endereco;
import spring.agenda.domain.Pessoa;
import spring.agenda.dto.EnderecoDTO;
import spring.agenda.repository.EnderecoRepository;
import spring.agenda.repository.PessoaRepository;
import spring.agenda.service.exceptions.DataBaseException;
import spring.agenda.service.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public EnderecoDTO buscarPorId(Long id) {
        try {
            Optional<Endereco> entity = enderecoRepository.findById(id);
            return new EnderecoDTO(entity.get());
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Endereco NAO ENCONTRADO");
        }
    }

    public List<EnderecoDTO> buscarTodos() {
        List<Endereco> list = enderecoRepository.findAll();
        return list.stream().map(x -> new EnderecoDTO(x)).collect(Collectors.toList());
    }

    public EnderecoDTO salvarEndereco(EnderecoDTO enderecoDTO) {
        validacaoPessoa(enderecoDTO);
        try {
            Endereco entity = new Endereco();
            convertDTOtoEntity(entity, enderecoDTO);
            return new EnderecoDTO(enderecoRepository.save(entity));
        } catch (NullPointerException e) {
            throw new ObjectNotFoundException("EMAIL DE USUARIO INEXISTENTE");
        }
    }

    public EnderecoDTO atualizarEndereco(Long id, EnderecoDTO enderecoDTO) {
        validacaoPessoa(enderecoDTO);
        try {
            Optional<Endereco> entity = enderecoRepository.findById(id);
            convertDTOtoEntity(entity.get(), enderecoDTO);
            return new EnderecoDTO(enderecoRepository.save(entity.get()));
        } catch (NullPointerException e) {
            throw new ObjectNotFoundException("Endereco NAO ENCONTRADO");
        }
    }

    public void convertDTOtoEntity(Endereco entity, EnderecoDTO enderecoDTO) {
        entity.setCep(enderecoDTO.getCep());
        entity.setPessoa(pessoaRepository.findById(enderecoDTO.getPessoaID()).get());
        entity.setLogradouro(enderecoDTO.getLogradouro());
        entity.setNumero(enderecoDTO.getNumero());
    }

    public void deletarEndereco(Long id) {
        try {
            enderecoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ObjectNotFoundException("Endereco NAO ENCONTRADO");
        }
    }

    public void validacaoPessoa(EnderecoDTO enderecoDTO){
        Pessoa pessoa = pessoaRepository.findById(enderecoDTO.getPessoaID()).orElseThrow(()-> new DataBaseException("EMAIL NÃO CADASTRADO"));
    }
}
