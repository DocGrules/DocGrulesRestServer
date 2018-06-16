package com.grules.rest.services;

import com.grules.rest.services.soapclient.Evento;
import com.grules.rest.services.soapclient.EventoWebService;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

@Stateless
public class SendToSoap {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/desktop-6s2397t_8080/grules-soap-sever/EventoWebService.wsdl")
    private EventoWebService service;

    public void save(Evento obj){
        saveEvento(obj);        
    }

    private void saveEvento(com.grules.rest.services.soapclient.Evento arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.grules.rest.services.soapclient.GrulesWebService port = service.getGrulesWebServicePort();
        port.saveEvento(arg0);
    }
}
