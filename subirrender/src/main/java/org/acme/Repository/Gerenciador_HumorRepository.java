package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.Gerenciador_HumorDTO;
import org.acme.Model.Gerenciador_Humor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Gerenciador_HumorRepository {
    @Inject
    DataSource dataSource;

    //Inserção de dados

    public void Inserir(Gerenciador_HumorDTO humor) throws SQLException {
        String sql = "Insert into Gerenciador_Humor (horas_sono, ambiente_trabalho, qtd_agua, qtd_estresse, pesquisa_clima,id_funcionario) values (?,?,?,?,?,?)";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setDouble(1,humor.getHoras_sono());
            ps.setString(2,humor.getAmbiente_trabalho());
            ps.setInt(3,humor.getQtd_agua());
            ps.setInt(4,humor.getQtd_estresse());
            ps.setString(5,humor.getPesquisa_clima());
            ps.setInt(6,humor.getId_funcionario());

            ps.executeUpdate();
        }
    }

    //Ler dados

    public List<Gerenciador_Humor> lista()throws SQLException{
        String sql = "Select * from Gerenciador_Humor Order by id_humor";

        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ResultSet rs =ps.executeQuery();

            List<Gerenciador_Humor> listaHumor = new ArrayList<>();
            while (rs.next()){
                Gerenciador_Humor h = new Gerenciador_Humor(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7)
                );
                listaHumor.add(h);
            }
            return listaHumor;
        }
    }

    //Atualizar Dados

    //Não é necessário nessa classe

    //DELETE

    //Não é necessário nessa classe tmb
}
