package spring.agenda.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.agenda.EntitiesForTests;
import spring.agenda.domain.Endereco;
import spring.agenda.domain.Pessoa;
import spring.agenda.dto.PessoaDTO;
import spring.agenda.repository.EnderecoRepository;
import spring.agenda.repository.PessoaRepository;
import spring.agenda.resource.exceptions.ObjectNotFoundException;
import spring.agenda.service.PessoaService;
import spring.agenda.service.exceptions.DataBaseException;
import spring.agenda.service.exceptions.ResourceNotFoundException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class PessoaServiceTests {

    @InjectMocks
    private PessoaService service;

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private EnderecoRepository enderecoRepository;

    private long existingId;
    private long noExistingId;
    private long dependentId;
    private Pessoa pessoa;
    private Endereco endereco;
    private PessoaDTO pessoaDTO;


    @BeforeEach
    void setUp() throws Exception{
        existingId = 1L;
        noExistingId = 1000L;
        dependentId = 4L;
        pessoa = EntitiesForTests.createPessoa();
        endereco = EntitiesForTests.createEndereco();
        pessoaDTO = EntitiesForTests.createPessoaDTO();

        Mockito.when(pessoaRepository.save(any())).thenReturn(pessoa);

        Mockito.when(pessoaRepository.findById(existingId)).thenReturn(Optional.of(pessoa));
        Mockito.when(pessoaRepository.findById(noExistingId)).thenReturn(Optional.empty());

        Mockito.doNothing().when(pessoaRepository).deleteById(existingId);

        Mockito.doThrow(EmptyResultDataAccessException.class).when(pessoaRepository).deleteById(noExistingId);
        Mockito.doThrow(DataIntegrityViolationException.class).when(pessoaRepository).deleteById(dependentId);
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists(){

        Assertions.assertDoesNotThrow(()->{
            service.deletarPessoa(existingId);
        });
        Mockito.verify(pessoaRepository).deleteById(existingId);
    }
    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists(){

        Assertions.assertThrows(ResourceNotFoundException.class,()->{
            service.deletarPessoa(noExistingId);
        });
        Mockito.verify(pessoaRepository).deleteById(noExistingId);
    }
    @Test
    public void deleteShouldThrowDataIntegrityViolationExceptionWhenDependentId(){

        Assertions.assertThrows(DataBaseException.class,()->{
            service.deletarPessoa(dependentId);
        });
        Mockito.verify(pessoaRepository).deleteById(dependentId);
    }
    @Test
    public void findByIdShouldFindByIdWhenReturnDTOIdExists(){

        PessoaDTO pessoaDTO = service.findByID(existingId);

        Assertions.assertEquals(PessoaDTO.class, pessoaDTO.getClass());
        Assertions.assertNotNull(pessoaDTO);
        Assertions.assertEquals(pessoaDTO.getNomePessoa(), "Giancarlo");
        Assertions.assertEquals(pessoaDTO.getId(), existingId);
    }
    @Test
    public void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists(){

        Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            service.findByID(noExistingId);
        });
    }
    @Test
    public void updateShouldUpdateWhenIdExists(){

        PessoaDTO pessoa = service.atualizarPessoa(1L,pessoaDTO);

        Assertions.assertNotNull(pessoa);
        Assertions.assertEquals(pessoa.getClass(), PessoaDTO.class);
    }
    @Test
    public void updateShouldUpdateWhenIdDoesNotExists(){

        Assertions.assertThrows(ObjectNotFoundException.class, () -> {
            service.atualizarPessoa(noExistingId,service.findByID(noExistingId));
        });
    }


}

