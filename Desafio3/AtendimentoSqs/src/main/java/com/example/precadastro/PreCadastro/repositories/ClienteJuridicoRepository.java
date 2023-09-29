package com.example.precadastro.PreCadastro.repositories;

import com.example.precadastro.PreCadastro.models.ClienteJuridico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJuridicoRepository extends JpaRepository<ClienteJuridico, Long> {

    boolean existsByCnpj(String Cnpj);
}
