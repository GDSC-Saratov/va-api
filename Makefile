.PHONY: clean build run db persistence gateway

NPROCS = $(shell sysctl hw.ncpu  | grep -o '[0-9]\+')
MAKEFLAGS += -j$(NPROCS)

start: db run

run:
	cd src-java && ./gradlew bootRun
	
	
build: 
	cd src-java && gradle build
	
db:
	cd db && docker-compose up
	
clean:
	cd src-java && gradle clean