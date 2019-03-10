# solr-spring-boot

```
vagrant up
vagrant ssh
sudo su postgres
psql -d postgres -f globals_geodb.rootso.org.dmp

(alter Dump v10)
dropdb pub
createdb pub
sudo -u postgres pg_restore --role=postgres --exit-on-error -d pub pub_geodb.rootso.org.dmp
```






```
./solr start

./solr create -c parcel

(
./solr delete -c parcel
)

curl -X POST "http://localhost:8983/solr/parcel/schema?wt=json" -d '{"add-field": {stored: "true", indexed: "true", name: "egrid", type: "string"}}'
curl -X POST "http://localhost:8983/solr/parcel/schema?wt=json" -d '{"add-field": {stored: "true", indexed: "true", name: "nbident", type: "string"}}'
curl -X POST "http://localhost:8983/solr/parcel/schema?wt=json" -d '{"add-field": {stored: "true", indexed: "true", name: "nummer", type: "string"}}'
curl -X POST "http://localhost:8983/solr/parcel/schema?wt=json" -d '{"add-field": {stored: "true", indexed: "true", name: "nummer_sort", type: "string"}}'
curl -X POST "http://localhost:8983/solr/parcel/schema?wt=json" -d '{"add-field": {stored: "true", indexed: "true", name: "art_txt", type: "string"}}'
curl -X POST "http://localhost:8983/solr/parcel/schema?wt=json" -d '{"add-field": {stored: "true", indexed: "true", name: "gemeindename", type: "string"}}'
curl -X POST "http://localhost:8983/solr/parcel/schema?wt=json" -d '{"add-field": {stored: "true", indexed: "true", name: "grundbuchkreis", type: "string"}}'
curl -X POST "http://localhost:8983/solr/parcel/schema?wt=json" -d '{"add-field": {stored: "true", indexed: "false", name: "display_text", type: "string"}}'
curl -X POST "http://localhost:8983/solr/parcel/schema?wt=json" -d '{"add-field": {stored: "true", indexed: "true", name: "search_text", type: "string"}}'


```


Datenimport:
```
cp Downloads/postgresql-42.2.5.jar ~/apps/solr-7.7.1/contrib/dataimporthandler-extras/lib/

cd ~/apps/solr-7.7.1/server/solr/parcel/conf
```

solrconfig.xml:
```
  <luceneMatchVersion>7.7.1</luceneMatchVersion>
  <lib dir="${solr.install.dir:../../../..}/dist/" regex="solr-dataimporthandler-.*\.jar" />
  <lib dir="${solr.install.dir:../../../..}/contrib/dataimporthandler-extras/lib" regex=".*\.jar" />
```

und

```
  <requestHandler name="/dataimport" class="org.apache.solr.handler.dataimport.DataImportHandler">
   <lst name="defaults">
      <str name="config">data-config.xml</str>
   </lst>
  </requestHandler>
```


Query:
```
http://localhost:8080/search/parcel/CH21
http://localhost:8080/search/parcel/Däni 315 Liegen

```

