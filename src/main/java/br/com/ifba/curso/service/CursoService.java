package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author anriu
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CursoService implements CursoIService {

    // Repository responsável pelo acesso ao banco
    private final CursoRepository cursoRepository;

    @Override
    public Curso save(Curso curso) {

        // Log de cadastro de curso
        log.info("Salvando novo curso: {}", curso.getNome());

        // Salva um novo curso
        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Curso curso) {

        // Log de atualização de curso
        log.info("Atualizando curso ID {} - Nome: {}",
                curso.getId(),
                curso.getNome());

        // Atualiza os dados do curso
        return cursoRepository.save(curso);
    }

    @Override
    public void delete(Curso curso) {

        // Log de remoção de curso
        log.info("Removendo curso ID {} - Nome: {}",
                curso.getId(),
                curso.getNome());

        // Remove um curso
        cursoRepository.delete(curso);
    }

    @Override
    public List<Curso> findAll() {

        // Log de listagem de cursos
        log.info("Listando todos os cursos cadastrados");

        // Retorna todos os cursos cadastrados
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(Long id) {

        // Log de busca de curso
        log.info("Buscando curso pelo ID: {}", id);

        // Busca um curso pelo ID
        return cursoRepository.findById(id).orElse(null);
    }
}