#!/usr/bin/env groovy
node() {

	stage('checkout ') {	
     input 'Do you want to continue?'
		echo "${BRANCH}"
		checkout ([
		$class: 'GitSCM',
			branches: [[name: '${BRANCH}']],
		extensions: [				
				[$class: 'CleanCheckout']
		],
		userRemoteConfigs: [[url: 'https://github.com/ajinkyababar/hello_world1.git']]
		])		
	}
}
