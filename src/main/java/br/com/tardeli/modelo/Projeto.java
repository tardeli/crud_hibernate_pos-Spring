package br.com.tardeli.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
@Entity
@Table(name = "Projeto")
public class Projeto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long codigo;
    private String nome;
    private boolean aprovado;
    private boolean apresentado;
    @ManyToOne
    private Vereador vereador;

    public Projeto() {

    }

    public Projeto(String nome, boolean aprovado, boolean apresentado, Vereador vereador) {
        this.nome = nome;
        this.aprovado = aprovado;
        this.apresentado = apresentado;
        this.vereador = vereador;
    }

    public Vereador getVereador() {
        return vereador;
    }

    public void setVereador(Vereador vereador) {
        this.vereador = vereador;
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

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public boolean isApresentado() {
        return apresentado;
    }

    public void setApresentado(boolean apresentado) {
        this.apresentado = apresentado;
    }

    @Override
    public String toString() {
        return "Projeto{" + "codigo=" + codigo + ", nome=" + nome + ", aprovado=" + aprovado + ", apresentado=" + apresentado + ", vereador=" + vereador.getNome() +", codigo=" + vereador.getCodigo() + '}';
    }
}
