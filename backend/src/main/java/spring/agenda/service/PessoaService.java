package spring.agenda.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import spring.agenda.domain.Pessoa;
import spring.agenda.dto.PessoaDTO;
import spring.agenda.repository.EnderecoRepository;
import spring.agenda.repository.PessoaRepository;
import spring.agenda.service.exceptions.DataBaseException;
import spring.agenda.resource.exceptions.ObjectNotFoundException;
import spring.agenda.service.exceptions.ResourceNotFoundException;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

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

    public List<PessoaDTO> buscarPessoasComMostrarContatos() {
        List<Pessoa> list = pessoaRepository.findAll();
        return list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
    }

    public PessoaDTO salvarPessoa(PessoaDTO pessoaDTO) {
        try {
            Pessoa entity = new Pessoa();
            convertDTOtoEntity(entity, pessoaDTO);
            return new PessoaDTO(pessoaRepository.save(entity));
        } catch (DateTimeParseException e){
            throw new DataBaseException("FORMATO DE DATA INCORRETO. CORRETO \"10/10/2023\"");
        }
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
            pessoaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("PESSOA NÃO ENCONTRADA");
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("EXISTEM CONTATOS VINCULADOS A PESSOA, EXCLUIR CONTATOS PRIMEIRO");
        }
    }

    @Transactional
    public void deletarPessoaEContatosDireto(Long id) {
        try {
            enderecoRepository.deleteAllByPessoa(pessoaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PESSOA NAO ENCONTRADA")));
            pessoaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("PESSOA NÃO ENCONTRADA");
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("EXISTEM CONTATOS VINCULADOS A PESSOA, EXCLUIR CONTATOS PRIMEIRO");
        }
    }

    public void convertDTOtoEntity(Pessoa entity, PessoaDTO pessoaDTO) {
        entity.setNomePessoa(pessoaDTO.getNomePessoa());
        entity.setDataNascimento(LocalDate.parse(pessoaDTO.getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
