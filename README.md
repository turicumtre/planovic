# What is it?
Calendar app test project to play with docker, spring boot and java 21 

# Set up server (Ubuntu)
One-time configuration
```
mkdir /datadrive
mkdir /datadrive/db
cd /datadrive
sudo apt update
apt install docker.io
install docker compose as described here: https://docs.docker.com/compose/install/linux/#install-the-plugin-manually
ssh-keygen -t ed25519 -C "planovic-server"
cat /root/.ssh/id_ed25519.pub // add to Github
git clone git@github.com:turicumtre/planovic.git
chmod -R 777 /datadrive
nano ~/.bashrc
export SPRING_PROFILES_ACTIVE=prod
```
# Deploy (Ubuntu)

```
cd /datadrive/planovic
git pull
docker compose up -d
```
# Dev environment (Windows)
install and start MongoDB
set environment variable `SPRING_PROFILES_ACTIVE` to `dev`
Run application in IntelliJ

# Test running app
Open [localhost:8080](localhost:8080)

Add something to db
```
curl -X POST http://localhost:8080/api/entry/create \
  -H "Content-Type: application/json" \
  -d '{"name":"Hello World", "year":2024, "month":12, "day":3}'
```

check if it was added
```
 curl http://localhost:8080/api/entry/allOfYear/2024
```