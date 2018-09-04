/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho2.dao;

import Model.Modelo;
import Model.Montadora;

/**
 *
 * @author Kleiton Bonin
 */
public class ModeloDao extends DAO {
    
       public Modelo getModelo(long id) {
        return (Modelo) ler(Modelo.class, id);
    }

    public void removeModelo(int id) {
        Modelo oModelo = getModelo(id);
        remover(oModelo);
    }

    public void ModificaModelo(Modelo oModelo) {
        Modelo valida = getModelo(oModelo.getId());
        if (valida != null) {
            atualizar(oModelo);
        }
    }
}
