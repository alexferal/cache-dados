package br.edu.ifpb.bd2.visao;

import br.edu.ifpb.bd2.modelo.Publicacao;
import br.edu.ifpb.bd2.modelo.PublicacaoDAOPgSql;
import br.edu.ifpb.bd2.modelo.PublicacaoDAORedis;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        PublicacaoDAORedis publicacaoDAORedis = new PublicacaoDAORedis();
        PublicacaoDAOPgSql publicacaoDAOPgSql = new PublicacaoDAOPgSql();

        Publicacao p = new Publicacao("123", "public1", LocalDate.of(2019, 06, 16), "543");
        publicacaoDAOPgSql.salvarPublicacao(p);
        System.out.println(publicacaoDAORedis.recuperaPublicacao(p.getId()));
    }
}
