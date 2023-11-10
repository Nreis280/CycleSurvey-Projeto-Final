package br.com.CycleSurvey.domain.repository;

import br.com.CycleSurvey.domain.entity.Acessorio;
import br.com.CycleSurvey.domain.entity.Bicicleta;
import br.com.CycleSurvey.domain.service.AcessorioService;
import br.com.CycleSurvey.infra.ConnectionFactory;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class BicicletaRepository implements Repository<Bicicleta,Long> {

    private ConnectionFactory factory;

    private static final AtomicReference<BicicletaRepository> instance = new AtomicReference<>();

    private BicicletaRepository() {
        this.factory = ConnectionFactory.build();
    }

    public static BicicletaRepository build() {
        instance.compareAndSet(null, new BicicletaRepository());
        return instance.get();
    }

    @Override
    public List<Bicicleta> findAll() {
        List<Bicicleta> list = new ArrayList<>();
        Connection con = factory.getConnection();
        ResultSet rs = null;
        Statement st = null;
        try {
            String sql = "SELECT * FROM T_CYCLESURVEY_INFO_BIKE";
            st = con.createStatement();
            rs = st.executeQuery(sql);

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    Long id = rs.getLong("BICICLETA_ID");
                    String marca = rs.getString("MARCA");
                    String modelo = rs.getString("MODELO");
                    int anoCompra = rs.getInt("ANO_COMPRA");
                    double valor = rs.getDouble("VALOR");
                    String nf = rs.getString("NOTA_FISCAL");

                    list.add(new Bicicleta(id,marca,modelo,anoCompra,valor,nf));


                    /**
                     *
                     * SELECT *
                     * FROM TB_BICICLETA b
                     * left join TB_ACESSORIO a on
                     * (b.acessorio_id = a.id_acessorio)
                     * where b.id = ?
                     *
                     * +
                     */

                    /**TB_ACESSORIOS_BICICLETA*/



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
    public Bicicleta findById(Long id) {
        Bicicleta bicicleta = null;
        var sql = "SELECT * FROM T_CYCLESURVEY_INFO_BIKE where BICICLETA_ID = ?";
        Connection con = factory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {

                    String marca = rs.getString("MARCA");
                    String modelo = rs.getString("MODELO");
                    int anoCompra = rs.getInt("ANO_COMPRA");
                    double valor = rs.getDouble("VALOR");
                    String nf = rs.getString("NOTA_FISCAL");
                    bicicleta = new Bicicleta(id,marca,modelo,anoCompra,valor,nf);
                }
            } else {
                System.out.println("Dados não encontrados com o id: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Não foi possível consultar os dados!\n" + e.getMessage());
        } finally {
            fecharObjetos(rs, ps, con);
        }
        return bicicleta;
    }

    @Override
    public Bicicleta persiste(Bicicleta bc) {

        var sql = "INSERT INTO T_CYCLESURVEY_INFO_BIKE ( MARCA , MODELO, ANO_COMPRA, VALOR,NOTA_FISCAL) VALUES (0, ?,?,?,?,?)";

        Connection con = factory.getConnection();
        PreparedStatement ps = null;

        try {

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // seta os valores dos parâmetros
            ps.setString(1, bc.getMarca());
            ps.setString(2, bc.getModelo());
            ps.setInt(3, bc.getAnoDeCompra());
            ps.setDouble(4, bc.getValor());
            ps.setString(5, bc.getNf());



            ps.executeUpdate();

            final ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                final Long id = rs.getLong(1);
                bc.setId(id);
            }

        } catch (SQLException e) {
            System.err.println("Não foi possível inserir os dados!\n" + e.getMessage());
        } finally {
            fecharObjetos(null, ps, con);
        }
        return bc;
    }
}
