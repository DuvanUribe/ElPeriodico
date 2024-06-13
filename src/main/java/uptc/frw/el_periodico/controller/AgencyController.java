package uptc.frw.el_periodico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import uptc.frw.graphqlgrupo2.jpa.entity.Agency;
import uptc.frw.graphqlgrupo2.service.AgencyService;

import java.util.List;


@Controller
public class AgencyController {
    @Autowired
    private AgencyService agencyService;

    @QueryMapping(name = "findAllAgency")
    public List<Agency> findAllAgency() {
        return agencyService.findAll();
    }

    @QueryMapping(name = "findAgencyById")
    public Agency findAgencyById(@Argument(name = "id") Integer id) {
        return agencyService.findById(id);
    }

    @MutationMapping
    public Agency createAgency(@Argument Agency inputAgency) {
        return agencyService.createAgency(inputAgency);
    }

    @MutationMapping
    public Agency updateAgency(@Argument Agency inputAgency) {
            return agencyService.updateAgency(inputAgency);
    }

    @MutationMapping
    public String deleteAgency(@Argument Integer id) {
        if (agencyService.findById(id) != null) {
            agencyService.deleteAgency(id);
            return ("AGENCIA ELIMINADA");
        }
            return ("NO SE ENCONTRO LA AGENCIA SOLICITADA PARA ELIMINAR");
    }
}
