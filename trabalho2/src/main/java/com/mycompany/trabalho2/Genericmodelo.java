/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho2;

import Model.Modelo;
import Model.Veiculo;
import com.mycompany.trabalho2.dao.ModeloDao;
import com.mycompany.trabalho2.dao.ModeloDao;
import com.mycompany.trabalho2.dao.VeiculoDao;
import static java.awt.Event.DELETE;
import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author Kleiton Bonin
 */
@Path("/modelo")
public class Genericmodelo {
      private ModeloDao persistencia = new ModeloDao();


    /**
     * Creates a new instance of GenericResource
     */
    public Genericmodelo() {
    }

    @GET
    @Path("/testeModelo")
    @Produces(MediaType.APPLICATION_JSON)
    public Modelo getJson() {
        Modelo montadora = new Modelo();
        montadora.setId(1L);
        montadora.setNome("Onix");
        return montadora;
    }

    @GET
    @Path("/getId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Modelo buscaVeiculo(@PathParam("id") int idResource) {
        Modelo oModelo = null;
        try {
            oModelo = persistencia.getModelo(idResource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oModelo;
    }


    @POST
    @Path("/adicionar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String adicionar(Modelo oModelo) {
        String feedback = "";
        try {
            persistencia.salvar(oModelo);
            feedback = "Gravados:\n" + oModelo.toString();
        } catch (Exception e) {
            e.printStackTrace();
            feedback = "Erro!\n" + e.getMessage();
        }
        return feedback;
    }

    @PUT
    @Path("/alterar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterar(Modelo oModelo) {
        try {
            persistencia.atualizar(oModelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int idResource) {
        try {
            persistencia.removeModelo(idResource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
