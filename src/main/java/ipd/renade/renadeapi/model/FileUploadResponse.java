package ipd.renade.renadeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileUploadResponse {
    private int status;
    private String message;
    private String url;
}
