package uptc.frw.el_periodico.jpa.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "NOTICIA")
public class News {

    @Id
    @Column(name = "ID_NOTICIA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqNews")
    @SequenceGenerator(name = "seqNews",sequenceName = "SEQ_NOTICIA",allocationSize = 1)
    private int id;

    @Column(name = "FECHA")
    private String date;

    @Column(name = "HORA")
    private String hour;

    @Column(name = "TITULAR")
    private String holder;

    @Column(name = "TEXTO")
    private String body;

    @OneToMany(mappedBy ="news")
    private List<AgencyNews> agencyNews;

    @OneToMany(mappedBy ="news")
    private List<Interview> interviews;


    @ManyToMany
    @JoinTable(
            name = "NOTICIA_RELACIONADA",
            joinColumns = @JoinColumn(name = "NOTICIA1"),
            inverseJoinColumns = @JoinColumn(name = "NOTICIA2")
    )
    private List<News> newsList;


    @ManyToMany(mappedBy = "newsList")
    private List<News> relatedToNews;

}
