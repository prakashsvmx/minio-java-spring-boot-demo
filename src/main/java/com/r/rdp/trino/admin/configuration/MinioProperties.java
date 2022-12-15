package com.r.rdp.trino.admin.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.minio.MinioClient;
import org.springframework.stereotype.Component;

/**
 * Instantiates a new minm io properties.
 */
@ConfigurationProperties("trino.admin")
@SuppressWarnings("PMD")
@Configuration
public class MinioProperties {

    /** The storage type. */
    private List<String> allowedTags;

    /** s3 url. **/
    private String url;

    /** The user name. */
    private String userName;

    /** The paswrd. */
    private String paswrd;

    /** The bucket name. */
    private String bucketName;

    /** The new connections folder name. */
    private String newConnectionsFolderName;

    /** The changed connections folder name. */
    private String changedConnectionsFolderName;

    /** The existing connections folder name. */
    private String existingConnectionsFolderName;

    /** The delete connections folder name. */
    private String deleteConnectionsFolderName;

    /**
     * The trino.admin source config which has all the possible combination of data
     * source config.
     */
    private String fieldConfigDetailPath;

    /**
     * Gets the changed connections folder name.
     *
     * @return the changed connections folder name
     */
    public String getChangedConnectionsFolderName() {
        final String path = changedConnectionsFolderName + "/";
        System.out.println("Path::"+path);
        return path;
    }

    /**
     * Gets the existing connections folder name.
     *
     * @return the existing connections folder name
     */
    public String getExistingConnectionsFolderName() {
        final String path = existingConnectionsFolderName +"/";
        System.out.println("Path::"+path);        return path;
    }

    /**
     * Gets the new connections folder name.
     *
     * @return the new connections folder name
     */
    public String getNewConnectionsFolderName() {
        final String path = newConnectionsFolderName +"/";
        System.out.println("Path::"+path);
        return path;
    }

    /**
     * Gets the delete connections folder name.
     *
     * @return the delete connections folder name
     */
    public String getDeleteConnectionsFolderName() {
        final String path = deleteConnectionsFolderName +"/";
        System.out.println("Path::"+path);
        return path;
    }

    /**
     * trino.admin client.
     *
     * @return the trino.admin client
     */
    @Bean
    public MinioClient minioClient() {

        MinioClient minioClient = MinioClient.builder()
                .endpoint("https://play.min.io")
                .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
                .build();

        return minioClient;

       /* System.out.println(url+"::"+ userName);
        return MinioClient.builder()
                .endpoint(url)
                .credentials(userName, paswrd)
                .build();*/

    }
}