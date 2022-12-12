package com.example.demo;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class DemoApplication {


    public MinioClient minioClient() {
          MinioClient minioClient = MinioClient.builder()
                        .endpoint("https://play.min.io")
                        .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
                        .build();

          return minioClient;

    }

    public static void main(String[] args) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        DemoApplication da = new DemoApplication();

        System.out.println("Start MinIO");
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("Continue to MinIO");

        MinioClient minioClient = da.minioClient();
        // Make 'asiatrip' bucket if not exist.
        boolean found =
                minioClient.bucketExists(BucketExistsArgs.builder().bucket("asiatrip").build());
        if (!found) {
            // Make a new bucket called 'asiatrip'.
            minioClient.makeBucket(MakeBucketArgs.builder().bucket("asiatrip").build());
        } else {
            System.out.println("Bucket 'asiatrip' already exists.");
        }

    }

}
