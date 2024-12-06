-- Assuming you have a list of tables to clean up

-- Disable foreign key checks
SET session_replication_role = 'replica';

-- Clean up tables
TRUNCATE TABLE USER_ACCOUNTS;

-- Enable foreign key checks
SET session_replication_role = 'origin';
