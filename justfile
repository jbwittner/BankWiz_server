DB_PASSWORD := "Bankwiz2024"
DB_USER := "bankwiz_user"
DB_DATABASE := "bankwiz_db"
DB_ROOT_PASSWORD := "RootPassword"
DB_CONTAINER_NAME := "bankwiz_database"

package:
    mvn clean package -Dcheckstyle.skip -DskipTests

install:
    mvn clean install -Dcheckstyle.skip -DskipTests

test:
    mvn clean test -Dcheckstyle.skip

checkstyle:
    mvn checkstyle:checkstyle

spotless:
    mvn spotless:apply

spotless-check:
    mvn spotless:check

start-jar-dev:
    java -jar application/target/application-*.jar --spring.profiles.active=development

restore-table:
    docker exec -i {{DB_CONTAINER_NAME}} sh -c 'psql -U {{DB_USER}} -d {{DB_DATABASE}}' < sql/database.sql

restore-data:
    docker exec -i {{DB_CONTAINER_NAME}} sh -c 'psql -U {{DB_USER}} -d {{DB_DATABASE}}' < sql/data.sql

backup-table:
    docker exec -i {{DB_CONTAINER_NAME}} sh -c "pg_dump --clean --schema-only -U {{DB_USER}} -d {{DB_DATABASE}}" > sql/database.sql
    docker exec -i {{DB_CONTAINER_NAME}} sh -c "pg_dump --schema-only -U {{DB_USER}} -d {{DB_DATABASE}}" > infrastructure/spi-jpa/src/test/resources/sql/init_table.sql

backup-data:
    docker exec -i {{DB_CONTAINER_NAME}} sh -c "pg_dump --data-only -U {{DB_USER}} -d {{DB_DATABASE}}" > sql/data.sql

restore:
    just restore-table && just restore-data

backup:
    just backup-table && just backup-data

docker-build:
    docker build -t bankwiz-server:local -f docker/Dockerfile .

docker-run-local:
    docker compose -p "bankwiz_stack" -f docker/compose.yaml -f docker/compose.app-local.yaml up -d

start:
    docker compose -p "bankwiz_stack" -f docker/compose.yaml up -d

down:
    docker compose -p "bankwiz_stack" -f docker/compose.yaml -f docker/compose.app.yaml down -v

start-app:
    docker compose -p "bankwiz_stack" -f docker/compose.yaml -f docker/compose.app.yaml up -d

down-app:
    docker compose -p "bankwiz_stack" -f docker/compose.yaml -f docker/compose.app.yaml down serverapp

remove-app:
    docker image rm ghcr.io/jbwittner/bankwiz_server:develop-latest

update-app:
    just down-app && just remove-app && just start-app

logs-app:
	docker logs bankwiz_server --follow
