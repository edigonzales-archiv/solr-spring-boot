package ch.so.agi.suchedreinull;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "parcel")
public class Parcel {
    @Id
    @Indexed(name = "id", type = "string")
    private String id;
    
    @Indexed(name = "egrid", type = "string")
    private String egrid;

 
    @Indexed(name = "search_text", type = "string")
    private String searchText;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getEgrid() {
        return egrid;
    }


    public void setEgrid(String egrid) {
        this.egrid = egrid;
    }


    public String getSearchText() {
        return searchText;
    }


    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
