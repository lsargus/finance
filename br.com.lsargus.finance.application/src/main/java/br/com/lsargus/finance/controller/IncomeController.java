package br.com.lsargus.finance.controller;

import br.com.lsargus.finance.data.IncomeBO;
import br.com.lsargus.finance.dto.IncomeDTO;
import br.com.lsargus.finance.exceptions.RuleException;
import br.com.lsargus.finance.mapper.IncomeDTOMapper;
import br.com.lsargus.finance.ports.service.IncomeServicePort;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("receita")
public class IncomeController {

    private IncomeServicePort incomeService;

    private static final IncomeDTOMapper mapper = Mappers.getMapper(IncomeDTOMapper.class);

    public IncomeController(IncomeServicePort incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping
    public ResponseEntity<List<IncomeBO>> listAll() {
        return ResponseEntity.ok(incomeService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<IncomeDTO> getIncome(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDTO(incomeService.getIncome(id)));
    }

    @PostMapping
    public ResponseEntity<Object> addIncome(@Validated @RequestBody IncomeDTO incomeDTO) {
        try {
            return ResponseEntity.ok(mapper.toDTO(incomeService.addIncome(mapper.toBO(incomeDTO))));
        } catch (RuleException ex) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateIncome(@PathVariable Long id, @Validated @RequestBody IncomeDTO incomeDTO) {
        try {
            return ResponseEntity.ok(mapper.toDTO(incomeService.updateIncome(id, mapper.toBO(incomeDTO))));
        } catch (RuleException ex) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteIncome(@PathVariable Long id) {

        incomeService.deleteIncome(id);
        return ResponseEntity.ok("Registro apagado com sucesso.");

    }

}
