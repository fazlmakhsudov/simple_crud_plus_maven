package com.example.util;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class provides access to Google drive of certain google account,
 * provides methods to process data
 */
public class GoogleDriveUtil {

    /**
     * @return Credential
     * @throws IOException
     */
    public static Credential getCredentials() throws IOException {

        java.io.File clientSecretFilePath = new java.io.File(GoogleDrivePath.getCredentialsFolder(), GoogleDrivePath.getClientSecretFileName());

        if (!clientSecretFilePath.exists()) {
            throw new FileNotFoundException("Please copy " + GoogleDrivePath.getClientSecretFileName() //
                    + " to folder: " + GoogleDrivePath.getCredentialsFolder().getAbsolutePath());
        }

        InputStream in = new FileInputStream(clientSecretFilePath);

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(GoogleDrivePath.getJsonFactory(), new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(GoogleDrivePath.getHttpTransport(), GoogleDrivePath.getJsonFactory(),
                clientSecrets, GoogleDrivePath.getSCOPES()).setDataStoreFactory(GoogleDrivePath.getDataStoreFactory()).setAccessType("offline").build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");

        return credential;
    }

    /**
     * Class provides trusted channel to google drive
     *
     * @return Drive object
     * @throws IOException
     */
    public static Drive getDriveService() throws IOException {
        if (GoogleDrivePath.get_driveService() != null) {
            return GoogleDrivePath.get_driveService();
        }
        Credential credential = getCredentials();
        //
        GoogleDrivePath.set_driveService(new Drive.Builder(GoogleDrivePath.getHttpTransport(), GoogleDrivePath.getJsonFactory(), credential) //
                .setApplicationName(GoogleDrivePath.getApplicationName()).build());
        return GoogleDrivePath.get_driveService();
    }

    /**
     * Class make list of file in certain directory id
     *
     * @param googleFolderIdParent
     * @return list of files in certain directory id
     * @throws IOException
     */
    public static final List<File> getGoogleSubFolders(String googleFolderIdParent) throws IOException {

        Drive driveService = getDriveService();

        String pageToken = null;
        List<File> list = new ArrayList<File>();

        String query = null;
        if (googleFolderIdParent == null) {
            query = " mimeType = 'application/vnd.google-apps.folder' " //
                    + " and 'root' in parents";
        } else {
            query = " mimeType = 'application/vnd.google-apps.folder' " //
                    + " and '" + googleFolderIdParent + "' in parents";
        }

        do {
            FileList result = driveService.files().list().setQ(query).setSpaces("drive") //
                    // Fields will be assigned values: id, name, createdTime
                    .setFields("nextPageToken, files(id, name, createdTime)")//
                    .setPageToken(pageToken).execute();
            for (File file : result.getFiles()) {
                list.add(file);
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
        return list;
    }

    /**
     * Class make list of files in root folder
     *
     * @return list of files
     * @throws IOException
     */
    public static final List<File> getGoogleRootFolders() throws IOException {
        return getGoogleSubFolders(null);
    }

    /**
     * Class make list of file in certain directory name
     *
     * @param googleFolderIdParent
     * @param subFolderName
     * @return list of file in certain directory name
     * @throws IOException
     */
    public static final List<File> getGoogleSubFolderByName(String googleFolderIdParent, String subFolderName)
            throws IOException {

        Drive driveService = getDriveService();

        String pageToken = null;
        List<File> list = new ArrayList<File>();

        String query = null;
        if (googleFolderIdParent == null) {
            query = " name = '" + subFolderName + "' " //
                    + " and mimeType = 'application/vnd.google-apps.folder' " //
                    + " and 'root' in parents";
        } else {
            query = " name = '" + subFolderName + "' " //
                    + " and mimeType = 'application/vnd.google-apps.folder' " //
                    + " and '" + googleFolderIdParent + "' in parents";
        }

        do {
            FileList result = driveService.files().list().setQ(query).setSpaces("drive") //
                    .setFields("nextPageToken, files(id, name, createdTime)")//
                    .setPageToken(pageToken).execute();
            for (File file : result.getFiles()) {
                list.add(file);
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
        //
        return list;
    }

    /**
     * Class make list of files in root folder
     *
     * @param subFolderName
     * @return list of files in root folder
     * @throws IOException
     */
    public static final List<File> getGoogleRootFoldersByName(String subFolderName) throws IOException {
        return getGoogleSubFolderByName(null, subFolderName);
    }

    // com.google.api.services.drive.model.File
    public static final List<File> getGoogleFilesByName(String fileNameLike) throws IOException {

        Drive driveService = getDriveService();

        String pageToken = null;
        List<File> list = new ArrayList<File>();

        String query = " name contains '" + fileNameLike + "' " //
                + " and mimeType != 'application/vnd.google-apps.folder' ";

        do {
            FileList result = driveService.files().list().setQ(query).setSpaces("drive") //
                    // Fields will be assigned values: id, name, createdTime, mimeType
                    .setFields("nextPageToken, files(id, name, createdTime, mimeType)")//
                    .setPageToken(pageToken).execute();
            for (File file : result.getFiles()) {
                list.add(file);
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
        //
        return list;
    }

    public static final void createGoogleWorkingFolderByName() throws IOException {
        List<File> googlefolder = getGoogleRootFoldersByName(GoogleDrivePath.getWorkingFolderName());
        Drive driveService = getDriveService();
        if (!googlefolder.isEmpty()) {
            System.out.println("I am out of folder");
        } else {
            File directory = new File();
            directory.setName(GoogleDrivePath.getWorkingFolderName());
            directory.setMimeType("application/vnd.google-apps.folder");

            File file = driveService.files().create(directory)
                    .setFields("id")
                    .execute();
            System.out.println("Folder ID: " + file.getId() + "  " + file.getName());
        }
    }


    private static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        Credential credential = getCredentials();
        return new Sheets.Builder(
                GoogleDrivePath.getHttpTransport(),
                JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(GoogleDrivePath.getApplicationName())
                .build();
    }

    /**
     * Retrieve data from google spread sheet
     *
     * @param spreadSheetId ceratain excel file in google store
     * @param range         in active sheet
     * @return list of list raws
     */
    public static List<List<Object>> getGoogleSpreadSheetData(String spreadSheetId, String range) throws IOException, GeneralSecurityException {
        Sheets sheetsService = getSheetsService();
        ValueRange result = sheetsService.spreadsheets().values().get(spreadSheetId, range).execute();
        int numRows = result.getValues() != null ? result.getValues().size() : 0;
        System.out.printf("%d rows retrieved.", numRows);
        List<List<Object>> listList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Object> raw = result.getValues().get(i);
            listList.add(raw);
        }
        return listList;
    }

    /**
     * Write data to google spread sheet
     */
    public static void writeToGoogleSpreadSheet(final String spreadSheetId, final List<List<Object>> listList) throws IOException, GeneralSecurityException {
        Sheets sheetsService = getSheetsService();
        UpdateValuesResponse result = sheetsService.spreadsheets().values()
                .update(spreadSheetId, "A1", new ValueRange().setValues(listList))
                .setValueInputOption("RAW")
                .execute();
    }
}