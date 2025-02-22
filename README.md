# seomaniak-test
Ce projet est une application Angular (frontend) et un backend en [Spring Boo]. Il permet de gérer des tâches et des projets.
---

## ⚙️ Installation et Configuration  

### 1️⃣ Back-end (Spring Boot)  
1. Cloner le projet :  
   ```sh
   git clone https://github.com/houssam-bendour/Test-seomaniak.git
   cd Test-seomaniak/backend
2. Installer les dépendances avec Maven :
   ```sh
    mvn clean install
3. Configurer la base de données dans application.properties :  
  
4. Lancer le serveur :
   ```sh
   mvn spring-boot:run

5. Accéder à l'API :
 http://localhost:9090/project

### 2️⃣ Front-end (Ionic) 
1. Installer Ionic CLI si ce n'est pas encore fait  
   ```sh
   npm install -g @ionic/cli
2. Cloner le projet et entrer dans le dossier :
   ```sh
    git clone https://github.com/houssam-bendour/Test-seomaniak.git
    cd Test-seomaniak/frontend
   
3. Installer les dépendances :
   ```sh
   npm install
  
4. Lancer le serveur :
   ```sh
   ionic serve
