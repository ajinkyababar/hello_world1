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
    stage ('Build') {
           git 'https://github.com/ajinkyababar/hello_world1.git'
           step([$class: 'LastChangesPublisher', since:'PREVIOUS_REVISION',specificRevision: '', format: 'LINE', matchWordsThreshold: '0.25', matching: 'NONE', matchingMaxComparisons: '1000', showFiles: true, synchronisedScroll: true])

      }
}