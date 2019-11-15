package br.com.tardeli.modelo;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Vereador")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vereador extends Pessoa {

    @Temporal(TemporalType.DATE)
    private Date dataAssociacao;
    @ManyToOne
    @JoinColumn(name = "partido")
    private Partido partido;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "vereador")
    private List<Projeto> projetos = new ArrayList<>();

    public Vereador() {

    }
    
    
    
    public Vereador(Date dataAssociacao, Partido partido, String nome) {
        super(nome);
        this.dataAssociacao = dataAssociacao;
        this.partido = partido;
    }

    public Date getDataAssociacao() {
        return dataAssociacao;
    }

    public void setDataAssociacao(Date dataAssociacao) {
        this.dataAssociacao = dataAssociacao;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public int qtdeProjetosApresentados() {
        int aux = 0;
        for (Projeto projeto : projetos) {
            if(projeto.isApresentado()){
                aux++;
            }
        }
        return aux;
    }

    public int qtdeProjetosAprovados() {
        int aux = 0;
        for (Projeto projeto : projetos) {
            if(projeto.isAprovado()){
                aux++;
            }
        }
        return aux;
    }

    public void adicionaProjeto(Projeto projeto) {
        this.getProjetos().add(projeto);
    }

    public float desempenho() {
        if(qtdeProjetosAprovados()!=0 && qtdeProjetosApresentados()!=0 ){
            return (float) qtdeProjetosAprovados() / qtdeProjetosApresentados() * 100;
        }
        return 0;
    }

    @Override
    public String getTipo() {
        return "Vereador";
    }

    public String projetos() {
        NumberFormat numberFormat = new DecimalFormat("0.00");
        String dados = "";
        for (Projeto projeto : projetos) {          
            dados += "\n  Projeto{" + "codigo=" + projeto.getCodigo() + ", nome=" + projeto.getNome() + ", aprovado=" + projeto.isAprovado() + ", apresentado=" + projeto.isApresentado() + '}';
        }
        dados += "]";
        dados += "\n    QTDE de projetos apresentados: "+qtdeProjetosApresentados();
        dados += "\n    QTDE de projetos aprovados: "+qtdeProjetosAprovados();
        dados += "\n    DESEMPENHO: "+numberFormat.format(desempenho())+"%";
        dados += "}";
        dados += "\n===============================================================================================================================";
        return dados;
    }

    @Override
    public String toString() {
        return super.toString() + ", dataAssociacao=" + dataAssociacao + ", partido=" + partido + ", Projetos [" + projetos();
    }

}
