package br.com.ifba.turma.entity;

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
public class Turma extends PersistenceEntity implements Serializable {

    // Nome da turma
    @Column(name = "nome", nullable = false)
    private String nome;

}