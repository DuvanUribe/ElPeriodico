package uptc.frw.el_periodico.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uptc.frw.graphqlgrupo2.jpa.entity.AgencyNews;

import java.util.List;


public interface AgencyNewsRepository extends JpaRepository<AgencyNews, Integer  > {
    @Query("SELECT an FROM AgencyNews an WHERE an.idNews = ?1")
    public List<AgencyNews> findAgencyNewaBy (Integer idAN);

}
