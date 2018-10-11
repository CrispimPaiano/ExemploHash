package dao;

import bean.filmeBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Crispim Paiano dos Santos
 */
public class FilmeDAO {

    public int cadastrar(filmeBean filmezinho) {
        Connection conexao = Conexao.conectar();
        if(conexao != null){
            String sql = "INSERT INTO filmes (nome, diretor, categoria, ano, atorPrincipal, tempoFilme, orcamento, faturamento, faixaEtaria, legenda, dublado, idiomaOriginal)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
            try {
                int index = 1;
                PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(index++, filmezinho.getNome());
                ps.setString(index++, filmezinho.getDiretor());
                ps.setString(index++, filmezinho.getCategoria());
                ps.setShort(index++, filmezinho.getAno());
                ps.setString(index++, filmezinho.getAtorPrincipal());
                ps.setShort(index++, filmezinho.getTempoFilme());
                ps.setDouble(index++, filmezinho.getOrcamento());
                ps.setDouble(index++, filmezinho.getFaturamento());
                ps.setString(index++, filmezinho.getFaixaEtaria());
                ps.setBoolean(index++, filmezinho.isLegenda());
                ps.setBoolean(index++, filmezinho.isDublado());
                ps.setString(index++, filmezinho.getIdiomaOriginal());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                   return rs.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return -1;
    }

    public filmeBean retornarPorId(int id) {
        Connection conexao = Conexao.conectar();
        if(conexao != null){
            String sql = "SELECT * FROM filmes WHERE id = ?";
            try {
                PreparedStatement ps  = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                ps.execute();
                ResultSet rs =  ps.getResultSet();
                if (rs.next()) {
                    filmeBean filme = new filmeBean();
                    filme.setId(rs.getInt("id"));
                    filme.setNome(rs.getString("nome"));
                    filme.setDiretor(rs.getString("diretor"));
                    filme.setCategoria(rs.getString("categoria"));
                    filme.setAtorPrincipal(rs.getString("atorPrincipal"));
                    filme.setFaixaEtaria(rs.getString("faixaEtaria"));
                    filme.setIdiomaOriginal(rs.getString("idiomaOriginal"));
                    filme.setAno(rs.getShort("ano"));
                    filme.setTempoFilme(rs.getShort("tempoFilme"));
                    filme.setOrcamento(rs.getDouble("orcamento"));
                    filme.setFaturamento(rs.getDouble("faturamento"));
                    filme.setLegenda(rs.getBoolean("legenda"));
                    filme.setDublado(rs.getBoolean("dublado"));
                    return filme;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return null;
    }

    public boolean deletar(int id) {
        Connection conexao =  Conexao.conectar();
        if (conexao != null) {
            String sql = "DELETE FROM filmes WHERE id = ?";
            try {
                PreparedStatement ps =  conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, id);
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return false;
    }

    public boolean alterar(filmeBean filmezinho) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "UPDATE filmes SET nome = ?, diretor = ?, categoria = ?, ano = ?, atorPrincipal = ?, tempoFilme = ?, orcamento = ?,"
                    + " faturamento = ?, faixaEtaria = ?, legenda = ?, dublado = ?, idiomaOriginal = ? WHERE id = ?";
            try {
                int index = 1;
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(index++, filmezinho.getNome());
                ps.setString(index++, filmezinho.getDiretor());
                ps.setString(index++, filmezinho.getCategoria());
                ps.setShort(index++, filmezinho.getAno());
                ps.setString(index++, filmezinho.getAtorPrincipal());
                ps.setShort(index++, filmezinho.getTempoFilme());
                ps.setDouble(index++, filmezinho.getOrcamento());
                ps.setDouble(index++, filmezinho.getFaturamento());
                ps.setString(index++, filmezinho.getFaixaEtaria());
                ps.setBoolean(index++, filmezinho.isLegenda());
                ps.setBoolean(index++, filmezinho.isDublado());
                ps.setString(index++, filmezinho.getIdiomaOriginal());
                ps.setInt(index++, filmezinho.getId());
                return ps.executeUpdate() == 1;
                
            } catch (Exception e) {
            }
        }
        return false;
    }
    
}
