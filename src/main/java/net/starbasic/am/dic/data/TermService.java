package net.starbasic.am.dic.data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermService {
    private final TermRepository repository;

    public TermService(TermRepository repository) {
        this.repository = repository;
    }

    public List<Term> getAllTerms() {
        return repository.findAll();
    }

    public void addTerm(Term term) {
        repository.save(term);
    }

    public List<Term> search(String keyword) {
        return repository.findByTermContainingIgnoreCase(keyword);
    }
}
