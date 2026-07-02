package com.jobportal.util;

import java.io.File;
import java.io.IOException;
import jakarta.servlet.http.Part;

public class FileUploadUtil {

    public static String uploadFile(Part filePart, String uploadPath) throws IOException {

        String fileName = filePart.getSubmittedFileName();

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String filePath = uploadPath + File.separator + fileName;

        filePart.write(filePath);

        return fileName;
    }
}