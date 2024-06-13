package uptc.frw.el_periodico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import uptc.frw.el_periodico.jpa.entity.Interview;
import uptc.frw.el_periodico.service.InterviewService;

import java.util.List;


@Controller
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @QueryMapping(name = "findAllInterview")
    public List<Interview> findAllInterview() {
        return interviewService.findAll();
    }

    @QueryMapping(name = "findInterviewById")
    public Interview findInterviewById(@Argument(name = "id") Integer id) {
        return interviewService.findById(id);
    }

    @MutationMapping
    public Interview createInterview(@Argument Interview inputInterview) {
        return interviewService.createInterview(inputInterview);
    }


    @MutationMapping
    public Interview updateInterview(@Argument Interview inputInterview) {
        return interviewService.updateInterview(inputInterview);
    }

    @MutationMapping
    public String deleteInterview(@Argument Integer id) {
        if (interviewService.findById(id) != null) {
            interviewService.deleteInterview(id);
            return ("ENTREVISTA ELIMINADA");
        }
        return ("NO SE ENCONTRO LA ENTREVISTA SOLICITADA PARA ELIMINAR");
    }


}
