package cn.answering.service;

import cn.answering.domain.Article;

// The article service
public interface ArticleService {
	
    //Updating the existing article by passing the changed one 
    public Article updateArticle(Article article);

    //Find an article by Id 
    public Article findArticleById(String id);
    
    //Delete the article by Id
    public void deleteArticleById(String id);

}
