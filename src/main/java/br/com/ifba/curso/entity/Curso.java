package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author anriu
 */
@Getter
@Setter
@Entity
public class Curso extends PersistenceEntity implements Serializable {

    // Nome do curso
    @Column(name = "nome", nullable = false)
    private String nome;

    // Código identificador do curso
    @Column(name = "codigo_curso", nullable = false)
    private String codigoCurso;

    // Define se o curso está ativo
    @Column(name = "ativo")
    private boolean ativo;
}