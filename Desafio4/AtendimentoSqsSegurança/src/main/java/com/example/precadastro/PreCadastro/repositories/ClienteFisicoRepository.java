package com.example.precadastro.PreCadastro.repositories;

import com.example.precadastro.PreCadastro.models.ClienteFisico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteFisicoRepository extends JpaRepository<ClienteFisico, Long> {

    boolean existsByCpf(String cpf);
}
