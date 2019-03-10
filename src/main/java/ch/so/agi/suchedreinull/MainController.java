package ch.so.agi.suchedreinull;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ParcelRepository parcelRepository;

    @GetMapping("/parcel/{searchTerm}")
    public List<Parcel> getParcelByTokens(@PathVariable String searchTerm) {
        log.info(searchTerm);
                
        //return parcelRepository.findByEgrid(egrid);
        //return parcelRepository.findByEgridContaining(egrid);
        
        return parcelRepository.search(searchTerm);
    }
}
