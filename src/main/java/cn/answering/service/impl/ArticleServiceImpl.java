package cn.answering.service.impl;

import cn.answering.domain.Article;
import cn.answering.domain.es.ElastArticle;
import cn.answering.repository.ArticleRepository;
import cn.answering.repository.es.ElastArticleRepository;
import cn.answering.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ElastArticleRepository elastArticleRepository;

    @Transactional
    @Override
    public Article updateArticle(Article article) {
    	//Save article repository given in parameters
        Article returnValue = articleRepository.save(article);
        //Save elastic article by creating a new article
        elastArticleRepository.save(new ElastArticle(article));
        //return the value
        return  returnValue;
    }

    @Transactional
    @Override
    public void deleteArticleById(String id) {
    	//delete that article repository
        articleRepository.delete(id);
        //delete elastic article repository by Id
        elastArticleRepository.deleteElastArticleByArticleId(id);
    }

    @Override
    public Article findArticleById(String id) {
    	//find one article repository by id
        return articleRepository.findOne(id);
    }
}
