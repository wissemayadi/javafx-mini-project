node{
  stage('SCM Checkout'){
    git 'https://github.com/wissemayadi/javafx-mini-project'
  }
  stage('Compile-Package'){
     def mvnHome= tool name: 'maven', type: 'maven'

    sh "${mvnHome}/bin/mvn package"
  }
}
    
    
    
    
    
    
