package cn.answering.repository.es;

import cn.answering.domain.Tag;
import cn.answering.domain.User;
import cn.answering.domain.es.ElastArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// The repository about the Elastic Repository 
@Repository
public interface ElastArticleRepository extends ElasticsearchRepository<ElastArticle,String> {

	// Finding the content disticly by titre & contenu & maker & tags
    Page<ElastArticle> findDistinctByTitreContainingOrContenuContainingOrMakerContainingOrTagsContaining(String titre, String contenu, User maker, List<Tag> Tags, Pageable pageable);

    // Finding the content disticly by titre & contenu & maker & tags
    Page<ElastArticle> findDistinctByTitreContainingOrContenuContaining(String titre,String contenu, Pageable pageable);

    // Delete elastic article by article Id 
    void deleteElastArticleByArticleId(String id);


}
