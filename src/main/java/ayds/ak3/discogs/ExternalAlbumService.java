package ayds.ak3.discogs;

import java.io.IOException;

public interface ExternalAlbumService {
    Album getAlbum(ExternalSong song) throws IOException;
}
