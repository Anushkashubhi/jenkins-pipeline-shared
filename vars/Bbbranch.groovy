def call(jsondata){
def jsonString = jsondata
//println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.scm)

String a=jsonObj.scm.projects.project.repositories.repository.repo_name
String repoName=a.replaceAll("\\[", "").replaceAll("\\]","");
String b=jsonObj.scm.projects.project.project_key 
String projectKey=b.replaceAll("\\[", "").replaceAll("\\]","");
String c=jsonObj.scm.projects.project.repositories.repository.branches.startPoint 
String sPoint=c.replaceAll("\\[", "").replaceAll("\\]","");
String d=jsonObj.scm.projects.project.repositories.repository.branches.branch.name 
String branch=d.replaceAll("\\[", "").replaceAll("\\]","");
httpRequest authentication: 'bitbucket_cred', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: """
{
    "name": "dev",
    "startPoint": "refs/heads/master"   
}""", responseHandle: 'NONE', url:"http://18.224.68.30:7990/rest/api/1.0/projects/${projectKey}/repos/${repoName}/branches"
  
  }
