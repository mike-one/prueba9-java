# Cuenca-Java


## Install

#Gradle

1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:

  ```
  allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
 ```
2. Add the dependency

```
dependencies {
	        implementation 'com.github.cuenca-mx:cuenca-java:v1.0'
	}
```
3. Load the changes made in the maven "Load gradle changes" file
4. Import the package to your project with
 ```
  import com.cuenca.CuencaClient;
```

#Maven

1. Add the JitPack repository to your build file
```
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
2. Add the dependency
```
<dependency>
	    <groupId>com.github.cuenca-mx</groupId>
	    <artifactId>cuenca-java</artifactId>
	    <version>v1.0</version>
	</dependency>
```
3. Load the changes made in the maven "Load maven changes" file
4. Import the package to your project with
 ```
  import com.cuenca.CuencaClient;
```

Available methods
1. GET
 ```
Params: 
 endpoint: Endpoint URL
body (Optional): Request body in JSON format
Return:
Returns an HttpResponse in string format.
public HttpResponse<String> get(String endpoint)
```

2. POST
```
Params:
endpoint: Endpoint URL
body: Request body in JSON format
Return:
Returns an HttpResponse in string format.
public HttpResponse<String> post(String endpoint, String body)
```

4. PATCH
```
Params:
endpoint: Endpoint URL
body: Request body in JSON format
Return:
Returns an HttpResponse in string format.
public HttpResponse<String> patch(String endpoint, String body)
```

6. DELETE
```
Params:
endpoint:  Endpoint URL
body (Optional): Request body in JSON format
Retorno:
Returns an HttpResponse in string format.
public HttpResponse<String> delete(String endpoint)
```
