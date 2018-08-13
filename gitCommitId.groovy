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
	
	sh 'git name-rev --name-only HEAD > GIT_BRANCH'
	echo "env.GIT_COMMIT"
	echo ""
	print 'env.GIT_COMMIT'
	print "GIT_COMMIT"
	echo "branch"
	sh 'git rev-parse HEAD > commit'
      def commit = readFile('commit').trim()
	echo 'commit'
}
