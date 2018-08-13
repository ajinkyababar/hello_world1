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
		env.GIT_COMMIT = scmVars.GIT_COMMIT
	}
	
	echo "env.GIT_COMMIT"
	echo "branch"
	sh 'echo $BRANCH_NAME'
	git ls-remote
}
