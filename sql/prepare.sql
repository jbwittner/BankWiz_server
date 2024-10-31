DROP
    USER IF EXISTS bankwiz_user@'localhost';

DROP
    USER IF EXISTS bankwiz_user@'%';

DROP
    DATABASE IF EXISTS bankwiz_db;

CREATE
    DATABASE bankwiz_db;

CREATE
    USER bankwiz_user@'localhost' IDENTIFIED BY 'Bankwiz2024';

CREATE
    USER bankwiz_user@'%' IDENTIFIED BY 'Bankwiz2024';

GRANT ALL PRIVILEGES ON
bankwiz_db.* TO bankwiz_user@'localhost';

GRANT ALL PRIVILEGES ON
bankwiz_db.* TO bankwiz_user@'%';

FLUSH PRIVILEGES;