# Tech-news
API project for SDA 8 allowing the usage of data for a simple news website.

## Functionality and endpoints

There are three main endpoints:

/articles
/comments
/topics

All the three endpoints allow access by id (ex. articles/id).

Articles can be accessed by category and by topic:

/articles?categoryId={id}
/articles?topicId={id}

There is also a possibility to check what topics an article belongs to and what comments have been left for an article:

/topics?articleId={id}
/comments?articleId={id}

Reactions are integrated in the Article class. There are two types of reactions: likes and dislikes available for articles.
Both can be implemented by calling the following endpoints:

/articles/{id}/like
/articles/{id}/dislike

