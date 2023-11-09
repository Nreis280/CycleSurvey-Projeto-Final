package br.com.CycleSurvey.domain.repository;

import br.com.CycleSurvey.domain.entity.Cliente;
import br.com.CycleSurvey.infra.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ClienteRepository implements Repository <Cliente,Long>{

    private ConnectionFactory factory;

    private static final AtomicReference<ClienteRepository> instance = new AtomicReference<>();

    private ClienteRepository() {
        this.factory = ConnectionFactory.build();
    }

    public static ClienteRepository build() {
        instance.compareAndSet(null, new ClienteRepository());
        return instance.get();
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> list = new ArrayList<>();
        Connection con = factory.getConnection();
        ResultSet rs = null;
        Statement st = null;
        try {
            String sql = "SELECT * FROM T_CYCLESURVEY_PESSOA_FISICA";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    Long id = rs.getLong("ID_PESSOA");
                    String nome = rs.getString("NM_COMPLETO");
                    LocalDate nascimento = rs.getDate("DT_NASCIMENTO").toLocalDate();
                    String cpf = rs.getString("CPF");
                    String cel = rs.getString("CELULAR");
                    list.add(new Cliente(id, nome, nascimento,cpf,cel,));
                }
            }
        } catch (SQLException e) {
            System.err.println("Não foi possível consultar os dados!\n" + e.getMessage());
        } finally {
            fecharObjetos(rs, st, con);
        }
        return list;
    }


    @Override
    public Cliente findById(Long id) {
        Cliente pessoa = null;
        var sql = "SELECT * FROM T_CYCLESURVEY_PESSOA_FISICA where ID_PESSOA = ?";
        Connection con = factory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String nome = rs.getString("NM_COMPLETO");
                    LocalDate nascimento = rs.getDate("DT_NASCIMENTO").toLocalDate();
                    String cpf = rs.getString("CPF");
                    String cel = rs.getString("CELULAR");
                    pessoa = new Cliente(id, nome, nascimento,cpf,cel,);
                }
            } else {
                System.out.println("Dados não encontrados com o id: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Não foi possível consultar os dados!\n" + e.getMessage());
        } finally {
            fecharObjetos(rs, ps, con);
        }
        return pessoa;
    }



    @Override
    public Cliente persiste(Cliente cl) {

        var sql = "INSERT INTO t_cycleSurvey_pessoa_fisica (NM_COMPLETO, DT_NASCIMENTO , CPF, CELULAR)" +
                " VALUES (?, ?, ?, ?)";

        Connection con = factory.getConnection();
        PreparedStatement ps = null;

        try {

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // seta os valores dos parâmetros
            ps.setString(1, cl.getNome());
            ps.setDate(2, Date.valueOf(cl.getNascimento()));
            ps.setString(3, cl.getCpf());
            ps.setString(4, cl.getCelular());

            ps.executeUpdate();

            final ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                final Long id = rs.getLong(1);
                cl.setId(id);
            }

        } catch (SQLException e) {
            System.err.println("Não foi possível inserir os dados!\n" + e.getMessage());
        } finally {
            fecharObjetos(null, ps, con);
        }
        return cl;
    }

}