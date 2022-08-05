package Category;

import Author.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public void save(Category category) {
        entityManager.persist(category);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }

    public List<Author> findAll() {
        return entityManager.createQuery("SELECT c FROM Category a").getResultList();
    }

    public List<String> getCategoryNames() {
        return entityManager.createQuery("SELECT c.name FROM Category c").getResultList();
    }
}
