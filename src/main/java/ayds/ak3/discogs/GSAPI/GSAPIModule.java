package ayds.ak3.discogs.GSAPI;

import ayds.ak3.discogs.ExternalAlbumService;

public class GSAPIModule {
    private static GSAPIModule instance;
    private final ExternalAlbumService externalAlbumService;

    private GSAPIModule(){
        externalAlbumService = new GSAPIService(new GSAPIToAlbumResolver());
    }

    public static GSAPIModule getInstance(){
        if (instance == null)
            instance = new GSAPIModule();
        return instance;
    }

    public ExternalAlbumService getExternalService(){
        return externalAlbumService;
    }
}
