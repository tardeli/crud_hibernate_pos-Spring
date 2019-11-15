package br.com.tardeli.modelo;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
@MappedSuperclass
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String nome;

    public Pessoa() {

    }

    public Pessoa(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTipo(){
        return "Pessoa";
    }

    @Override
    public String toString() {
        return getTipo()+" {codigo=" + codigo + ", nome=" + nome;
    }

}
