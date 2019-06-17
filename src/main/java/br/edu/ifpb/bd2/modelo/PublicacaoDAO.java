package br.edu.ifpb.bd2.modelo;

public interface PublicacaoDAO {

    void salvarPublicacao(Publicacao publicacao);
    Publicacao recuperaPublicacao(String id);
    default Publicacao recuperaBanco(String id) {
        return null;
    }
}
