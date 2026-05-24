package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

/**
 *
 * @author anriu
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class CursoController implements CursoIController {

    // Service responsável pelas regras de negócio
    private final CursoIService cursoService;

    @Override
    public Curso save(Curso curso) {

        // Log de solicitação de cadastro
        log.info("Controller recebeu solicitação para salvar curso");

        // Salva um novo curso
        return cursoService.save(curso);
    }

    @Override
    public Curso update(Curso curso) {

        // Log de solicitação de atualização
        log.info("Controller recebeu solicitação para atualizar curso ID {}",
                curso.getId());

        // Atualiza os dados do curso
        return cursoService.update(curso);
    }

    @Override
    public void delete(Curso curso) {

        // Log de solicitação de remoção
        log.info("Controller recebeu solicitação para remover curso ID {}",
                curso.getId());

        // Remove um curso
        cursoService.delete(curso);
    }

    @Override
    public List<Curso> findAll() {

        // Log de solicitação de listagem
        log.info("Controller recebeu solicitação para listar cursos");

        // Retorna todos os cursos cadastrados
        return cursoService.findAll();
    }

    @Override
    public Curso findById(Long id) {

        // Log de solicitação de busca
        log.info("Controller recebeu solicitação para buscar curso ID {}",
                id);

        // Busca um curso pelo ID
        return cursoService.findById(id);
    }
}