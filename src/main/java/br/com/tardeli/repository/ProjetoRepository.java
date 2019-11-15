package br.com.tardeli.repository;

import br.com.tardeli.modelo.Projeto;
import br.com.tardeli.modelo.Vereador;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
    
    List<Projeto> findByNomeIgnoreCaseContaining(String nome);
    
    List<Projeto> findByVereador(Vereador obj);
    
}
