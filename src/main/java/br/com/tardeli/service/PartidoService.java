package br.com.tardeli.service;

import br.com.tardeli.modelo.Partido;
import br.com.tardeli.repository.PartidoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
@Service
public class PartidoService {
    
    @Autowired
    private PartidoRepository repository;

    public boolean salvarOuAtualizar(Partido obj){
        try {
            repository.save(obj);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public boolean remover(Partido obj){
        try {
            repository.delete(obj);
            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    
    public List<Partido> listarTodos(){
        List<Partido> objs = new ArrayList<>();
        try {
            return objs = repository.findAll();
        } catch (Exception e) {
            e.getMessage();
        }
        return objs;
    }
    
    public Partido buscarPartidoPorCodigo(Long codigo) {
        Partido p = new Partido();
        try {
            p = repository.findById(codigo).orElse(new Partido());
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
}
