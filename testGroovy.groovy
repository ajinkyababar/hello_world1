#!/usr/bin/env groovy
node() {

	
	echo "${BRANCH}"
	echo "inside groovy"
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
