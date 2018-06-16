/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grules.rest.managedbeans;


import com.grules.rest.services.SendToSoap;
import com.grules.rest.services.soapclient.Evento;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Gustavo Santos
 */
@Named(value = "eventoMB")
@ViewScoped
public class EventoMB implements Serializable {

    private String semestre;
    private String tema;
    Evento e = new Evento();
    
    @Inject
    private SendToSoap sts;
    
    public EventoMB() {
    }
    
    public void saveEvento(){
        e.setSemestre(semestre);
        e.setTema(tema);
        sts.save(e);
        semestre = "";
        tema = "";
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
}
