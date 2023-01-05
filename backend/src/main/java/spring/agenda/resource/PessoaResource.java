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
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(pessoaService.findByID(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PessoaDTO>> findAllWithoutContats() {
        return ResponseEntity.ok().body(pessoaService.buscarPessoasSemMostrarContatos());
    }

    @GetMapping("/allcomplet")
    public ResponseEntity<List<PessoaDTO>> findAllWithContats() {
        return ResponseEntity.ok().body(pessoaService.buscarPessoasComMostrarContatos());
    }


    @PostMapping("/")
    public ResponseEntity<PessoaDTO> savePessoa(@Valid @RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok().body(pessoaService.salvarPessoa(pessoaDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PessoaDTO> updatePessoa(@PathVariable Long id, @Valid @RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok().body(pessoaService.atualizarPessoa(id, pessoaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable("id") Long id) {
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/deletewithcontats/{id}")
    public ResponseEntity<Void> deletarPessoaComContatos(@PathVariable("id") Long id) {
        pessoaService.deletarPessoaEContatosDireto(id);
        return ResponseEntity.noContent().build();
    }
}
