package ch.so.agi.suchedreinull;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ParcelRepositoryImpl implements CustomParcelRepository {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SolrTemplate solrTemplate;
    
    @Override
    public List<Parcel> search(String searchTerm) {
        String[] words = searchTerm.split(" ");
              
        Criteria conditions = createSearchConditions(words);
        SimpleQuery search = new SimpleQuery(conditions);
        search.setRows(50);

        Page results = solrTemplate.query("parcel", search, Parcel.class);//.queryForPage("parcel", search, Parcel.class);
        return results.getContent();
    }

    private Criteria createSearchConditions(String[] words) {
        Criteria conditions = null;
 
        for (String word: words) {
            log.info("search token: " + word); 
            if (conditions == null) {
                conditions = new Criteria("search_text").contains(word);
            }
            else {
                conditions = conditions.and(new Criteria("search_text").contains(word));
            }
        }
        
        return conditions;
    }
}
