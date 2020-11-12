package se.sda.web.technews.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.sda.web.technews.comments.Comment;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    TopicRepo repository;

    public List<Topic> getAll() {
        return repository.findAll();
    }

    public List<Topic> getAllByArticleId(Long articleId) {
        return repository.findAllByArticles_id(articleId);
    }

    public Optional<Topic> getById(Long id) {
        return repository.findById(id);
    }

    public Topic create(Topic topic) {
        return repository.save(topic);
    }

    public Topic update(Topic topic) {
        return repository.save(topic);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
