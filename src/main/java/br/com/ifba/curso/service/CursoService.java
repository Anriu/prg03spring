package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anriu
 */
@Service
public class CursoService implements CursoIService {

    // Injeta automaticamente o Repository responsável pelo acesso ao banco
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso save(Curso curso) {
        // Salva um novo curso
        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
        // Atualiza os dados do curso
        return cursoRepository.save(curso);
    }

    @Override
    public void delete(Curso curso) {
        // Remove um curso
        cursoRepository.delete(curso);
    }

    @Override
    public List<Curso> findAll() {
        // Retorna todos os cursos cadastrados
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(Long id) {
        // Busca um curso pelo ID
        return cursoRepository.findById(id).orElse(null);
    }
}