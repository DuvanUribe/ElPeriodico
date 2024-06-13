package uptc.frw.el_periodico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.graphqlgrupo2.jpa.entity.News;
import uptc.frw.graphqlgrupo2.jpa.repository.NewsRepository;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<News> findAll() {
        return newsRepository.findAll();
    }

    public News findById(Integer id) {
        return newsRepository.findById(id).orElse(null);
    }

    public News createNews(News news) {
        if (news.getDate()!= null  && news.getHour()!= null) {
            if (DateValidator.isValidDate(news.getDate()) && DateValidator.isValidHour(news.getHour())) {
                return newsRepository.save(news);
            }
        }
        return null;
    }

    public News updateNews(News news) {
        News newsPre = findById(news.getId());
        if (newsPre != null ) {
            if (news.getDate() != null) {
                if (DateValidator.isValidDate(news.getDate())) {
                    newsPre.setDate(news.getDate());
                }
            }
            if (news.getHour() != null) {
                if (DateValidator.isValidHour(news.getHour())) {
                    newsPre.setHour(news.getHour());
                }
            }
            if (news.getHolder() != null) {
                newsPre.setHolder(news.getHolder());
            }
            if (news.getBody() != null) {
                newsPre.setBody(news.getBody());
            }
            return newsRepository.save(newsPre);
        }
        return null;
    }

    public void deleteNews(Integer id) {
        newsRepository.deleteById(id);
    }

    public void createRelationNews(Integer id1,Integer id2) {
        News news1 = findById(id1);
        News news2 = findById(id2);
        if (news1 != null && news2 != null) {
            news2.getNewsList().add(news1);
            news1.getNewsList().add(news2);
            newsRepository.save(news1);
            newsRepository.save(news2);
        }
    }

    public void deleteRelationNews(Integer id1, Integer id2) {
        News news1 = findById(id1);
        News news2 = findById(id2);

        if (news1 != null && news2 != null) {
            news1.getNewsList().remove(news2);
            news2.getNewsList().remove(news1);
            newsRepository.save(news1);
            newsRepository.save(news2);
        }
    }

}
