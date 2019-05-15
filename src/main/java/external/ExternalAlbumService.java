package external;

import java.io.IOException;

public interface ExternalAlbumService {
    Album getAlbum(ExternalSong song) throws IOException;
}
