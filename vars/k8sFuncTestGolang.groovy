def call(project, domain) {
    //addr = "${project}-${env.BUILD_NUMBER}-${env.BRANCH_NAME}.${domain}"
    //127.0.0.1.nip.io does not work in a container so I had to do this
    //to get it to work locally
    addr = "${project}-${env.BUILD_NUMBER}-${env.BRANCH_NAME}.${project}-build:8080"
    sh "go get -d -v -t"
    sh """ADDRESS=${addr} \
        go test ./... -v \
        --run FunctionalTest"""
}
