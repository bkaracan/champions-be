package com.bkaracan.champions.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "champion")
@Getter
@Setter
public class Champion implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "CHAMPION_ID_GENERATOR", sequenceName = "CHAMPION_ID_GEN", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHAMPION_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    @Lob
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "champion_role", joinColumns = @JoinColumn(name = "champion_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "champion")
    private List<Skill> skills;
}
