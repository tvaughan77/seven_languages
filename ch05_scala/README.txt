A little notepad of the commands I used to set this up:

* Git:
    Added a new repo in github
    touch README.txt
    vi README.txt 
    git add README.txt 
    git commit -m 'Adding readme and skelton project'
    git remote add origin git@github.com:tvaughan77/seven_languages.git
    git push -u origin master    




* Mvn/POM:

mvn scala archetype:
    mvn org.apache.maven.plugins:maven-archetype-plugin:1.0-alpha-7:create \
        -DarchetypeGroupId=org.scala-tools.archetypes \
        -DarchetypeArtifactId=scala-archetype-simple \
        -DarchetypeVersion=1.1 \
        -DremoteRepositories=http://scala-tools.org/repo-releases \
        -DgroupId=com.opower \
        -DartifactId=chapter04-scala

Then futzed around with a standard multi-module setup with container pom and parent pom
