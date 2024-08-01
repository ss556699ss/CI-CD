pipeline {
    agent any
    triggers {
        cron('* * * * *') // 每分鐘檢查一次
    }
    stages {
        stage('Check GitHub Issues') {
            steps {
                script {
                    def response = httpRequest(
                        url: 'https://api.github.com/repos/ss556699ss/CI-CD/issues',
                        customHeaders: [
                            [name: 'Accept', value: 'application/vnd.github+json'],
                            [name: 'Authorization', value: 'Bearer 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'],
                            [name: 'X-GitHub-Api-Version', value: '2024-08-01']
                        ]
                    )
                    def issues = new groovy.json.JsonSlurper().parseText(response.content)
                    issues.each { issue ->
                        echo "Issue #${issue.number}: ${issue.title}"
                    }
                }
            }
        }
    }
}

