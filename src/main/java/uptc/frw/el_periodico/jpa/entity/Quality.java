package uptc.frw.el_periodico.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "CALIDAD")
public class Quality {

    @Id
    @Column(name = "ID_CALIDAD")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqQuality")
    @SequenceGenerator(name = "seqQuality",sequenceName = "SEQ_CALIDAD",allocationSize = 1)
    private int id;

    @Column(name ="TIPO_CALIDAD")
    private String quialityType;

    @OneToMany(mappedBy ="quality")
    private List<Interview> interviews;
}
