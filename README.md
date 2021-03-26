# Simple http performance test of various frameworks, and comparision
 I've tested simple http performance tests, and this is the comparison.

## Target frameworks
* netty 
* armeria
* akka-http
* vertx  
* spring webflux  
* springboot 2.3.9
* springboot 2.3.9 with spring security
* springboot 2.3.9 by kotlin
* graalvm with spring-native
* golang with gin

## Testing background
* Testing load is 10,000 concurrent user.
* The testing tool(gatling) request a millisecond URL. (varying by millisecond)
  > (ex)  1616726889044
* The target server extract the url and response text that is the three times to the url.
  > (ex)  161672688904416167268890441616726889044
    
## Limitation of this test
* It's just a very simple GET request. And doesn't match real situation.
  > (no database, no redis, no message queue, no http-client ...)
* System resource usage was not monitored.

## Test Result
| framework | mean (msec) | counts/sec |
| ---- | ----: | ----: |
| netty | 146 | 13,622 |
| armeria | 229 | 11,599 |
| akka-http | 547 | 9,760 |
| vertx | 114 | 15,802 |
| springboot with webflux | 545 | 10,729 |
| springboot | 1043 | 4,819 |
| springboot with spring security | 1944 | 2,544 |
| springboot with kotlin | 1102 | 4,504 |
| graalvm with spring-native | 1099 | 4,398 |
| golang with gin | 154 | 15,471 |


## Conculusion
First, keep in mind that this test is just responding some text.
In other words, unless we make something like a gateway, this test may not make much sense.

OK, **My Conclusion** is,
> * Golang is the best in cost performance.
> * Non-blocking certainly has better performance than blocking. 
>   * But, what about the hassle and complexity of non-blocking? 
> * There is no performance degradation due to using kotlin.
> * There is about 50% performance degradation by using spring security.
> * Graalvm has a very good startup time, but the throughput is similar. 
 
## executable jar and runtime file
In the executable-outputs directory, There are executable jars and runtime files.

You can execute the jar with **java 11**.

[examples]
```sh
java -jar armeria-fat.jar
```
```sh
./gin-main
```
```sh
./rocklike.test.graalvmtest.graalvmserver
```

## Performance Testing Report
### netty
![](result-reports/netty.png)
### armeria
![](result-reports/armeria.png)
### akka-http
![](result-reports/akka-http.png)
### vertx
![](result-reports/vertx.png)
### springboot with webflux
![](result-reports/springboot-webflux.png)
### springboot
![](result-reports/springboot.png)
### springboot with spring security
![](result-reports/springboot-withSecurity.png)
### springboot with kotlin
![](result-reports/springboot-kotlin.png)
### graalvm with spring-native
![](result-reports/graalvm-springboot.png)
### golang with gin
![](result-reports/golang-gin.png)

