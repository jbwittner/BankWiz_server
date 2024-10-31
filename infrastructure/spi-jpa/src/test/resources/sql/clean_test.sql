-- Assuming you have a list of tables to clean up

SET FOREIGN_KEY_CHECKS = 0; -- Disable foreign key checks

-- Clean up tables
TRUNCATE TABLE USER_ACCOUNTS;

SET FOREIGN_KEY_CHECKS = 1; -- Enable foreign key checks