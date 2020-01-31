package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {
    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void deleteById() {
        service.deleteById((long) 11);
        service.deleteById((long) 11);
        verify(specialtyRepository, times(2)).deleteById((long) 11);
    }

    @Test
    void deleteByIdAtLeast() {
        service.deleteById((long) 11);
        service.deleteById((long) 11);
        verify(specialtyRepository, atLeast(1)).deleteById((long) 11);
    }

    @Test
    void deleteByIdAtMost() {
        service.deleteById((long) 11);
        service.deleteById((long) 11);
        verify(specialtyRepository, atMost(5)).deleteById((long) 11);
    }

    @Test
    void deleteByIdNever() {
        service.deleteById((long) 11);
        service.deleteById((long) 11);
        verify(specialtyRepository, atMost(5)).deleteById((long) 11);

        verify(specialtyRepository, never()).deleteById(5L);
    }

    @Test
    void testDelete() {
        service.delete(new Speciality());
    }
}