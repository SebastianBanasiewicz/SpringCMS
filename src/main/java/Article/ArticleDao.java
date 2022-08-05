package Article;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Article findById(Long id) {
        return entityManager.find(Article.class, id);
    }

    public void save(Article article) {
        entityManager.persist(article);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public List<Article> findAll() {
        return entityManager.createQuery("SELECT a FROM Article a").getResultList();
    }

    public List<Article> get5LatestArticles() {
        return entityManager.createQuery("SELECT b FROM Article b ORDER BY b.created DESC").setMaxResults(5).getResultList();
    }
   

}
