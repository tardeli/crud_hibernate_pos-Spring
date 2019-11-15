package br.com.tardeli.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
@Entity
@Table(name = "Partido")
public class Partido implements Serializable {
    @Id
    @Column(unique = true)
    private Long numero;
    private String nome;

    public Partido() {

    }

    public Partido(Long numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Partido [numero=" + numero + ", nome=" + nome + "]";
    }

}
