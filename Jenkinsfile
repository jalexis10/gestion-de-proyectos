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
                // Se usa 'bat' en lugar de 'sh' para ejecutar comandos en Windows.
                bat 'mvn clean install -DskipTests'
            }
        }
        stage('Run') {
            steps {
                // Inicia la aplicación Spring Boot en segundo plano.
                // Se usa 'bat' con 'start /b' para ejecutar en segundo plano en Windows.
                bat 'start /b mvn spring-boot:run'
            }
        }
    }

    post {
        always {
            // Limpia los recursos generados en cada ejecución (opcional).
            cleanWs()
        }
        success {
            echo 'Build y ejecución completadas exitosamente.'
        }
        failure {
            echo 'El pipeline ha fallado.'
        }
    }
}
