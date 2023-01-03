package spring.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.agenda.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
