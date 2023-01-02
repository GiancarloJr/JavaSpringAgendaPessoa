package spring.agenda.domain;

import javax.persistence.*;

@Entity
@Table(name = "ENDERECOS")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "END_ID")
    private Long idEndereco;

    @Column(name = "END_LOGRADOURO")
    private String logradouro;

    @Column(name = "END_CEP")
    private String cep;

    @Column(name = "END_NUMERO")
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pes_id", nullable = false)
    private Pessoa pessoa;

}
