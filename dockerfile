# 使用 OpenJDK 11 作為基本映像
FROM openjdk:11-jdk-slim

# 將工作目錄設置為 /app
WORKDIR /app

# 複製 Maven 打包後的 JAR 檔案到容器中的 /app 目錄
COPY target/lesson-3-4-0.0.1-SNAPSHOT.jar /app/lesson-3-4-0.0.1-SNAPSHOT.jar

# 暴露應用程序運行的端口（如果需要）
EXPOSE 8081

# 執行您的應用程序
CMD ["java", "-jar", "test.jar"]
