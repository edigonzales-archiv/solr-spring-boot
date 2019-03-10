package ch.so.agi.suchedreinull;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

//public interface ParcelRepository extends SolrCrudRepository<Parcel, String> {
//    public Parcel findByEgrid(String egrid);
//    
//    public List<Parcel> findByEgridContaining(String egrid);
//}

public interface ParcelRepository extends CustomParcelRepository, SolrCrudRepository<Parcel, String> {
    
}