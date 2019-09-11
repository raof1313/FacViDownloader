# FacViDownloader











### Install
add the dependency in your gradle.app

```
dependencies {
	        implementation 'com.github.raof1313:FacViDownloader:-SNAPSHOT'
	}
```

add the repository 

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```



### using 

```
DownloadManager.Request request=new FacViDownloader(facebookVideoLink).getRequest();
.
.
.
downloadManager.enqueue(request);

//after getting the request download it like normal process with download manager 
//open the app folder to read a demo

```



## Author

raof1313

