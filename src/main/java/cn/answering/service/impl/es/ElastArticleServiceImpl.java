package cn.answering.service.impl.es;

import cn.answering.domain.Tag;
import cn.answering.domain.User;
import cn.answering.domain.es.ElastArticle;
import cn.answering.repository.es.ElastArticleRepository;
import cn.answering.service.es.ElastArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ElastArticleServiceImpl implements ElastArticleService{

    @Autowired
    private ElastArticleRepository elastArticleRepository;

    @Override
    public ElastArticle saveOrUpdate(ElastArticle elastArticle) {
        return elastArticleRepository.save(elastArticle);
    }

    @Override
    public void delete(String id) {
        elastArticleRepository.delete(id);
    }
    
    @Override
    public void deleteallArticles() {
        elastArticleRepository.deleteAll();;
    }

    @Override
    public Page<ElastArticle> fetchArticle(String content, Pageable pageable) {
        return elastArticleRepository.findDistinctByTitreContainingOrContenuContaining(content,content,pageable);
    }

    @Override
    public Page<ElastArticle> fetchArticle(String title, String content, User author, List<Tag> tags, Pageable pageable) {
        return elastArticleRepository.findDistinctByTitreContainingOrContenuContainingOrMakerContainingOrTagsContaining(title,content,author,tags,pageable);
    }

    @Override
    public void deleteByArticleId(String id) {
        elastArticleRepository.deleteElastArticleByArticleId(id);
    }

    @Override
    public Page<ElastArticle> findAllPages(Pageable pageable) {
        return (Page<ElastArticle>) elastArticleRepository.findAll();
    }
}
