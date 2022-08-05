package Author;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public void save(Author author) {
        entityManager.persist(author);
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }

    public List<Author> findAll() {
        return entityManager.createQuery("SELECT a FROM Author a").getResultList();
    }

    public List<String> getAuthorNames() {
        return entityManager.createQuery("SELECT a.firstName FROM Author a").getResultList();
    }
}
