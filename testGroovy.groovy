#!/usr/bin/env groovy
node() {

	 def BSAConnectorBuildJob = 'bsaBuild'
	 def BSAConnectorPipelineBuildNumber = "${env.BUILD_NUMBER}"
	stage('checkout from gitHub') {		
		checkout ([
		$class: 'GitSCM',
		branches: [[name: '*/master']],
		extensions: [				
				[$class: 'CleanCheckout']
		],
		userRemoteConfigs: [[url: 'https://github.com/ajinkyababar/hello_world1.git']]
		])		
	}
	
	
	stage('Build Codebase') {
    build_bsa_connector = build job: "${BSAConnectorBuildJob}",
    parameters: [
        string(name: 'CONNECTOR_BUILD_NUMBER', value: "${BSAConnectorPipelineBuildNumber}"),
	     string(name: 'GitBranch', value: "${GitBranch}")
    ]
    
  }
}
