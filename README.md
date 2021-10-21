# testcontainers-issue-4591
minimal code to test that 1.16.1 is not working as 1.16.0 did


when used with Docker daemon running on remote server `my.docker.host` and following settings:
```
export DOCKER_HOST=tcp://localhost:2375    
export TESTCONTAINERS_HOST_OVERRIDE=my.docker.host  
```

remote docker daemon is tunneled to `localhost:2375` via `ssh -L 127.0.0.1:2375:/var/run/docker.sock my.docker.host`  

Run `./mvnw clean test` to check if it runs, then change `testcontainers.version` in `pom.xml` to 1.16.1 and rerun it.  
It fails.  
Well, at least on my machine ;) 
