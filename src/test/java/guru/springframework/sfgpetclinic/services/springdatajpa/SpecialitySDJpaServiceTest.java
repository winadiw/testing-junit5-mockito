package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {
    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void findByIdTest() {
        // New speciality object
        Speciality speciality = new Speciality();

        //When specialtyRepository.findById is called, return an optional data
        Mockito.when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));

        // Invoke service.findById
        Speciality foundSpecialty = service.findById(1L);

        // Make sure that service.findById returns data
        assertThat(foundSpecialty).isNotNull();

        //Make sure that specialtyRepository.findById(1L) only run ONE TIME
        verify(specialtyRepository).findById(1L);
    }

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