package ipd.renade.renadeapi.service;

import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.Permission;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import ipd.renade.renadeapi.model.FileUploadResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

@Service
public class GoogleDriveService {
    private static final String CREDENTIALS_FILE_PATH = "credentials.json";
    private Drive driveService;

    @PostConstruct
    public void init() throws IOException {
        InputStream inputStream = new ClassPathResource(CREDENTIALS_FILE_PATH).getInputStream();
        GoogleCredentials credentials = GoogleCredentials.fromStream(inputStream);
        driveService = new Drive.Builder(
                new NetHttpTransport(),
                GsonFactory.getDefaultInstance(),
                new HttpCredentialsAdapter(credentials))
                .setApplicationName("Renade Drive")
                .build();
    }

    public FileUploadResponse uploadPdfFile(MultipartFile file) throws IOException {
        String folderId = "1z7A6vIAK5nNXKlLHLGtOkZazkgRWPGt9"; // ID del folder
        File fileMetadata = new File();
        fileMetadata.setName(file.getOriginalFilename());
        fileMetadata.setParents(Collections.singletonList(folderId));

        InputStreamContent mediaContent = new InputStreamContent("application/pdf", file.getInputStream());

        File uploadedFile = driveService.files()
                .create(fileMetadata, mediaContent)
                .setFields("id, webViewLink")
                .execute();

        Permission permission = new Permission()
                .setType("anyone")
                .setRole("reader");

        driveService.permissions().create(uploadedFile.getId(), permission).execute();

        String fileUrl = uploadedFile.getWebViewLink();
        return new FileUploadResponse(200, "PDF file uploaded successfully", fileUrl);
    }
}