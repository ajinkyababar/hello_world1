#!/usr/bin/env groovy
node() {

	stage('checkout ') {	
     input 'Do you want to continue?'	
		checkout ([
		$class: 'GitSCM',
		branches: [[name: '*/master']],
		extensions: [				
				[$class: 'CleanCheckout']
		],
		userRemoteConfigs: [[url: 'https://github.com/ajinkyababar/hello_world1.git']]
		])		
	}
}