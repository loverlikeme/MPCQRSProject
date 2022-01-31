package cn.answering.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class Article {

    @Id
    private String id;

    // Le titre de l'article
    private String titre;

    // Le contenu de l'article
    private String contenu;

    // The maker of the article
    private User maker;

    // The tags list
    private List<Tag> tags; 

    protected Article(){}

    public Article(String titre,String contenu,User maker){
        this.titre = titre;
        this.contenu = contenu;
        this.maker = maker;
    }
    public Article(String titre,String contenu){
        this.titre = titre;
        this.contenu = contenu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setmaker(User maker) {
        this.maker = maker;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString(){
    	// Return to string the title and the content of the article
        return String.format("the article is:[title=%s,content=%s]",titre,contenu);
    }
}
