package fr.bankwiz.server.domain.tools;

import java.util.UUID;

import com.fasterxml.uuid.Generators;

public final class UUIDGenerator {

    private UUIDGenerator() {
        // Private constructor to prevent instantiation
    }

    public static UUID generateUUID() {
        // Using time-based epoch generator to generate UUID (version 7)
        return Generators.timeBasedGenerator().generate();
    }
}
