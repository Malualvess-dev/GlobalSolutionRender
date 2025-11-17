package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.Cadastro_Gerente;
import org.acme.Model.DTO.Cadastro_GerenteDTO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Cadastro_GerenteRepository {
    @Inject
    DataSource dataSource;

    //Inserção de dados

    public void Inserir(Cadastro_GerenteDTO gerente) throws SQLException {
        String sql = "Insert into Cadastro_Gerente (cpf, nome, email, telefone, senha, departamento, dt_nascimento) values (?,?,?,?,?,?,?)";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,gerente.getCpf());
            ps.setString(2,gerente.getNome());
            ps.setString(3,gerente.getEmail());
            ps.setString(4,gerente.getTelefone());
            ps.setString(5,gerente.getSenha());
            ps.setString(6,gerente.getDepartamento());
            ps.setString(7,gerente.getDt_nascimento());

            ps.executeUpdate();
        }
    }

    //Ler dados

    public List<Cadastro_Gerente> listar() throws SQLException{
        String sql = "Select * from Cadastro_Gerente Order by id_gerente";

        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ResultSet rs =ps.executeQuery();

            List<Cadastro_Gerente> listaGerente = new ArrayList<>();
            while (rs.next()){
                Cadastro_Gerente g = new Cadastro_Gerente(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
                listaGerente.add(g);
            }
            return listaGerente;
        }
    }


    //Atualizar dados

    public void AtualizarSenha(int id_gerente, Cadastro_GerenteDTO gerente) throws SQLException{
        String sql =  "Update Cadastro_Gerente set senha = ? where id_gerente = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,gerente.getSenha());
            ps.setInt(2,id_gerente);

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas == 0){
                throw new SQLException("Senha não foi alterada");
            }
        }
    }


    //DELETE

    public void remover(int id_gerente) throws SQLException{
        String sql = "Delete from Cadastro_Gerente where id_gerente = ?";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id_gerente);

            int linhasAfetadas = ps.executeUpdate();
            if(linhasAfetadas == 0){
                throw new IllegalArgumentException("Gerente não deletado");
            }
        }

    }

    // -----------------------------------------
    // BUSCAR POR CPF (login)
    // -----------------------------------------
    public Cadastro_Gerente buscarPorCPF(String cpf) throws SQLException {

        String sql = "SELECT * FROM Cadastro_Gerente WHERE cpf = ?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cpf);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Cadastro_Gerente(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8)
                    );
                }
            }
        }

        return null;
    }
}
