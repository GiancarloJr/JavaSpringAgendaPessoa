package spring.agenda.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.agenda.dto.PessoaDTO;
import spring.agenda.service.PessoaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> buscarPessoaPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(pessoaService.findByID(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PessoaDTO>> buscarTodasPessoasSemMostrarContatos() {
        return ResponseEntity.ok().body(pessoaService.buscarPessoasSemMostrarContatos());
    }

    @GetMapping("/allcompleto")
    public ResponseEntity<List<PessoaDTO>> buscarTodasPessoasMostrarContatos() {
        return ResponseEntity.ok().body(pessoaService.buscarPessoasMostrarContatos());
    }


    @PostMapping("/")
    public ResponseEntity<PessoaDTO> adicionarPessoa(@Valid @RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok().body(pessoaService.salvarPessoa(pessoaDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PessoaDTO> atualizarPessoa(@PathVariable Long id, @Valid @RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok().body(pessoaService.atualizarPessoa(id, pessoaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable("id") Long id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
