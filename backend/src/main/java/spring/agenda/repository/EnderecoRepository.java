package spring.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.agenda.domain.Endereco;
import spring.agenda.domain.Pessoa;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> deleteAllByPessoa(Pessoa pessoa);
}
