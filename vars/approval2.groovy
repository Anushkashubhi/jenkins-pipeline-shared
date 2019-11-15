def call(String msg = 'APPROVAL1') {
echo "${msg}"
                      script{
                         emailext mimeType: 'text/html',
                 subject: "[Jenkins]${currentBuild.fullDisplayName}",
                 to: "revathims1998@gmail.com",
                 body: '''<a href="http://3.133.86.107:8080/">click to approve</a>'''

        def userInput = input id: 'userInput',
                              message: 'Let\'s promote?', 
                              submitterParameter: 'submitter',
                              submitter: 'Abhishek',
                              parameters: [
                                [$class: 'TextParameterDefinition', defaultValue: 'sit', description: 'Environment', name: 'env'],
                                [$class: 'TextParameterDefinition', defaultValue: 'k8s', description: 'Target', name: 'target']]

        echo ("Env: "+userInput['env'])
        echo ("Target: "+userInput['target'])
        echo ("submitted by: "+userInput['submitter'])
                      }
                      }
