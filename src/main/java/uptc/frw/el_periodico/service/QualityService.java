package uptc.frw.el_periodico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.graphqlgrupo2.jpa.entity.Quality;
import uptc.frw.graphqlgrupo2.jpa.repository.QualityRepository;

import java.util.List;

@Service
public class QualityService {

    @Autowired
    private QualityRepository qualityRepository;

    public List<Quality> findAll() {
        return qualityRepository.findAll();
    }

    public Quality findById(Integer id) {
        return qualityRepository.findById(id).orElse(null);
    }

    public Quality createQuality(Quality quality) {
        return qualityRepository.save(quality);
    }

    public Quality updateQuality(Quality quality) {
        Quality qualityPre = findById((int) quality.getId());
        if (qualityPre != null && quality.getQuialityType()!=null) {
            return qualityRepository.save(quality);
        }
       return null;
    }

    public void deleteQuality(Integer id) {
        qualityRepository.deleteById(id);
    }

}
