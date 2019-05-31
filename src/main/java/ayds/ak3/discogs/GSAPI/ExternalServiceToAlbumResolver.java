package ayds.ak3.discogs.GSAPI;

import ayds.ak3.discogs.Album;

public interface ExternalServiceToAlbumResolver {
    Album getAlbumFromExternal(String callResponse);
}
