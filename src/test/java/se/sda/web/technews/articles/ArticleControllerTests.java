package se.sda.web.technews.articles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ArticleControllerTests {
    @Autowired
    ArticleController articleController;

    @MockBean
    ArticleService articleService;

    @Test
    public void testGetById() {
        // Arrange
        Article article1 = new Article(1L, "More coding for developers", "text of the first article", "Bill Gates");
        Article article2 = new Article(2L, "Some exciting title", "text of the second article", "Bill Gates");

        Mockito.when(articleService.getById(1L))
                .thenReturn(Optional.of(article1));

        Mockito.when(articleService.getById(2L))
                .thenReturn(Optional.of(article2));
        //Act
        Optional<Article> controllerArticle1 = articleController.getById(1L);
        //Assert
        Assertions.assertEquals(article1.getTitle(), controllerArticle1.get().getTitle());
    }

    @Test
    public void testGetAll() {
        //Arrange
        Article article1 = new Article(1L, "More coding for developers", "text of the first article", "Bill Gates");
        Article article2 = new Article(2L, "Some exciting title", "text of the second article", "Bill Gates");
        List<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);

        Mockito.when(articleService.getAll())
                .thenReturn(articles);

        //Act
        List<Article> actualArticles = articleController.getAll(null);

        //Assert
        Assertions.assertEquals(articles.size(), actualArticles.size());
        Assertions.assertEquals(articles.get(0).getTitle(), actualArticles.get(0).getTitle());
        Assertions.assertEquals(articles.get(1).getTitle(), actualArticles.get(1).getTitle());
    }

    @Test
    public void testGetAllByTopicId() {
        //Arrange
        Long topicId = 101L;
        Article article1 = new Article(1L, "More coding for developers", "text of the first article", "Bill Gates");
        Article article2 = new Article(2L, "Some exciting title", "text of the second article", "Bill Gates");
        List<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);

        Mockito.when(articleService.getAllByTopicId(topicId))
                .thenReturn(articles);

        //Act
        List<Article> actualArticles = articleController.getAll(topicId);

        //Assert
        Assertions.assertEquals(articles.size(), actualArticles.size());
        Assertions.assertEquals(articles.get(0).getTitle(), actualArticles.get(0).getTitle());
        Assertions.assertEquals(articles.get(1).getTitle(), actualArticles.get(1).getTitle());
    }

}
