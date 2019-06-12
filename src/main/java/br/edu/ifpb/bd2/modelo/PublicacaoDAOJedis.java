package br.edu.ifpb.bd2.modelo;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.List;

public class PublicacaoDAOJedis implements PublicacaoDAO {

    private Jedis jedis;
    private Gson gson;

    public PublicacaoDAOJedis(){
        jedis = new Jedis();
        gson = new Gson();
    }

    @Override
    public boolean salvarPublicacao(Publicacao publicacao) {
        return jedis.set(""+publicacao.getId(), gson.toJson(publicacao), SetParams.setParams().nx()) != null;
    }

    @Override
    public List<Publicacao> recuperarPublicacoes() {
        return null;
    }
}
