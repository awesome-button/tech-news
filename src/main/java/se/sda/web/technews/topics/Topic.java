package se.sda.web.technews.topics;

import se.sda.web.technews.articles.Article;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="topics")
public class Topic {

    @Column
    String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToMany(mappedBy = "topics")
    private List<Article> articles;

    public Topic() {}

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
