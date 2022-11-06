package boke.boke.repository;

import boke.boke.entity.Blogsarticle;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * es的接口
 */
public interface BlogEsRepository extends ElasticsearchRepository<Blogsarticle,Integer> {
}
