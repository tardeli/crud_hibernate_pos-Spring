package br.com.tardeli.repository;

import br.com.tardeli.modelo.Partido;
import br.com.tardeli.modelo.Vereador;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
@Repository
public interface VereadorRepository extends JpaRepository<Vereador, Long>{
    
    List<Vereador> findByNomeIgnoreCaseContaining(String nome);
    
    List<Vereador> findByPartido(Partido obj);
    
    List<Vereador> findAllByDataAssociacaoBetween(Date d_Inicial, Date d_Final);
    
    
}
