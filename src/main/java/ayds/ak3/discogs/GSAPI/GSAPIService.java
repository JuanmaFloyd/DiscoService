package ayds.ak3.discogs.GSAPI;

import java.io.IOException;
import ayds.ak3.discogs.Album;
import ayds.ak3.discogs.ExternalAlbumService;
import ayds.ak3.discogs.ExternalSong;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

class GSAPIService implements ExternalAlbumService {
    private final ExternalServiceToAlbumResolver spotifyToAlbumResolver;

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.discogs.com/database/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

    private final DiscoGSAPI discoGSAPI = retrofit.create(DiscoGSAPI.class);

    public GSAPIService(ExternalServiceToAlbumResolver spotifyToAlbumResolver){
        this.spotifyToAlbumResolver = spotifyToAlbumResolver;
    }

    @Override
    public Album getAlbum(ExternalSong song) throws IOException {
        Response<String> callResponse = getResponse(song);
        return spotifyToAlbumResolver.getAlbumFromExternal(callResponse.body());
    }

    private Response<String> getResponse(ExternalSong song) throws IOException {
            return discoGSAPI.getAlbumInfo(song.getAlbumName(), song.getArtistName()).execute();
    }
}
