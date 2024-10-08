pipeline {
    agent any

    options {
        timeout(time: 10, unit: 'MINUTES') // Limita el tiempo de ejecución del pipeline a 10 minutos.
    }

    stages {
        stage('Checkout') {
            steps {
                // Clona el repositorio en la rama principal.
                git branch: 'main', url: 'https://github.com/jalexis10/tu-repositorio.git'
            }
        }
        stage('Build') {
            steps {
                // Instala las dependencias y construye el proyecto.
                sh 'npm install && npm run build'
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Despliega la aplicación en el servidor remoto.
                    ssh 'username@your_server', '''
                        cd /var/www/html
                        git pull origin main
                    '''
                }
            }
        }
    }

    post {
        always {
            // Limpia el workspace al final de la ejecución.
            cleanWs(deleteDirs: true, disableDeferredWipeout: true)
        }
        success {
            echo 'Despliegue completado exitosamente.'
        }
        failure {
            echo 'El pipeline ha fallado.'
        }
    }
}
