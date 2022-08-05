package Article;

import Category.Category;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String title;
    @ManyToOne
    private Article author;
    @ManyToMany
    private List<Category> categories;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    public void prePresist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Article:" +
                "title: " + this.title + '\'' +
                ", author: " + this.author +
                ", created: " + this.created;
    }
}
