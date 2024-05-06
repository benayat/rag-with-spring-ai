#### 0.0.1-SNAPSHOT
- Initial commit
- Basic project structure and code.
- set up milvus-db and ollama as dependencies.
- Added chat and embedding controllers for POC. 

#### 1.0.0-SNAPSHOT
- Added basic RAG system functionality.
- Removed redundant embedding and chat controllers. 
- Encapsulated all Vectordb operations in a repository.
- cleaned application.yml file from constants, and added env vars for customization.
- todo: create better reader to much all types of documents and paragraphs. 

#### 1.0.0
- changed to Postgres DB for simplicity, and added relevant definitions.
- changed vectorStore chatClient to generic\interface types to avoid coupling.

#### 1.0.1
- set up docker-compose for running the system.