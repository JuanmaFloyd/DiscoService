# DiscoService

Modulo que implementa una API para usar el servicio de busqueda de Discogs.com en Android. Para la catedra de Arquitectura y Diseño de Sistemas - 2019.

## Instalacion

Para poder usar este modulo debe ser agregado como submodulo del proyecto base, para esto se deben ejecutar los siguientes comandos sobre git en el repo base:

```
git submodule add https://github.com/JuanmaFloyd/DiscoService path/en/el/que/se/quiere/clonar
```

Luego se clona el submodulo:

```
git submodule update --init --recursive
```

## Uso

Para usar el modulo se debe obtener la instancia ExternalAlbumService a traves del modulo ExternalAlbumModule con el metodo getExternalService().

```
ExternalAlbumModule externalAlbumModule = ExternalAlbumModule.getInstance();
ExternalAlbumService externalAlbumServiceget = externalAlbumModule.getExternalService();
```

Una vez obtenido este servicio se puede invocar el metodo getAlbum al cual se le debe pasar como parametro la cancion (de tipo ExternalSong) y nos retornara la representacion del album de este servicio.

```
Album album = externalAlbumService.getAlbum(externalSong);
```

ExternalSong es un objeto que contiene el nombre de la cancion (songName), el nombre del artista (artistName), el nombre del album (albumName) 

```
ExternalSong (var songName:String?, var artistName:String?, var albumName:String?, var url:String?)
```


