package com.sunniwell.weixin.bean.message;

import java.util.List;

/**
 * Created by xiaojian on 2018/1/30.
 */
public class NewsMessageBean extends BaseMessageBean {
    private int ArticleCount;
    private List<NewsBean> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<NewsBean> getArticles() {
        return Articles;
    }

    public void setArticles(List<NewsBean> articles) {
        Articles = articles;
    }
}
