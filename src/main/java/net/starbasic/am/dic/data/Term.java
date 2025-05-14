package net.starbasic.am.dic.data;


import jakarta.persistence.*;

@Entity
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String term;
    private String definition;

    // гетери та сетери
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTerm() { return term; }
    public void setTerm(String term) { this.term = term; }

    public String getDefinition() { return definition; }
    public void setDefinition(String definition) { this.definition = definition; }
}
