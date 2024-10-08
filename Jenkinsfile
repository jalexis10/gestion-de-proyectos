pipeline {
    agent any

    options {
        timeout(time: 10, unit: 'MINUTES') // Limita el tiempo de ejecución del pipeline a 10 minutos.
    }

    environment {
        MAVEN_OPTS = '-Xmx1024m' // Configura opciones de Maven, como memoria máxima.
    }

    stages {
        stage('Checkout') {
            steps {
                // Descarga el código fuente del repositorio.
                git branch: 'main', url: 'https://github.com/jalexis10/gestion-de-proyectos.git'
            }
        }
        stage('Build') {
            steps {
                // Realiza la limpieza y construcción del proyecto con Maven.
                bat 'mvn clean install -DskipTests'
            }
        }
        stage('Run') {
            steps {
                // Inicia la aplicación Spring Boot.
                bat 'mvn spring-boot:run'
            }
        }
    }

    post {
        always {
            // Limpia el workspace al final de la ejecución.
            cleanWs(deleteDirs: true, disableDeferredWipeout: true)
        }
        success {
            echo 'Build y ejecución completadas exitosamente.'
        }
        failure {
            echo 'El pipeline ha fallado.'
        }
    }
}
