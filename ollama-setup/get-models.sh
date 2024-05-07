#!/bin/bash

# Define variables
image_name="benaya7/ollama-offline:mistral_nomic"
container_name="ollama-models"
container_path="/volume-data"
local_path="./ollama"

# Pull the Docker image
docker pull $image_name

# Run a container from the image
docker run -d --name $container_name $image_name

# Copy the data from the container to the local folder
docker cp $container_name:$container_path $local_path

# Stop and remove the container
docker rm -f $container_name