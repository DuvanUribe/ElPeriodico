package uptc.frw.el_periodico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.el_periodico.jpa.entity.Agency;
import uptc.frw.el_periodico.jpa.entity.AgencyNews;
import uptc.frw.el_periodico.jpa.entity.News;
import uptc.frw.el_periodico.jpa.repository.AgencyNewsRepository;


import java.util.List;

@Service
public class AgencyNewsService {

    @Autowired
    private AgencyNewsRepository agencyNewsRepository;

    @Autowired
    private NewsService newsService;

    @Autowired
    private AgencyService agencyService;

    public List<AgencyNews> findAll() {
        return agencyNewsRepository.findAll();
    }

    public AgencyNews findById(Integer id) {
        return agencyNewsRepository.findById(id).orElse(null);
    }

    public AgencyNews createAgencyNews(AgencyNews agencyNews) {
        Agency agency =agencyService.findById(agencyNews.getIdAgency());
        News news = newsService.findById(agencyNews.getIdNews());
        if (agencyNews.getDate()!= null  && agencyNews.getHour()!= null && agency != null && news != null) {
            if (DateValidator.isValidDate(agencyNews.getDate()) && DateValidator.isValidHour(agencyNews.getHour())) {
                agencyNews.setNews(news);
                agencyNews.setAgency(agency);
                return agencyNewsRepository.save(agencyNews);
            }
        }
        return null;
    }

    public AgencyNews updateAgencyNews(AgencyNews agencyNews) {
        AgencyNews agencyNewsPre = findById(agencyNews.getId());
        Agency agencyPre =agencyService.findById(agencyNews.getIdAgency());
        News newsPre = newsService.findById(agencyNews.getIdNews());
        if (agencyNewsPre != null ) {
            if ( agencyNews.getDate() != null) {
                if (DateValidator.isValidDate(agencyNews.getDate())) {
                    agencyNewsPre.setDate(agencyNews.getDate());
                }
            }
            if (agencyNews.getHour() != null) {
                if (DateValidator.isValidHour(agencyNews.getHour())) {
                    agencyNewsPre.setHour(agencyNews.getHour());
                }
            }
            if (agencyPre != null) {
                agencyNewsPre.setAgency(agencyPre);
            }
            if (newsPre != null) {
                agencyNewsPre.setNews(newsPre);
            }
            return agencyNewsRepository.save(agencyNewsPre);
        }
        return null;
    }

    public void deleteAgencyNews(Integer id) {
        agencyNewsRepository.deleteById(id);
    }

}
