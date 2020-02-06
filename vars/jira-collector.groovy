def call(json){
def jsonString = json
def jsonObj = readJSON text: jsonString

String b=jsonObj.alm.projects.project.project_typeKey
String Key=b.replaceAll("\\[", "").replaceAll("\\]","");
String c=jsonObj.alm.projects.project.project_key 
String Key=c.replaceAll("\\[", "").replaceAll("\\]","");
String d=jsonObj.alm.projects.project.project_key
String Key=d.replaceAll("\\[", "").replaceAll("\\]","");
println(Key)
sh "curl -X GET -i -H  -d  -u rig:digitalrig@123 http://ec2-18-191-16-16.us-east-2.compute.amazonaws.com:8080/rest/api/2/search?jql=project%3D${Key}&fields=key%2Csummary%2Cdescription&maxResults=1000&startAt=0 "
//sh "curl -X GET -i -H  -d  -u rig:digitalrig@123 http://ec2-18-191-16-16.us-east-2.compute.amazonaws.com:8080 /rest/api/2/issue/${issueIdOrKey} " 
sh "curl -X GET -i -H  -d  -u rig:digitalrig@123 http://ec2-18-191-16-16.us-east-2.compute.amazonaws.com:8080/rest/api/2/project/'${Key}' "
sh 'curl -X GET -i -H  -d  -u rig:digitalrig@123 http://ec2-18-191-16-16.us-east-2.compute.amazonaws.com:8080/rest/api/2/project ' 
sh 'curl -X GET -i -H  -d  -u rig:digitalrig@123 http://ec2-18-191-16-16.us-east-2.compute.amazonaws.com:8080/rest/api/2/dashboard '
sh 'curl -X GET -i -H  -d  -u rig:digitalrig@123 http://ec2-18-191-16-16.us-east-2.compute.amazonaws.com:8080/rest/agile/1.0/board '
//sh "curl -X GET -i -H  -d  -u rig:digitalrig@123 http://ec2-18-191-16-16.us-east-2.compute.amazonaws.com:8080/rest/agile/1.0/board/${boardKey} "
sh 'curl -X GET -i -H  -d  -u rig:digitalrig@123 http://ec2-18-191-16-16.us-east-2.compute.amazonaws.com:8080/rest/api/2/workflow '
}
