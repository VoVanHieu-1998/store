package com.store.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "catalog")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int catalogId;
    String name;
    String nameVN;
    Integer parentId;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "catalogId")
    Set<Product> listproduct;

    public String getNameVN() {
        return nameVN;
    }

    public void setNameVN(String nameVN) {
        this.nameVN = nameVN;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Set<Product> getListproduct() {
        return listproduct;
    }

    public void setListproduct(Set<Product> listproduct) {
        this.listproduct = listproduct;
    }
}
