package uptc.frw.el_periodico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.frw.graphqlgrupo2.jpa.entity.Agency;
import uptc.frw.graphqlgrupo2.jpa.repository.AgencyRepository;

import java.util.List;

@Service
public class AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    public List<Agency> findAll() {
        return agencyRepository.findAll();
    }

    public Agency findById(Integer id) {
        return agencyRepository.findById(id).orElse(null);
    }

    public Agency createAgency(Agency agency) {
        return agencyRepository.save(agency);
    }

    public Agency updateAgency(Agency agency) {
        Agency agencyPre = findById(agency.getId());
        if (agencyPre != null ) {
            if (agency.getAgencyName() != null) {
                agencyPre.setAgencyName(agency.getAgencyName());
            }
            if (agency.getYearCreacion() != null){
                agencyPre.setYearCreacion(agency.getYearCreacion());
            }
            return agencyRepository.save(agencyPre);
        }
       return null;
    }

    public void deleteAgency(Integer id) {
        agencyRepository.deleteById(id);
    }

}
