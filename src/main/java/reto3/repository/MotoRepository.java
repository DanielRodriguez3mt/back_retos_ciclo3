package reto3.repository;

import reto3.entities.Motorbike;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends CrudRepository<Motorbike, Integer> {

    @Override
    List<Motorbike> findAll();
}
