-- Désactiver les contraintes de clé étrangère temporairement
SET session_replication_role = 'replica';

-- Vider les tables en cascade
TRUNCATE TABLE BANK_ACCOUNTS CASCADE;
TRUNCATE TABLE CURRENCIES CASCADE;
TRUNCATE TABLE USER_ACCOUNTS CASCADE;

-- Réactiver les contraintes
SET session_replication_role = 'origin';
