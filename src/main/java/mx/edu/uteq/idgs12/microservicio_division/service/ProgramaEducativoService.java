package mx.edu.uteq.idgs12.microservicio_division.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mx.edu.uteq.idgs12.microservicio_division.dto.ProgramaEducativoDTO;
import mx.edu.uteq.idgs12.microservicio_division.entity.ProgramaEducativo;
import mx.edu.uteq.idgs12.microservicio_division.repository.ProgramaEducativoRepository;

@Service
public class ProgramaEducativoService {

    private final ProgramaEducativoRepository programaEducativoRepository;

    public ProgramaEducativoService(ProgramaEducativoRepository programaEducativoRepository) {
        this.programaEducativoRepository = programaEducativoRepository;
    }

    public List<ProgramaEducativo> getAll() {
        return programaEducativoRepository.findAll();
    }

    public Optional<ProgramaEducativo> getById(Long id) {
        return programaEducativoRepository.findById(id);
    }

    public ProgramaEducativo save(ProgramaEducativoDTO dto) {
        ProgramaEducativo programa = new ProgramaEducativo();

        if (dto.getId() != null) {
            programa.setId(dto.getId());
        }

        programa.setPrograma(dto.getPrograma());
        programa.setActivo(dto.isActivo());

        return programaEducativoRepository.save(programa);
    }

    public void delete(Long id) {
        programaEducativoRepository.deleteById(id);
    }
}
