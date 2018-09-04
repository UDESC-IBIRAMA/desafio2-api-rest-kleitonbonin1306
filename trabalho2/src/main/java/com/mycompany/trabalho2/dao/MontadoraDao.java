/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho2.dao;

import Model.Montadora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.mycompany.trabalho2.dao.DAO;

/**
 *
 * @author Kleiton Bonin
 */
public class MontadoraDao extends DAO{
  
    public Montadora getMontadora(long id) {
        return (Montadora) ler(Montadora.class, id);
    }

    public void removeMontadora(int id) {
        Montadora oMontadora = getMontadora(id);
        remover(oMontadora);
    }

    public void modificaMontadora(Montadora oMontadora) {
        Montadora valida = getMontadora(oMontadora.getId());
        if (valida != null) {
            atualizar(oMontadora);
        }
    }
}
