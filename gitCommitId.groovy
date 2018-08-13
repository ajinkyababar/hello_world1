#!/usr/bin/env groovy
node() {

	def branch = env.BRANCH_NAME
	
	stage('checkout from git-2 ') {		
	def scmVars = checkout ([
		$class: 'GitSCM',
		branches: [[name: '*/master']],
		extensions: [				
				[$class: 'CleanCheckout']
		],
		userRemoteConfigs: [[url: 'https://github.com/ajinkyababar/hello_world1.git']]
		])
		GIT_COMMIT = scmVars.GIT_COMMIT
	}
	print GIT_COMMIT
	
	def scmVars2 = checkout ([
		$class: 'GitSCM',
		branches: [[name: '*/master']],
		extensions: [				
				[$class: 'CleanCheckout']
		],
		userRemoteConfigs: [[url: 'https://github.com/ajinkyababar/new-git-project.git']]
		])
		GIT_COMMIT2 = scmVars2.GIT_COMMIT
	print GIT_COMMIT2
      
}
