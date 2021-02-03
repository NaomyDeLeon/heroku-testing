node{
    checkout scm
    docker.withRegistry('https://registry.hub.docker.com','dockerHubCredentials') {
        def customImage = docker.build("naomyDeLeon/heroku-testing")
        customImage.push()
    }
}
