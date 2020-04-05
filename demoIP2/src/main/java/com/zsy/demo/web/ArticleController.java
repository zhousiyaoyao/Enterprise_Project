package com.zsy.demo.web;

import com.zsy.demo.entity.Article;
import com.zsy.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/super")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/getarticlebyid", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    private Map<String, Object> getArticleById(Integer ID){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Article article = articleService.getArticleById(ID);
        System.out.println(article);
        modelMap.put("article", article);
        return modelMap;
    }

    @RequestMapping(value = "/listarticle1", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    private Map<String, Object> listArticle1(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Article> list = articleService.getArticleList1();
        modelMap.put("articleList", list);
        return modelMap;
    }

    @RequestMapping(value = "/listarticle0", method = RequestMethod.GET)
    @CrossOrigin(origins = "*")
    private Map<String, Object> listArticle0(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Article> list = articleService.getArticleList0();
        modelMap.put("articleList", list);
        return modelMap;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public void delete(@RequestParam int r_id) {
        articleService.delete(r_id);
    }

    @RequestMapping(value = "/recover", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public void recover(@RequestParam int r_id) {
        articleService.recover(r_id);
    }

    @RequestMapping(value = "/recycle", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public void recycle(@RequestParam int r_id) {
        articleService.recycle(r_id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public String saveArticle(Article article) {
        try {
            articleService.saveArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public Map<String, Object> toArticleView(@RequestParam int r_id){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Article article = articleService.findById(r_id);
        modelMap.put("article", article);
        return modelMap;
    }

}
