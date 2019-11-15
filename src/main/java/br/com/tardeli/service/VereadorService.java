package br.com.tardeli.service;

import br.com.tardeli.modelo.Partido;
import br.com.tardeli.modelo.Vereador;
import br.com.tardeli.repository.VereadorRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
@Service
public class VereadorService {
    
    @Autowired
    private VereadorRepository repository;
    
    private List<Vereador> listaObjs = new ArrayList<>();
        
    public boolean salvarOuAtualizar(Vereador obj){
        try {
            repository.save(obj);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public boolean remover(Vereador obj){
        try {
            repository.delete(obj);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public List<Vereador> listarTodos(){
        try {
            return listaObjs = repository.findAll();
        } catch (Exception e) {
            e.getMessage();
        }
        return listaObjs;
    }
    
    public Vereador buscarVereadorPorCodigo(Long codigo) {
        Vereador p = new Vereador();
        try {
            p = repository.findById(codigo).orElse(new Vereador());
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return p;
    }
    
    public List<Vereador> buscarDadosVereadorPorNome(String nome) {
        try {
           return repository.findByNomeIgnoreCaseContaining(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List buscarVereadoresAssociadosPorDatas(Date d_Inicial, Date d_Final) { 
        try {
            return listaObjs = repository.findAllByDataAssociacaoBetween(d_Inicial, d_Final);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listaObjs;
    }
    
    public List buscarVereadoresPorPartido(Partido obj) {
        try {
            return listaObjs = repository.findByPartido(obj);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listaObjs;
    }
    
    
    
}
