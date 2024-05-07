## RAG system demo
This is a demo RAG system, which is basically a QA bot which uses solid data to answer questions, rather than relying solely on it's own LLM knowledge.

#### Architecture
The System is based on the following components:
1. Code - spring boot framework with spring ai.
2. Local models deployment, including chat and embeddings generation: ollama.
3. Vector Database, for storing embeddings and querying them: postgres pgvector.
All components used are free and open source.

#### Running the system
##### Prerequisites
- docker, make sure to login to dockerhub.

##### Running
simply download the file "docker-compose.yml" and run `docker-compose up`.
