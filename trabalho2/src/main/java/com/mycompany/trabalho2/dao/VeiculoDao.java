/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalho2.dao;

import Model.Montadora;
import Model.Veiculo;

/**
 *
 * @author Kleiton Bonin
 */
public class VeiculoDao extends DAO{
      
    public Veiculo getVeiculo(long id) {
        return (Veiculo) ler(Veiculo.class, id);
    }

    public void removeVeiculo(int id) {
        Veiculo oVeiculo = getVeiculo(id);
        remover(oVeiculo);
    }

    public void modificaVeiculo(Veiculo oVeiculo) {
        Veiculo valida = getVeiculo(oVeiculo.getId());
        if (valida != null) {
            atualizar(oVeiculo);
        }
    }
}

