package com.rts.myb.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class AWSS3ServiceImpl {

	
    
    private AmazonS3 amazonS3;
    @Value("${aws.s3.bucket}")
    private String bucketName;
 
   
    // @Async annotation ensures that the method is executed in a different background thread 
    // but not consume the main thread.
//    @Async
//    public void uploadFile(final MultipartFile multipartFile) {
//       System.out.println("File upload in progress.");
//        try {
//            final File file = convertMultiPartFileToFile(multipartFile);
//            uploadFileToS3Bucket(bucketName, file);
//           System.out.println("File upload is completed.");
//            file.delete();  // To remove the file locally created in the project folder.
//        } catch (final AmazonServiceException ex) {
//           System.out.println("File upload is failed.");
//            ex.printStackTrace();
//        }
//    }
    
    
    @Autowired
    public AWSS3ServiceImpl(Region awsRegion, AWSCredentialsProvider awsCredentialsProvider, String awsS3AudioBucket) 
    {
        this.amazonS3 = AmazonS3ClientBuilder.standard()
                .withCredentials(awsCredentialsProvider)
                .withRegion(awsRegion.getName()).build();
        this.bucketName = awsS3AudioBucket;
    }
 
    @Async
    public void uploadFileToS3Bucket(MultipartFile multipartFile, boolean enablePublicReadAccess, String fileName) 
    {
        //String fileName = multipartFile.getOriginalFilename();

        try {
            //creating the file in the server (temporarily)
            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(multipartFile.getBytes());
            fos.close();

            PutObjectRequest putObjectRequest = new PutObjectRequest(this.bucketName+"/"+"kyc", fileName, file).
            withCannedAcl(CannedAccessControlList.PublicRead);
            
            this.amazonS3.putObject(putObjectRequest);
            URL s3Url =  this.amazonS3.getUrl(bucketName+"/"+"kyc", fileName);
            System.out.println(s3Url.toExternalForm());
            //removing the file created in the server
            file.delete();
        } catch (IOException | AmazonServiceException ex) {
           ex.printStackTrace();
        }
    }

//    private File convertMultiPartFileToFile(final MultipartFile multipartFile) {
//        final File file = new File(multipartFile.getOriginalFilename());
//        try (final FileOutputStream outputStream = new FileOutputStream(file)) {
//            outputStream.write(multipartFile.getBytes());
//        } catch (final IOException ex) {
//        	 ex.printStackTrace();
//        }
//        return file;
//    }
// 
//    private void uploadFileToS3Bucket(final String bucketName, final File file) {
//        final String uniqueFileName = LocalDateTime.now() + "_" + file.getName();
//       System.out.println("Uploading file with name= " + uniqueFileName);
//        final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file);
//        amazonS3.putObject(putObjectRequest);
//    }
}
