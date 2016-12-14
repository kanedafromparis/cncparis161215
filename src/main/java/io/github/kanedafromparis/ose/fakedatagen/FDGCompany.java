/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kanedafromparis.ose.fakedatagen;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author csabourdin
 */
public class FDGCompany {


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the FKPersonneLst
     */
    public List <FDGPersonne> getFKPersonneLst() {
        return FKPersonneLst;
    }

    /**
     * @param FKPersonneLst the FKPersonneLst to set
     */
    public void setFKPersonneLst(List <FDGPersonne> FKPersonneLst) {
        this.FKPersonneLst = FKPersonneLst;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String name;
    private String note;
    private List <FDGPersonne>FKPersonneLst;
}
