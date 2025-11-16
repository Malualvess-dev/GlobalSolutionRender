package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.DepartamentoDTO;
import org.acme.Model.Departamento;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DepartamentoRepository {
    @Inject
    DataSource dataSource;

    //Inserir Dados

    public void Inserir(DepartamentoDTO departamento) throws SQLException {
        String sql = "Insert into Departamento (nome_departamento, id_gerente) values (?,?)";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, departamento.getNome_departamento());
            ps.setInt(2, departamento.getId_gerente());

            ps.executeUpdate();
        }

    }

    //Ler dados

    public List<Departamento> lista() throws SQLException {
        String sql = "Select * from Departamento Order by id_departamento";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            List<Departamento> listaDepartamento = new ArrayList<>();
            while (rs.next()){
                Departamento d = new Departamento(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
                listaDepartamento.add(d);
            }
            return listaDepartamento;
        }
    }

    //Atualizar dados

    public void Atualizar(int id_departamento, DepartamentoDTO departamento) throws SQLException{
        String sql =  "Update Departamento set id_gerente =? where id_departamento = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,departamento.getId_gerente());
            ps.setInt(2,id_departamento);

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas == 0){
                throw new SQLException("Departamento não foi alterado");
            }
        }
    }

    //Deletar


    public void remover(int id_departamento) throws SQLException{
        String sql = "Delete from Departamento where id_departamento = ?";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id_departamento);

            int linhasAfetadas = ps.executeUpdate();
            if(linhasAfetadas == 0){
                throw new IllegalArgumentException("Departamento não deletado");
            }
        }

    }

}
