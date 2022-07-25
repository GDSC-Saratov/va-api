.PHONY: clean build run db persistence gateway

all: help

start: build
	cd src-java && ./gradlew bootRun

build:
	cd src-java && gradle build
	cd src-java && gradle wrapper

db:
	cd db && docker-compose up

stop:
	cd src-java && ./gradlew --stop
	cd db && docker-compose down

clean: stop
	cd src-java && gradle clean
	$(RM) gradle*

help:
	@echo 'Использование:'
	@echo 'make db: поднять docker контейнер с базой данных'
	@echo 'make build: собрать проект'
	@echo 'make start: собрать и запустить проект'
	@echo 'make stop: остановить проект и контейнер с базой данных'
	@echo 'make clean: очистка проекта'
