package br.com.tardeli.repository;

import br.com.tardeli.modelo.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long>{
   
}
