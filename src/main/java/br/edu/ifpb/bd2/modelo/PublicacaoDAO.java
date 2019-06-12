package br.edu.ifpb.bd2.modelo;

import java.util.List;

public interface PublicacaoDAO {

    boolean salvarPublicacao(Publicacao publicacao);
    List<Publicacao> recuperarPublicacoes();
}
