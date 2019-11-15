package br.com.tardeli.service;

import br.com.tardeli.modelo.Projeto;
import br.com.tardeli.modelo.Vereador;
import br.com.tardeli.repository.ProjetoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository repository;
    
    private List<Projeto> listaObjs = new ArrayList<>();
    
    public boolean salvarOuAtualizar(Projeto obj){
        try {
            repository.save(obj);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public boolean remover(Projeto obj){
        try {
            repository.delete(obj);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public List<Projeto> listarTodos(){
        try {
            return listaObjs = repository.findAll();
        } catch (Exception e) {
            e.getMessage();
        }
        return listaObjs;
    }
    
    public Projeto buscarProjetoPorCodigo(Long codigo) {
        Projeto p = new Projeto();
        try {
            p = repository.findById(codigo).orElse(new Projeto());
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return p;
    }
    
    public List<Projeto> buscarProjetoPorNome(String nome) {
        try {
            return repository.findByNomeIgnoreCaseContaining(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Projeto> buscarProjetosPorVereador(Vereador obj) {
        try {
            return listaObjs = repository.findByVereador(obj);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
   
}
