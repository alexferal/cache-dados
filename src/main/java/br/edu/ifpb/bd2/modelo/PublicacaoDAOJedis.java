package br.edu.ifpb.bd2.modelo;

import br.edu.ifpb.bd2.Enumeration.CacheResult;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Optional;

public class PublicacaoDAOJedis implements PublicacaoDAO {

    private Jedis jedis;
    private Gson gson;
    private PublicacaoDAOPgSql publicacaoDAOPgSql;

    public PublicacaoDAOJedis(){
        jedis = new Jedis();
        gson = new Gson();
        publicacaoDAOPgSql = new PublicacaoDAOPgSql();
    }

    @Override
    public void salvarPublicacao(Publicacao publicacao) {
        jedis.set(""+publicacao.getId(), gson.toJson(publicacao), SetParams.setParams().nx().ex(3600));
    }

    @Override
    public Publicacao recuperaPublicacao(String id) {
        Publicacao publicacao = null;

        if (buscaKey(id) == CacheResult.CACHE_MISS) {
            publicacao = recuperaBanco(id);

            if (publicacao != null){
                salvarPublicacao(publicacao);
            }

        } else{
            publicacao = gson.fromJson(jedis.get(id), Publicacao.class);
        }

        return publicacao;
    }

    @Override
    public Publicacao recuperaBanco(String id) {
        return publicacaoDAOPgSql.recuperaBanco(id);
    }


    public CacheResult buscaKey(String key){
        return (jedis.get(key) != null) ? CacheResult.CACHE_HIT : CacheResult.CACHE_MISS;
    }

}
