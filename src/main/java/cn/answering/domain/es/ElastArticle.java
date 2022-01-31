package cn.answering.domain.es;

import cn.answering.domain.Article;
import cn.answering.domain.Tag;
import cn.answering.domain.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;

import java.io.Serializable;
import java.util.List;


@Document(indexName = "article",type = "article")
public class ElastArticle implements Serializable{
    private static final long serialVersionUID = -3442422877407279457L;


    @Id
    private String id;

    @Field
    private String articleId;

    private String titre;

    private String contenu;

    private User maker;

    private List<Tag> tags; 

    protected ElastArticle(){}

    public ElastArticle(String titre,String contenu){
        this.contenu = contenu;
    }

    public ElastArticle(String articleId,String titre,String contenu,User maker,List<Tag> tags){
        this.articleId = articleId;
        this.titre = titre;
        this.contenu = contenu;
        this.maker = maker;
        this.tags = tags;
    }

    public ElastArticle(Article article){
        this.articleId = article.getId();
        this.titre = article.getTitre();
        this.contenu = article.getContenu();
        this.maker = article.getMaker();
        this.tags = article.getTags();
    }

    public void update(Article article){
        this.articleId = article.getId();
        this.titre = article.getTitre();
        this.contenu = article.getContenu();
        this.maker = article.getMaker();
        this.tags = article.getTags();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public User getMaker() {
        return maker;
    }

    public void setMaker(User maker) {
        this.maker = maker;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
