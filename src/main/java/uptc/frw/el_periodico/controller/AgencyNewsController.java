package uptc.frw.el_periodico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import uptc.frw.graphqlgrupo2.jpa.entity.AgencyNews;
import uptc.frw.graphqlgrupo2.service.AgencyNewsService;

import java.util.List;


@Controller
public class AgencyNewsController {

    @Autowired
    private AgencyNewsService agencyNewsService;

    @QueryMapping(name = "findAllAgencyNews")
    public List<AgencyNews> findAllAgencyNews() {
        return agencyNewsService.findAll();
    }

    @QueryMapping(name = "findAgencyNewsById")
    public AgencyNews findAgencyNewsById(@Argument(name = "id") Integer id) {
        return agencyNewsService.findById(id);
    }

    @MutationMapping
    public AgencyNews createAgencyNews(@Argument AgencyNews inputAgencyNews) {
        return agencyNewsService.createAgencyNews(inputAgencyNews);
    }



    @MutationMapping
    public AgencyNews updateAgencyNews(@Argument AgencyNews inputAgencyNews) {
            return agencyNewsService.updateAgencyNews(inputAgencyNews);
    }

    @MutationMapping
    public String deleteAgencyNews(@Argument Integer id) {
        if (agencyNewsService.findById(id) != null) {
            agencyNewsService.deleteAgencyNews(id);
            return ("AGENCIA_NOTICIA ELIMINADA");
        }
            return ("NO SE ENCONTRO LA AGENCIA_NOTICIA SOLICITADA PARA ELIMINAR");
    }



}
