package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.Gerenciador_HumorDTO;
import org.acme.Model.Gerenciador_Humor;
import org.acme.Repository.Gerenciador_HumorRepository;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class Gerenciador_HumorService {
    @Inject
    Gerenciador_HumorRepository gerenciadorHumorRepository;

    //Inserir
    public void Inserir(Gerenciador_HumorDTO humor) throws SQLException {
        gerenciadorHumorRepository.Inserir(humor);
    }

    //Listar
    public List<Gerenciador_Humor> listar() throws SQLException{
        return gerenciadorHumorRepository.lista();
    }
}
