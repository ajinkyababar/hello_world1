#!/usr/bin/env groovy
node() {
	stage('checkout from Git') {		
		checkout ([
		$class: 'GitSCM',
		branches: [[name: '*/master']],
		extensions: [				
				[$class: 'CleanCheckout']
		],
		userRemoteConfigs: [[url: 'https://github.com/ajinkyababar/hello_world1.git']]
		])		
	}

	stage('test') {
		sh "echo 'Throw in some tests here'"
		sh "echo 'Throw in some tests here'"
		sh "echo 'Throw in new tests here'"

	}
}