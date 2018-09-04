/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Kleiton Bonin
 */
@Entity
@Table(name="veiculo")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="cor")
    private String Cor;
    @Column(name="km")
    private float km;
    @Column(name="motor")
    private float motor;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "veiculo")
    private List<Modelo> Modelo = new ArrayList<>();
     
     @OneToMany(cascade=CascadeType.ALL, mappedBy = "veiculo")
    private List<Montadora> Montadora = new ArrayList<>();

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public float getMotor() {
        return motor;
    }

    public void setMotor(float motor) {
        this.motor = motor;
    }

    public List<Modelo> getModelo() {
        return Modelo;
    }

    public void setModelo(List<Modelo> Modelo) {
        this.Modelo = Modelo;
    }

    public List<Montadora> getMontadora() {
        return Montadora;
    }

    public void setMontadora(List<Montadora> Montadora) {
        this.Montadora = Montadora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Veiculo[ id=" + id + " ]";
    }
    
}
