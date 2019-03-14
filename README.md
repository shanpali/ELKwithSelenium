Pre-requisites : 
**Docker should be up and running on localhost**



# ELKwithSelenium
Sample code to implement ELK with selenium/API test framework

Elasticsearch:

ElasticSearch is basically a document storage and a Search Engine which exposes REST API for storing and retrieving results based on our query. To setup Elasticsearch, use docker or check the installation page on the Elasticsearch site for the instructions for your OS.

docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:6.2.2

Kibana:

Kibana is a front-end application for Elasticsearch. It is basically a data visualization tool for your elasticsearch data.To setup kibana using docker,

docker run -p 5601:5601 -e ELASTICSEARCH_URL=http://[IP where elasticsearch is running]:9200 docker.elastic.co/kibana/kibana:6.2.2


to launch kibana dashboard : http://localhost:5601
