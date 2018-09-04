/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho2;

import Model.Veiculo;
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
@Path("/veiculos")
public class GenericResource {
      private VeiculoDao persistencia = new VeiculoDao();


    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    @GET
    @Path("/testeVeiculo")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo getJson() {
        Veiculo veiculo = new Veiculo();
        veiculo.setId(1L);
        veiculo.setMontadora(1L);
        veiculo.setModelo(1L);
        veiculo.setMotor(2);
        veiculo.setCor("vermelho");
        veiculo.setKm(85000);
        return veiculo;
    }

    @GET
    @Path("/getId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo buscaVeiculo(@PathParam("id") int idResource) {
        Veiculo oVeiculo = null;
        try {
            oVeiculo = persistencia.getVeiculo(idResource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oVeiculo;
    }


    @POST
    @Path("/adicionar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String adicionar(Veiculo oVeiculo) {
        String feedback = "";
        try {
            persistencia.salvar(oVeiculo);
            feedback = "Gravados:\n" + oVeiculo.toString();
        } catch (Exception e) {
            e.printStackTrace();
            feedback = "Erro!\n" + e.getMessage();
        }
        return feedback;
    }

    @PUT
    @Path("/alterar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterar(Veiculo oVeiculo) {
        try {
            persistencia.atualizar(oVeiculo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int idResource) {
        try {
            persistencia.removeVeiculo(idResource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
