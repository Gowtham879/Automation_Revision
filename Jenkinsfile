pipeline{
	agent any
	stages {
		stage('Compile stage'){
			steps{
				bat 'mvn -B compile'
				}
			}
			stage('Test stage'){
				steps{
					bat 'mvn -B clean install'
					}
					 post {
                                    // If Maven was able to run the tests, even if some of the test
                                    // failed, record the test results and archive the jar file.
                                    success { allure([
                                        includeProperties: false,
                                        jdk: '',
                                        properties: [],
                                        reportBuildPolicy: 'ALWAYS',
                                        results: [[path: 'target/allure-results']]
                                    ])
                                }
                             }
			}
			stage('Cucumber Report'){
				steps{
					    cucumber buildStatus: "UNSTABLE",
						fileIncludePattern: "**/cucumber.json",
						jsonReportDirectory: 'target'
						}
			}
		}
}