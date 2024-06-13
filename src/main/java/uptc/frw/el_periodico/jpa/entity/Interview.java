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
@Table(name = "ENTREVISTA")
public class Interview {

    @Id
    @Column(name = "ID_ENTREVISTA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqInterview")
    @SequenceGenerator(name = "seqInterview",sequenceName = "SEQ_ENTREVISTA",allocationSize = 1)
    private int id;

    @Column(name = "ID_PERIODISTA",insertable = false, updatable = false)
    private int idJournalist;

    @Column(name = "ID_IMPLICADO",insertable = false, updatable = false)
    private int idInvolved;

    @Column(name = "ID_NOTICIA",insertable = false, updatable = false)
    private int idNews;

    @Column(name = "ID_CALIDAD",insertable = false, updatable = false)
    private int idQuality;

    @Column(name = "RESUMEN")
    private String  summary;

    @ManyToOne
    @JoinColumn(name = "ID_PERIODISTA")
    private Person journalist;

    @ManyToOne
    @JoinColumn(name = "ID_IMPLICADO")
    private Person involved;

    @ManyToOne
    @JoinColumn(name = "ID_NOTICIA")
    private News news;

    @ManyToOne
    @JoinColumn(name = "ID_CALIDAD")
    private Quality quality;
}
