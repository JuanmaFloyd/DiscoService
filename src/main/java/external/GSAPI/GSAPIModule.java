package external.GSAPI;

import external.ExternalAlbumService;

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
