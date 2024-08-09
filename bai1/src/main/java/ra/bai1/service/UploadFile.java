package ra.bai1.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFile {
    String uploadLocal(MultipartFile fileUpload);
    String uploadFirebase(String localPath);
}
