package cn.answering.controller;

import cn.answering.domain.Article;
import cn.answering.domain.es.ElastArticle;
import cn.answering.service.ArticleService;
import cn.answering.service.es.ElastArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/transaction-article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    //Instansiation of the service Article

    @Autowired
    private ElastArticleService elastArticleService;
    //Instansiation of the Elastic Article Service


    @GetMapping
    public ModelAndView getArticle(@RequestParam(value = "content",required = false,defaultValue = "")String content,
                                   @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndexe,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageTaille,
                                   Model modele){
    	// Knowing the number of pages
        Pageable pageable = new PageRequest(pageIndexe,pageTaille);
        // Testing that the pages exist
        if (content == null || content == "" || content.equals("")){
        	//Fetch all pages
            Page<ElastArticle> page = elastArticleService.findAllPages(pageable);
            //Print all the titles
            System.out.println(page.getContent().get(0).getTitre());
            //Add content to Article list
            modele.addAttribute("articleList",page.getContent());
        }else {
        	//Fetch article
            Page<ElastArticle> page = elastArticleService.fetchArticle(content,pageable);
            //Get Content of Article list
            modele.addAttribute("articleList",page.getContent());
        }
        //Return the article model
        return new ModelAndView("index","articleModel",modele);

    }

    @PostMapping
    public String addArticle(@RequestParam(value = "title",required = true,defaultValue = "title")String titre,
                             @RequestParam(value = "content",required = true,defaultValue = "content")String contenu){
    	//Instatiate a new article
        Article article = new Article(titre,contenu);
        //Save or Update the Article
        articleService.updateArticle(article);
        //Redirect to the article
        return "redirect:transaction-article";
    }
    @GetMapping
    @RequestMapping(value="/deleteallArticles")
    public String deleteAllArticles(){
        
        elastArticleService.deleteallArticles();
        return "redirect:/";
    }

}
