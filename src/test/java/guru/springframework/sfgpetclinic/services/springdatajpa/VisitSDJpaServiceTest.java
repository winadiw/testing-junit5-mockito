package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {
    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @Test
    void findAll() {
//        Set<Visit> visitsAll = service.findAll();
//        Mockito.verify(visitRepository).findAll();

        Set<Visit> visits = new HashSet<>();
        visits.add(new Visit());

        Mockito.when(visitRepository.findAll()).thenReturn(visits);

        Set<Visit> foundVisits = service.findAll();

        Mockito.verify(visitRepository).findAll();

        assertThat(foundVisits).hasSize(1);
    }

    @Test
    void findById() {
//        service.findById(1L);
//        Mockito.verify(visitRepository).findById(anyLong());

        Visit visit = new Visit();

        Mockito.when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));

        Visit foundVisit = service.findById(1L);

        Mockito.verify(visitRepository).findById(anyLong());

        assertThat(foundVisit).isNotNull();
    }

    @Test
    void save() {
//        Visit visit = new Visit();
//        service.save(visit);
//        Mockito.verify(visitRepository).save(any(Visit.class));

        Visit visit = new Visit();
        Mockito.when(visitRepository.save(any(Visit.class))).thenReturn(visit);

        Visit savedVisit = service.save(visit);

        Mockito.verify(visitRepository).save(any(Visit.class));

        assertThat(savedVisit).isNotNull();
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
        Mockito.verify(visitRepository).deleteById(anyLong());
    }
}