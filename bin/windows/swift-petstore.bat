set executable=.\modules\swagger-codegen-cli\target\swagger-codegen-cli.jar

If Not Exist %executable% (
  mvn clean package
)

REM set JAVA_OPTS=%JAVA_OPTS% -Xmx1024M
set ags=generate -t modules\swagger-codegne\src\main\resources\swift -i modules\swagger-codegen\src\test\resources\2_0\petstore.json -l swift -o samples\client\petstore\swift\default

java %JAVA_OPTS% -jar %executable% %ags%
