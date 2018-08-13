#!/usr/bin/env groovy
node() {

	def branch = env.BRANCH_NAME
	stage('checkout from git-2 ') {		
		checkout ([
		$class: 'GitSCM',
		branches: [[name: '*/master']],
		extensions: [				
				[$class: 'CleanCheckout']
		],
		userRemoteConfigs: [[url: 'https://github.com/ajinkyababar/hello_world1.git']]
		])		
	}
	
	echo " branch"
}
