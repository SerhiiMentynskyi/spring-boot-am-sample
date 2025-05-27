package net.starbasic.am.dic;

import net.starbasic.am.dic.data.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "terms", collectionResourceRel = "terms")
public interface TermRESTRepository extends JpaRepository<Term, Long> {

}

/*
Відправка запиту через fetch-API
fetch('http://localhost:8080/api/terms', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    term: 'Test', definition : 'Test definition'
  })
})
.then(response => {
  if (!response.ok) {
    throw new Error('HTTP error: ' + response.status);
  }
  return response.json();
})
.then(data => console.log('Успішно створено:', data))
.catch(error => console.error('Помилка:', error));
 */