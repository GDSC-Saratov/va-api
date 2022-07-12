.PHONY: clean build run db persistence gateway

NPROCS = $(shell sysctl hw.ncpu  | grep -o '[0-9]\+')
MAKEFLAGS += -j$(NPROCS)

run: db persistence gateway
	
build: 
	cd src-java && gradle build
	
db:
	cd db && docker-compose up

persistence:
	cd src-java/persistence && ./gradlew bootRun
	
gateway:
	cd src-java/gateway && ./gradlew bootRun
	
clean:
	cd src-java && gradle clean