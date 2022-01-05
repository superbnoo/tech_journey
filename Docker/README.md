# Learning Docker

1. Create Dockerfile
2. Build the image
```
docker image build taymotxao/gsd:first-ctr .
taymotxao: docker hub id
gsd: repo
first-ctr: tag
```
3. List images
```
docker image ls
```
4. Push image to docker hub
```
docker image push taymotxao/gsd:first-ctr
```
5. Test: 1. Delete local image
```
docker image rm taymotxao/gsd:first-ctr
```
6. Test: 2. Run image in containerized app
```
docker container run -d --name web -p 8000:8080 \             
taymotxao/gsd:first-ctr
Note:
-d: run detached
--name web: container app name
-p 8000:8080: port mapping from 8080 (nodejs port) to 8000 (local docker desktop port)
```
7. Show the running container app
```
docker container ls
```
