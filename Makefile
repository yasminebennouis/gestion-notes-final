# Makefile pour projet Gestion Notes (JavaFX + Maven)

.PHONY: build clean run

build:
	mvn clean package

run:
	mvn javafx:run

clean:
	mvn clean
