package uptc.frw.el_periodico.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "AGENCIA_NOTICIA")
public class AgencyNews {

    @Id
    @Column(name = "ID_AGENCIA_NOTICIA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAgencyNews")
    @SequenceGenerator(name = "seqAgencyNews",sequenceName = "SEQ_AGENCIA_NOTICIA",allocationSize = 1)
    private int id;

    @Column(name = "ID_NOTICIA",insertable = false, updatable = false)
    private int idNews;

    @Column(name = "ID_AGENCIA",insertable = false, updatable = false)
    private int idAgency;

    @Column(name = "FECHA")
    private String  date;

    @Column(name = "HORA")
    private String  hour;


    @ManyToOne
    @JoinColumn(name = "ID_NOTICIA")
    private News news;


    @ManyToOne
    @JoinColumn(name = "ID_AGENCIA")
    private Agency agency;


}
