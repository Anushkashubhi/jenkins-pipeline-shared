def call(jsondata){
def jsonString = jsondata
//println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)

String a=jsonObj.scm.projects.project.project_name
String projectName=a.replaceAll("\\[", "").replaceAll("\\]","");
String b=jsonObj.scm.projects.project.project_key 
String projectKey=b.replaceAll("\\[", "").replaceAll("\\]","");
env.name = projectName
env.key = projectKey

httpRequest authentication: 'bitbucket_cred', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: """
{
    "key": "${projectKey}",
    "name": "${projectName}",
    "project_description": "demo",
     "public": true
}""", responseHandle: 'NONE', url:"http://18.224.68.30:7990/rest/api/1.0/projects"
  
  }
