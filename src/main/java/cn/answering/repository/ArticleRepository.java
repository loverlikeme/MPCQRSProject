package cn.answering.repository;

import cn.answering.domain.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// The repository about the article 
@Repository
public interface ArticleRepository extends MongoRepository<Article,String>{

}
