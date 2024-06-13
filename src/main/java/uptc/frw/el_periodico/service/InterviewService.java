package uptc.frw.el_periodico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.el_periodico.jpa.entity.Interview;
import uptc.frw.el_periodico.jpa.entity.News;
import uptc.frw.el_periodico.jpa.entity.Person;
import uptc.frw.el_periodico.jpa.entity.Quality;
import uptc.frw.el_periodico.jpa.repository.InterviewRepository;


import java.util.List;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private QualityService qualityService;

    public List<Interview> findAll() {
        return interviewRepository.findAll();
    }

    public Interview findById(Integer id) {
        return interviewRepository.findById(id).orElse(null);
    }

    public Interview createInterview(Interview interview) {
        News news = newsService.findById(interview.getIdNews());
        Person journal =personService.findById(interview.getIdJournalist());
        Person involved =personService.findById(interview.getIdInvolved());
        Quality quality =qualityService.findById(interview.getIdQuality());
        if ( journal != null && news != null && involved != null && quality != null && interview.getSummary() != null) {
            interview.setNews(news);
            interview.setJournalist(journal);
            interview.setInvolved(involved);
            interview.setQuality(quality);
            interview.setSummary(interview.getSummary());

                return interviewRepository.save(interview);
        }
        return null;
    }

    public Interview updateInterview(Interview interview) {
        Interview interviewPre = findById(interview.getId());
        News news = newsService.findById(interview.getIdNews());
        Person journal =personService.findById(interview.getIdJournalist());
        Person involved =personService.findById(interview.getIdInvolved());
        Quality quality =qualityService.findById(interview.getIdQuality());
        if (interviewPre != null ) {
            if ( interview.getSummary() != null) {
                    interviewPre.setSummary(interview.getSummary());
            }
            if (journal != null) {
                interviewPre.setJournalist(journal);
            }
            if (involved != null) {
                interviewPre.setInvolved(involved);
            }
            if (news != null) {
                interviewPre.setNews(news);
            }
            if (quality != null) {
                interviewPre.setQuality(quality);
            }
            return interviewRepository.save(interviewPre);
        }
        return null;
    }

    public void deleteInterview(Integer id) {
        interviewRepository.deleteById(id);
    }

}
