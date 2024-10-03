pipeline {
    agent any

    environment {
        // Definir variables de entorno para facilitar el despliegue
        DEPLOY_PATH = "D:/Ucaldas inge/CUARTO SEMESTRE/GESTION DE PROYECTOS/gestion-proyecto/deploy"  // Ruta donde se va a desplegar
        JAR_FILE = "mi-aplicacion.jar"
    }

    stages {
        stage('Clonar Repositorio') {
            steps {
                git 'https://github.com/jalexis10/gestion-de-proyectos.git'
            }
        }
        stage('Compilar y Construir') {
            steps {
                // Compilar el proyecto usando Maven
                sh './mvnw clean package'  // O usa 'mvn clean package' si no usas el wrapper de Maven
            }
        }
        stage('Desplegar Aplicación') {
            steps {
                script {
                    // Crear la carpeta de despliegue si no existe
                    sh "mkdir -p ${DEPLOY_PATH}"

                    // Verificar si la aplicación ya está corriendo y detenerla
                    sh "ps aux | grep ${JAR_FILE} | grep -v grep || true"

                    // Copiar el archivo .jar al directorio de despliegue
                    sh "cp target/${JAR_FILE} ${DEPLOY_PATH}/${JAR_FILE}"

                    // Ejecutar la aplicación en segundo plano con nohup
                    sh "nohup java -jar ${DEPLOY_PATH}/${JAR_FILE} --spring.devtools.restart.enabled=true --spring.devtools.livereload.enabled=true > ${DEPLOY_PATH}/app.log 2>&1 &"
                }
            }
        }
    }

    post {
        success {
            echo 'Despliegue exitoso'
        }
        failure {
            echo 'Error en la construcción o despliegue'
        }
    }
}
