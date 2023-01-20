package spring.agenda.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring.agenda.dto.EnderecoVIACEP;

@FeignClient(name = "APICEP", url = "https://viacep.com.br/ws/")
public interface APICep {

    @GetMapping("{cep}/json")
    EnderecoVIACEP buscaEnderecoPorCEP(@PathVariable("cep") String cep);
}
