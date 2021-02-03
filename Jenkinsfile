node{
    checkout scm
    docker.withRegistry('https://registry.hub.docker.com','dockerHubCredentials') {
        def customImage = docker.build("naomideleon:heroku-testing")
        customImage.push()
    }
}
