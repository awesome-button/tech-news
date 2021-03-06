package se.sda.web.technews.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.sda.web.technews.comments.Comment;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping("")
    public List<Topic> getAll(@RequestParam(required = false) Long articleId) {
        if (articleId == null) {
            return topicService.getAll();
        } else {
            return topicService.getAllByArticleId(articleId);
        }
    }

    @GetMapping("/{id}")
    public Optional<Topic> getById(@PathVariable Long id) {
        return topicService.getById(id);
    }

    @PostMapping("")
    public Topic create(@RequestBody Topic topic) {
        return topicService.create(topic);
    }

    @PutMapping("")
    public Topic update(@RequestBody Topic topic) {
        return topicService.update(topic);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        topicService.delete(id);
    }

}
