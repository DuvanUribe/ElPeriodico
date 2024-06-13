package uptc.frw.el_periodico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import uptc.frw.el_periodico.jpa.entity.Quality;
import uptc.frw.el_periodico.service.QualityService;


import java.util.List;


@Controller
public class QualityController {
    @Autowired
    private QualityService qualityService;

    @QueryMapping(name = "findAllQuality")
    public List<Quality> findAllQuality() {
        return qualityService.findAll();
    }

    @QueryMapping(name = "findQualityById")
    public Quality findQualityById(@Argument(name = "id") Integer id) {
        return qualityService.findById(id);
    }

    @MutationMapping
    public Quality createQuality(@Argument Quality inputQuality) {
        return qualityService.createQuality(inputQuality);
    }

    @MutationMapping
    public Quality updateQuality(@Argument Quality inputQuality) {
            return qualityService.updateQuality(inputQuality);
    }

    @MutationMapping
    public String deleteQuality(@Argument Integer id) {
        if (qualityService.findById(id) != null) {
            qualityService.deleteQuality(id);
            return ("CALIDAD ELIMINADA");
        }
            return ("NO SE ENCONTRO LA CALIDAD SOLICITADA PARA ELIMINAR");
    }
}
