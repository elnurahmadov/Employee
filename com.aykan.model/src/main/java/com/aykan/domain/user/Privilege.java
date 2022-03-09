package com.aykan.domain.user;

import javax.persistence.*;
import java.util.List;

@Entity
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "privilege_id")
    private Long id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;

    public Privilege() {
    }

    public Privilege(String name, List<Role> roles) {
        this.name = name;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Privilege)) return false;

        Privilege privilege = (Privilege) o;

        return getId() != null ? getId().equals(privilege.getId()) : privilege.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
