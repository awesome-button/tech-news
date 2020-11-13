package se.sda.web.technews.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("")
    public List<Article> getAll(@RequestParam(required = false) Long topicId) {

        if (topicId == null) {
            return articleService.getAll();
        } else {
            return articleService.getAllByTopicId(topicId);
        }
    }

    @GetMapping("/{id}")
    public Optional<Article> getById(@PathVariable Long id) {
        return articleService.getById(id);
    }

    @PostMapping("")
    public Article create(@RequestBody Article article) {
        return articleService.create(article);
    }

    @PutMapping("")
    public Article update(@RequestBody Article article) {
        return articleService.update(article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
    }

    @PutMapping("/{id}")
    public void reactToArticle(@PathVariable Long id, @RequestParam String reaction) {
        articleService.reactToArticle(id, reaction);
    }

}
