package spring.agenda.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.agenda.dto.EnderecoDTO;
import spring.agenda.service.EnderecoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(enderecoService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EnderecoDTO>> findAll() {
        return ResponseEntity.ok().body(enderecoService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<EnderecoDTO> save(@Valid @RequestBody EnderecoDTO enderecoDTO) {
        return ResponseEntity.ok().body(enderecoService.saveEndereco(enderecoDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable Long id, @Valid @RequestBody EnderecoDTO enderecoDTO) {
        return ResponseEntity.ok().body(enderecoService.updateEndereco(id, enderecoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        enderecoService.deleteEnderecoById(id);
        return ResponseEntity.noContent().build();
    }

}
