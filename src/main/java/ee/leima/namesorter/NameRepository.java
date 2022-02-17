package ee.leima.namesorter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NameRepository extends JpaRepository<Name, Integer> {

}