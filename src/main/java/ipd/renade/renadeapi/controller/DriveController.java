package ipd.renade.renadeapi.controller;

import ipd.renade.renadeapi.model.FileUploadResponse;
import ipd.renade.renadeapi.service.GoogleDriveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/drive")
public class DriveController {

    private final  GoogleDriveService googleDriveService;

    public DriveController(GoogleDriveService googleDriveService) {
        this.googleDriveService = googleDriveService;
    }

    @PostMapping("/upload-pdf")
    public ResponseEntity<FileUploadResponse> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            FileUploadResponse response = googleDriveService.uploadPdfFile(file);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new FileUploadResponse(500, "Error uploading file: " + e.getMessage(), null));
        }
    }
}