# Use an official Ubuntu as the base image
FROM ubuntu:latest

# Install basic command-line tools
RUN apt-get update && apt-get install -y \
    curl \
    git \
    unzip \
    vim \
    build-essential \
    software-properties-common \
    && rm -rf /var/lib/apt/lists/*

# Install Java (OpenJDK 11)
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get clean;

# Set environment variables for Java
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# Set default command to bash
CMD ["bash"]
