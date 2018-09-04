/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho2;

import Model.Montadora;
import Model.Veiculo;
import com.mycompany.trabalho2.dao.MontadoraDao;
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
@Path("/montadora")
public class Genericmontadora {
      private MontadoraDao persistencia = new MontadoraDao();


    /**
     * Creates a new instance of GenericResource
     */
    public Genericmontadora() {
    }

    @GET
    @Path("/testeModelo")
    @Produces(MediaType.APPLICATION_JSON)
    public Montadora getJson() {
        Montadora montadora = new Montadora();
        montadora.setId(1L);
        montadora.setNome("chevrolet");
        return montadora;
    }

    @GET
    @Path("/getId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Montadora buscaVeiculo(@PathParam("id") int idResource) {
        Montadora oMontadora = null;
        try {
            oMontadora = persistencia.getMontadora(idResource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oMontadora;
    }


    @POST
    @Path("/adicionar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String adicionar(Montadora oMontadora) {
        String feedback = "";
        try {
            persistencia.salvar(oMontadora);
            feedback = "Gravados:\n" + oMontadora.toString();
        } catch (Exception e) {
            e.printStackTrace();
            feedback = "Erro!\n" + e.getMessage();
        }
        return feedback;
    }

    @PUT
    @Path("/alterar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterar(Montadora oMontadora) {
        try {
            persistencia.atualizar(oMontadora);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int idResource) {
        try {
            persistencia.removeMontadora(idResource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
