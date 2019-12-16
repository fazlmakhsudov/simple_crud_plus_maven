package com.example.util;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class keeps basic paths
 */
public class GoogleDrivePath {
    private static final String APPLICATION_NAME = "Google Drive API, simple java application of Fazliddin";

    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    // Directory for user files
    private static final java.io.File DATA_FOLDER
            = new java.io.File(System.getProperty("program"), "src/main/resources/data");
    private static final String SOURCE_FILE_NAME = "google_repository.xls";
    private static final java.io.File SOURCE_FILE
            = new java.io.File(System.getProperty("program"), DATA_FOLDER.getPath() + "/" + SOURCE_FILE_NAME);
    //Directory for working folder in Google
    private static final String WORKING_FOLDER_NAME = "google_api";
    // Directory to store user credentials for this application.
    private static final java.io.File CREDENTIALS_FOLDER //
            = new java.io.File(System.getProperty("program"), "src/main/resources/credentials");

    private static final String CLIENT_SECRET_FILE_NAME = "client_secret.json";

    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);

    // Global instance of the {@link FileDataStoreFactory}.
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    // Global instance of the HTTP transport.
    private static HttpTransport HTTP_TRANSPORT;

    private static Drive _driveService;


    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(CREDENTIALS_FOLDER);
            if (!CREDENTIALS_FOLDER.exists()) {
                CREDENTIALS_FOLDER.mkdirs();

                System.out.println("Created Folder: " + CREDENTIALS_FOLDER.getAbsolutePath());
                System.out.println("Copy file " + CLIENT_SECRET_FILE_NAME + " into folder above.. and rerun this class!!");
            }
            if (!DATA_FOLDER.exists()) {
                DATA_FOLDER.mkdirs();
                XlsHandler.setXlsSheet(new ArrayList<>());
                XlsHandler.writeXlsOutputFile("demo", SOURCE_FILE, true);
                System.out.println("Created Folder: " + DATA_FOLDER.getAbsolutePath());
                System.out.println("Created File: " + SOURCE_FILE.getAbsolutePath());
            }
            if (!SOURCE_FILE.exists()) {
                XlsHandler.setXlsSheet(new ArrayList<>());
                XlsHandler.writeXlsOutputFile("demo", SOURCE_FILE, true);
                System.out.println("Created File: " + SOURCE_FILE.getAbsolutePath());
            }
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    public static String getApplicationName() {
        return APPLICATION_NAME;
    }

    public static JsonFactory getJsonFactory() {
        return JSON_FACTORY;
    }

    public static File getCredentialsFolder() {
        return CREDENTIALS_FOLDER;
    }

    public static String getClientSecretFileName() {
        return CLIENT_SECRET_FILE_NAME;
    }

    public static List<String> getSCOPES() {
        return SCOPES;
    }

    public static FileDataStoreFactory getDataStoreFactory() {
        return DATA_STORE_FACTORY;
    }

    public static HttpTransport getHttpTransport() {
        return HTTP_TRANSPORT;
    }

    public static String getWorkingFolderName() {
        return WORKING_FOLDER_NAME;
    }

    public static String getSourceFileName() {
        return SOURCE_FILE_NAME;
    }

    public static File getSourceFile() {
        return SOURCE_FILE;
    }

    public static File getDataFolder() {
        return DATA_FOLDER;
    }

    public static Drive get_driveService() {
        return _driveService;
    }

    public static void set_driveService(Drive _driveService) {
        GoogleDrivePath._driveService = _driveService;
    }

    public static void main(String[] args) {

    }
}
