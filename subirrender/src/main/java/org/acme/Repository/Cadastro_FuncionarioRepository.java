package org.acme.Repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.Cadastro_Funcionario;
import org.acme.Model.DTO.Cadastro_FuncionarioDTO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Cadastro_FuncionarioRepository {
    @Inject
    DataSource dataSource;

    //Inserção de dados

    public void Inserir(Cadastro_FuncionarioDTO funcionaro) throws SQLException {
        String sql = "Insert into Cadastro_Funcionario (cpf, nome, email, telefone, senha, departamento, dt_nascimento,id_gerente, id_departamento) values (?,?,?,?,?,?,?,?,?)";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,funcionaro.getCpf());
            ps.setString(2,funcionaro.getNome());
            ps.setString(3,funcionaro.getEmail());
            ps.setString(4,funcionaro.getTelefone());
            ps.setString(5,funcionaro.getSenha());
            ps.setString(6,funcionaro.getDepartamento());
            ps.setString(7,funcionaro.getDt_nascimento());
            ps.setInt(8,funcionaro.getId_gerente());
            ps.setInt(9,funcionaro.getId_departamento());

            ps.executeUpdate();
        }
    }

    //Ler dados

    public List<Cadastro_Funcionario> listar() throws SQLException{
        String sql = "Select * from Cadastro_Funcionario Order by id_funcionario";

        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ResultSet rs =ps.executeQuery();

            List<Cadastro_Funcionario> listaFuncionario = new ArrayList<>();
            while (rs.next()){
                Cadastro_Funcionario f = new Cadastro_Funcionario(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)
                );
                listaFuncionario.add(f);
            }
            return listaFuncionario;
        }
    }

    //Atualiizar dados

    public void AtualizarSenha(int id_funcionario, Cadastro_FuncionarioDTO funcionario) throws SQLException{
        String sql =  "Update Cadastro_Funcionario set senha = ? where id_funcionario = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1,funcionario.getSenha());
            ps.setInt(2,id_funcionario);

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas == 0){
                throw new SQLException("Senha não foi alterada");
            }
        }
    }


    //DELETE

    public void remover(int id_funcionario) throws SQLException{
        String sql = "Delete from Cadastro_Funcionario where id_funcionario = ?";
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id_funcionario);

            int linhasAfetadas = ps.executeUpdate();
            if(linhasAfetadas == 0){
                throw new IllegalArgumentException("Funcionario não deletado");
            }
        }

    }

    //Buscar por cpf

    public Cadastro_Funcionario buscarPorCPF(String cpf) throws SQLException {

        String sql = "SELECT * FROM Cadastro_Funcionario WHERE cpf = ?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Cadastro_Funcionario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10)
                );
            }
        }

        return null;
    }

}
