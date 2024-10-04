pipeline {
    agent any

    environment {
        DEPLOY_PATH = "D:/Ucaldas inge/CUARTO SEMESTRE/GESTION DE PROYECTOS/gestion-proyecto"
        WAR_FILE = "gestion-de-proyectos-0.0.1-SNAPSHOT.war"  // Asegúrate de que coincida con el nombre del .war generado
    }

    stages {
        stage('Clonar Repositorio') {
            steps {
                git 'https://github.com/jalexis10/gestion-de-proyectos.git'
            }
        }

        stage('Compilar y Construir') {
            steps {
                sh './mvnw clean package'  // O usa 'mvn clean package'
            }
        }

        stage('Desplegar y Actualizar Aplicación') {
            steps {
                script {
                    sh "mkdir -p ${DEPLOY_PATH}"  // Crear el directorio si no existe
                    // Copiar el archivo .war al directorio de despliegue
                    sh "cp target/${WAR_FILE} ${DEPLOY_PATH}/${WAR_FILE}"
                    // Aquí puedes incluir la lógica para desplegar en un servidor (ej. Tomcat)
                    // Por ejemplo:
                    sh "cp ${DEPLOY_PATH}/${WAR_FILE} $TOMCAT_HOME/webapps/"
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
