pipeline {
    agent any

    environment {
        DEPLOY_PATH = "D:/Ucaldas inge/CUARTO SEMESTRE/GESTION DE PROYECTOS/gestion-proyecto"
        JAR_FILE = "gestion-proyectos.jar"  // Asegúrate de que coincida con el nombre del .jar generado
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
                    sh "mkdir -p ${DEPLOY_PATH}"
                    sh "cp target/${JAR_FILE} ${DEPLOY_PATH}/${JAR_FILE}"
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
