package net.starbasic.am.dic.data;

import net.starbasic.am.dic.data.Term;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TermRepository extends JpaRepository<Term, Long> {
    List<Term> findByTermContainingIgnoreCase(String keyword);
}

