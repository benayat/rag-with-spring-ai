## RAG system demo
This is a demo RAG system, which is basically a QA bot which uses solid data to answer questions, rather than relying solely on it's own LLM knowledge.

#### Architecture
The System is based on the following components:
1. Code - spring boot framework with spring ai.
2. Local models deployment, including chat and embeddings generation: ollama.
3. Vector Database, for storing embeddings and querying them: milvus-db.
All components used are free and open source.

#### Running the system
##### Prerequisites
- a running instance of milvus-db. if it's not local, you need to set up the relevant connection details in the `application.yml` file.
- a running instance of ollama, with the chat and embeddings downloaded pulled, and chat model running.
- you *don't* need to have maven installed, as the project uses the maven wrapper.

##### Running
1. Clone the repository
2. run `./mvnw spring-boot:run` in the root directory of the project.
