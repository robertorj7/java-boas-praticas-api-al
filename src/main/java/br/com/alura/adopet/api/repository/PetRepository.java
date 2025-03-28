package br.com.alura.adopet.api.repository;

import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.StatusAdocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

    boolean existsByPetIdAndStatus(Long idPet, StatusAdocao statusAdocao);
}
