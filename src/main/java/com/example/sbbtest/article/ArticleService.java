package com.example.sbbtest.article;


import com.example.sbbtest.siteUser.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> findAll() {
        return this.articleRepository.findAll();
    }

    public void create(String subject, String content, SiteUser user) {
        Article q = new Article();
        q.setSubject(subject);
        q.setContent(content);
        q.setLocalDateTime(LocalDateTime.now());
        q.setAuthor(user);
        this.articleRepository.save(q);
    }

    public Article getArticle(Integer id) {
        Optional<Article> article = this.articleRepository.findById(id);
        return article.get();
    }

    public void delete(Article article) {
        this.articleRepository.delete(article);
    }

    public void modify(Integer id, String subject, String content) {
        Optional<Article> article = this.articleRepository.findById(id);
        Article article1 = article.get();
        article1.setSubject(subject);
        article1.setContent(content);
        this.articleRepository.save(article1);
    }
}

