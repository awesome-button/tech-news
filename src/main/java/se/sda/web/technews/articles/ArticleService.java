package se.sda.web.technews.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    ArticleRepo repository;

    public List<Article> getAll() {
        return repository.findAll();
    }

    public List<Article> getAllByTopicId(Long topicId) {
        return repository.findAllByTopics_id(topicId);
    }

    public Optional<Article> getById(Long id) {
        return repository.findById(id);
    }

    public Article create(Article article) {
        return repository.save(article);
    }

    public Article update(Article article) {
        return repository.save(article);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void reactToArticle(Long id, String reaction) {
        Optional<Article> dbArticle = getById(id);

        if (dbArticle.isPresent()) {
            Article article = dbArticle.get();

            if (reaction.equals("like")) {
                Long likes = article.getLikes() == null ? 1 : article.getLikes() + 1;
                article.setLikes(likes);
            } else if (reaction.equals("dislike")) {
                Long dislikes = article.getDislikes() == null ? 1 : article.getDislikes() + 1;
                article.setDislikes(dislikes);
            }

            update(article);
        }
    }
}
