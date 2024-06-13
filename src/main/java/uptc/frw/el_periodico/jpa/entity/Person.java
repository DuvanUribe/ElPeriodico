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
@Table(name = "PERSONA")
public class Person {

    @Id
    @Column(name = "ID_PERSONA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPerson")
    @SequenceGenerator(name = "seqPerson",sequenceName = "SEQ_PERSONA",allocationSize = 1)
    private int id;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "DIRECCION")
    private String addres;

    @Column(name = "TELEFONO")
    private Integer phone;

    @Column(name = "FECHA_NACIMIENTO")
    private String birthday;

    @OneToMany(mappedBy ="journalist")
    private List<Interview> journalist;

    @OneToMany(mappedBy ="involved")
    private List<Interview> involved;


 }
