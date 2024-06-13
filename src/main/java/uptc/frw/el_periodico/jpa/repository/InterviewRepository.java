package uptc.frw.el_periodico.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uptc.frw.el_periodico.jpa.entity.Interview;


import java.util.List;


public interface InterviewRepository extends JpaRepository<Interview, Integer  > {
    @Query("SELECT an FROM Interview an WHERE an.idNews = ?1")
    public List<Interview> findInterviewaBy (Integer idAN);

}
