package external.GSAPI;

import external.Album;

public interface ExternalServiceToAlbumResolver {
    Album getAlbumFromExternal(String callResponse);
}
