package com.example.factory;

public enum MemoryType {
    INMEMORY, MYSQL, GOOGLE_DRIVE, UNKNOWN;

    public static MemoryType getMemoryType(String memoryTypeName) {
        memoryTypeName = memoryTypeName.toUpperCase().trim();
        MemoryType memoryType;
        switch (memoryTypeName) {
            case "INMEMORY":
                memoryType = MemoryType.INMEMORY;
                break;
            case "MYSQL":
                memoryType = MemoryType.MYSQL;
                break;
            case "GOOGLE_DRIVE":
                memoryType = MemoryType.GOOGLE_DRIVE;
                break;
            default:
                memoryType = MemoryType.UNKNOWN;
        }
        return memoryType;
    }
}
