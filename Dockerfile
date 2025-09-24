# Use Maven with JDK 17
FROM maven:3.8.8-eclipse-temurin-17

# Set working directory inside container
WORKDIR /app

# Copy project files into container
COPY . .

# Install Chrome & ChromeDriver (for Selenium)
RUN apt-get update && apt-get install -y wget unzip xvfb \
    && wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
    && dpkg -i google-chrome-stable_current_amd64.deb || apt-get -f install -y \
    && wget -q https://chromedriver.storage.googleapis.com/117.0.5938.62/chromedriver_linux64.zip \
    && unzip chromedriver_linux64.zip -d /usr/local/bin/ \
    && rm -rf /var/lib/apt/lists/*

# Run tests
CMD ["mvn", "clean", "test"]
