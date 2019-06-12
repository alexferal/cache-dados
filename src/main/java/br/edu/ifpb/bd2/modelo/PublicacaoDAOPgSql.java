package br.edu.ifpb.bd2.modelo;

import java.util.List;

public class PublicacaoDAOPgSql implements PublicacaoDAO {
    @Override
    public boolean salvarPublicacao(Publicacao publicacao) {
        return false;
    }

    @Override
    public List<Publicacao> recuperarPublicacoes() {
        return null;
    }
}
