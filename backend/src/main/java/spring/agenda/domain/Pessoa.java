package spring.agenda.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PESSOAS")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PES_ID")
    private Long idPessoa;

    @Column(name = "PES_NOME")
    private String nomePessoa;

    @Column(name = "PES_DATA_NASCIMENTO")
    private LocalDateTime dataNascimento;

    @OneToMany(mappedBy = "pessoa")
    private List<Endereco> endereco;

}
