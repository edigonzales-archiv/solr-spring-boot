package ch.so.agi.suchedreinull;

import java.util.List;

public interface CustomParcelRepository {
    public List<Parcel> search(String searchTerm);
}
