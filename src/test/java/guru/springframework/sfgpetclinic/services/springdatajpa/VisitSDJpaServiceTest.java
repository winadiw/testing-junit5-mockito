package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {
    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @Test
    void findAll() {
        Set<Visit> visitsAll = service.findAll();
        Mockito.verify(visitRepository).findAll();
    }

    @Test
    void findById() {
        service.findById(1L);
        Mockito.verify(visitRepository).findById(anyLong());
    }

    @Test
    void save() {
        Visit visit = new Visit();
        service.save(visit);
        Mockito.verify(visitRepository).save(any(Visit.class));
    }

    @Test
    void delete() {
        Visit visit = new Visit();
        service.delete(visit);
        Mockito.verify(visitRepository).delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        Mockito.verify(visitRepository).deleteById(1L);
    }
}