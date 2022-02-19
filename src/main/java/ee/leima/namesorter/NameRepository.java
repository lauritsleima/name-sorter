package ee.leima.namesorter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NameRepository extends JpaRepository<Name, Integer> {
    List<Name> findByNameLike(String filter);

    List<Name> findByNameContaining(String name);

    List<Name> findByNameContainingOrNameStartingWith(String filter, String filter2);

    @Query("select n from Name n where upper(n.name) like upper(concat('%', ?1, '%')) or upper(n.name) like upper(concat(?2, '%'))")
    List<Name> findNameByFilterLetter(Character filter, Character filter2);

}