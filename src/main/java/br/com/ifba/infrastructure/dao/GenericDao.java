package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 *
 * @author anriu
 */
@SuppressWarnings("unchecked")
public class GenericDao<Entity extends PersistenceEntity>
        implements GenericIDao<Entity> {

    // EntityManager gerenciado automaticamente pelo Spring
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    @Transactional
    public Entity save(Entity entity) {

        // Salva a entidade no banco
        entityManager.persist(entity);

        return entity;
    }

    @Override
    @Transactional
    public Entity update(Entity entity) {

        // Atualiza a entidade no banco
        return entityManager.merge(entity);
    }

    @Override
    @Transactional
    public void delete(Entity entity) {

        // Busca a entidade pelo ID
        entity = findById(entity.getId());

        // Remove a entidade do banco
        entityManager.remove(entity);
    }

    @Override
    public List<Entity> findAll() {

        // Retorna todas as entidades do banco
        return entityManager
                .createQuery("from " + getTypeClass().getSimpleName())
                .getResultList();
    }

    @Override
    public Entity findById(Long id) {

        // Busca uma entidade pelo ID
        return (Entity) entityManager.find(getTypeClass(), id);
    }

    protected Class<?> getTypeClass() {

        // Obtém a classe da entidade genérica
        Class<?> clazz = (Class<?>)
                ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];

        return clazz;
    }
}