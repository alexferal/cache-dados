package br.edu.ifpb.bd2.modelo;

import br.edu.ifpb.bd2.modelo.Connection.ConnectionFactory;

import java.sql.*;
import java.util.Optional;

public class PublicacaoDAOPgSql implements PublicacaoDAO {

    private Connection connection;
    private PublicacaoDAORedis publicacaoDAORedis;

    public PublicacaoDAOPgSql(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        this.connection = connectionFactory.getConnection();
        this.publicacaoDAORedis = new PublicacaoDAORedis();
    }

    @Override
    public void salvarPublicacao(Publicacao publicacao) {
        String query = "INSERT INTO publicacao(id, corpo, data, idusuario) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, publicacao.getId());
            statement.setString(2 ,publicacao.getCorpo());
            statement.setDate(3, Date.valueOf(publicacao.getData()));
            statement.setString(4, publicacao.getIdUsuario());

            statement.executeQuery();
            publicacaoDAORedis.salvarPublicacao(publicacao);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Publicacao recuperaPublicacao(String id) {
        return buscaId(id).get();
    }


    public Optional<Publicacao> buscaId(String id) {
        Optional<Publicacao> p = null;
        String query  = "SELECT * FROM publicacao WHERE id = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                p = p.of(
                        new Publicacao(
                                resultSet.getString("id"),
                                resultSet.getString("corpo"),
                                resultSet.getDate("data").toLocalDate(),
                                resultSet.getString("idusuario")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

}
