package uptc.frw.el_periodico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import uptc.frw.graphqlgrupo2.jpa.entity.News;
import uptc.frw.graphqlgrupo2.service.NewsService;

import java.util.List;


@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;

    @QueryMapping(name = "findAllNews")
    public List<News> findAllNews() {
        return newsService.findAll();
    }

    @QueryMapping(name = "findNewsById")
    public News findNewsById(@Argument(name = "id") Integer id) {
        return newsService.findById(id);
    }

    @MutationMapping
    public News createNews(@Argument News inputNews) {
        return newsService.createNews(inputNews);
    }

    @MutationMapping
    public News updateNews(@Argument News inputNews) {
        return newsService.updateNews(inputNews);
    }

    @MutationMapping
    public String deleteNews(@Argument Integer id) {
        if (newsService.findById(id) != null) {
            newsService.deleteNews(id);
            return ("NOTICIA ELIMINADA");
        }
        return ("NO SE ENCONTRO NOTICIA PARA ELIMINAR");
    }

    @MutationMapping
    public String createRelationNews(@Argument Integer id1, @Argument Integer id2) {
        if (newsService.findById(id1) != null && newsService.findById(id2) != null) {
            newsService.createRelationNews(id1, id2);
            return ("RELACION CREADA");
        }
        return ("NO SE ENCONTRO NOTICIA PARA RELACIONAR O RELACION INVALIDA");
    }

    @MutationMapping
    public String deleteRelationNews(@Argument Integer id1, @Argument Integer id2) {
        if (newsService.findById(id1) != null && newsService.findById(id2) != null && newsService.findById(id1).getNewsList() !=null) {
            newsService.deleteRelationNews(id1, id2);
            return ("RELACION ELIMINADA");
        }
        return ("NO SE ENCONTRO RELACION EXISTENTE O NOTICIA NO EXISTENTE");
    }
}
