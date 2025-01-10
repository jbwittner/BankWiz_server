package fr.bankwiz.server.infrastructure.apirest.controller;

public final class Endpoints {

    private Endpoints() {
        // Private constructor to prevent instantiation
    }

    public static final class Status {

        private Status() {
            // Private constructor to prevent instantiation
        }

        public static final String BASE = "status";
        public static final String PUBLIC = "public";
        public static final String PRIVATE = "private";
        public static final String ADMIN = "admin";
    }

    public static final class User {

        private User() {
            // Private constructor to prevent instantiation
        }

        public static final String BASE = "user";
        public static final String AUTHENTICATE = "authenticate";
    }

    public static final class BankAccount {

        private BankAccount() {
            // Private constructor to prevent instantiation
        }

        public static final String BASE = "bank-account";
    }
}
