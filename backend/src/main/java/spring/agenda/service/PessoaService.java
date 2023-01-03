package spring.agenda.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import spring.agenda.domain.Pessoa;
import spring.agenda.dto.PessoaDTO;
import spring.agenda.repository.PessoaRepository;
import spring.agenda.service.exceptions.DataBaseException;
import spring.agenda.service.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTO findByID(Long id) {
        try {
            Optional<Pessoa> entity = pessoaRepository.findById(id);
            return new PessoaDTO(entity.get());
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("PESSOA NÃO ENCONTRADO");
        }
    }

    public List<PessoaDTO> buscarPessoasSemMostrarContatos() {
        List<Pessoa> list = pessoaRepository.findAll();
        for (Pessoa pessoa : list) {
            pessoa.getEndereco().clear();
        }
        return list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
    }

    public List<PessoaDTO> buscarPessoasMostrarContatos() {
        List<Pessoa> list = pessoaRepository.findAll();
        return list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
    }

    public PessoaDTO salvarPessoa(PessoaDTO pessoaDTO) {

        Pessoa entity = new Pessoa();
        convertDTOtoEntity(entity, pessoaDTO);
        return new PessoaDTO(pessoaRepository.save(entity));
    }

    public PessoaDTO atualizarPessoa(Long id, PessoaDTO pessoaDTO) {
        try {
            Optional<Pessoa> entity = pessoaRepository.findById(id);
            convertDTOtoEntity(entity.get(), pessoaDTO);
            return new PessoaDTO(pessoaRepository.save(entity.get()));
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("PESSOA NÃO ENCONTRADO");
        }
    }

    public void deletarPessoa(Long id) {
        try {
            validacaoExclusaoPessoa(id);
            pessoaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ObjectNotFoundException("PESSOA NÃO ENCONTRADO");
        }
    }

    public void convertDTOtoEntity(Pessoa entity, PessoaDTO pessoaDTO) {
        entity.setNomePessoa(pessoaDTO.getNomePessoa());
        entity.setDataNascimento(pessoaDTO.getDataNascimento());
    }

    public void validacaoExclusaoPessoa(Long id) {
        if (!pessoaRepository.findById(id).get().getEndereco().isEmpty()) {
            throw new DataBaseException("PESSOA POSSUI ENDEREÇOS VINCULADOS");
        }
    }
}
