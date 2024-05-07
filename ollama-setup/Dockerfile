FROM ollama/ollama
COPY ./ollama /root/.ollama
#COPY ./ollama/models /usr/share/ollama/.ollama/models
EXPOSE 11434
ENTRYPOINT ["/bin/ollama"]
CMD ["serve"]