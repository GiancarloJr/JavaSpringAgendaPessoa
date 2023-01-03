package spring.agenda.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.agenda.dto.EnderecoDTO;
import spring.agenda.service.EnderecoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(enderecoService.buscarPorId(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EnderecoDTO>> buscarTodos() {
        return ResponseEntity.ok().body(enderecoService.buscarTodos());
    }

    @PostMapping("/")
    public ResponseEntity<EnderecoDTO> inserir(@Valid @RequestBody EnderecoDTO enderecoDTO) {
        return ResponseEntity.ok().body(enderecoService.salvarEndereco(enderecoDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EnderecoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody EnderecoDTO enderecoDTO) {
        return ResponseEntity.ok().body(enderecoService.atualizarEndereco(id, enderecoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }

}
