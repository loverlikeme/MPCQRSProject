package cn.answering.service.es;

import cn.answering.domain.Tag;
import cn.answering.domain.User;
import cn.answering.domain.es.ElastArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ElastArticleService {

	// Save or updating the existing Elastic Article
    public ElastArticle saveOrUpdate(ElastArticle elastArticle);

    //delete the existing Elastic Article by Id
    public void delete(String id);

    //find article by contenu and pageable
    public Page<ElastArticle> fetchArticle(String contenu, Pageable pageable);

    //find article by titre & contenu & maker & tags & pageable
    public Page<ElastArticle> fetchArticle(String titre, String contenu, User maker, List<Tag> tags, Pageable pageable);

    //delete by article Id
    public void deleteByArticleId(String id);

    //find all pages
    public Page<ElastArticle> findAllPages(Pageable pageable);

    //delete All articles
	void deleteallArticles();

}
