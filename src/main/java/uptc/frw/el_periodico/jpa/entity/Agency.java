package uptc.frw.el_periodico.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "AGENCIA")
public class Agency {

    @Id
    @Column(name = "ID_AGENCIA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAgency")
    @SequenceGenerator(name = "seqAgency",sequenceName = "SEQ_AGENCIA",allocationSize = 1)
    private int id;

    @Column(name ="NOMBRE_AGENCIA")
    private String agencyName;

    @Column(name ="ANIO_CREACION")
    private Integer yearCreacion;

    @OneToMany(mappedBy ="agency")
    private List<AgencyNews> agencyNews;
}
