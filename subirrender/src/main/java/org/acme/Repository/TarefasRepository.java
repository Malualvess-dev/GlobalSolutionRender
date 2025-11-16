package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.TarefasDTO;
import org.acme.Model.Tarefas;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TarefasRepository {
    @Inject
    DataSource dataSource;

    //Inserir dados

    public void Inserir(TarefasDTO tarefas) throws SQLException {
        String sql = "Insert into Tarefas (nome_tarefa, epico, departamento,prioridade,id_funcionario) values (?,?,?,?,?)";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, tarefas.getNome_tarefa());
            ps.setString(2, tarefas.getEpico());
            ps.setString(3,tarefas.getDepartamento());
            ps.setString(4,tarefas.getPrioridade());
            ps.setInt(5,tarefas.getId_funcionario());

            ps.executeUpdate();
        }

    }

    //Ler dados

    public List<Tarefas> lista() throws SQLException {
        String sql = "Select * from Tarefas Order by id_tarefa";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            List<Tarefas> listaTarefas = new ArrayList<>();
            while (rs.next()){
                Tarefas t = new Tarefas(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));

                listaTarefas.add(t);
            }
            return listaTarefas;
        }
    }

    //Atualizar


    public void Atualizar(int id_tarefa, TarefasDTO tarefasDTO) throws SQLException{
        String sql =  "Update Tarefas set prioridade =? where id_tarefa = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,tarefasDTO.getPrioridade());
            ps.setInt(2,id_tarefa);

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas == 0){
                throw new SQLException("Tarefa não foi atualizada");
            }
        }
    }

    //Deletar


    public void remover(int id_tarefa) throws SQLException{
        String sql = "Delete from Tarefas where id_tarefa = ?";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id_tarefa);

            int linhasAfetadas = ps.executeUpdate();
            if(linhasAfetadas == 0){
                throw new IllegalArgumentException("Tarefa não deletada");
            }
        }

    }
}
