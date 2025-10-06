package mx.edu.uteq.idgs12.microservicio_division.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoDTO;
import mx.edu.uteq.idgs12.microservicio_division.entity.ProgramaEducativo;
import mx.edu.uteq.idgs12.microservicio_division.service.ProgramaEducativoService;

@RestController
@RequestMapping("/api/programas-educativos")
public class ProgramaEducativoController {

    private final ProgramaEducativoService programaEducativoService;

    public ProgramaEducativoController(ProgramaEducativoService programaEducativoService) {
        this.programaEducativoService = programaEducativoService;
    }

    @GetMapping
    public List<ProgramaEducativo> getAll() {
        return programaEducativoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaEducativo> getById(@PathVariable Long id) {
        Optional<ProgramaEducativo> programa = programaEducativoService.getById(id);
        return programa.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProgramaEducativo> create(@RequestBody ProgramaEducativoDTO dto) {
        return ResponseEntity.ok(programaEducativoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaEducativo> update(@PathVariable Long id, @RequestBody ProgramaEducativoDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(programaEducativoService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        programaEducativoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
