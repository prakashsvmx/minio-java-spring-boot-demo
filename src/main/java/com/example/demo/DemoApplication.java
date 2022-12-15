package com.example.demo;

import com.r.rdp.trino.admin.configuration.MinioProperties;
import io.minio.BucketExistsArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class DemoApplication {
   /* public MinioClient minioClient() {

        MinioClient minioClient = MinioClient.builder()
                .endpoint("https://play.min.io")
                .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
                .build();

        minioClient.traceOn(System.out);

        return minioClient;

    }*/


    public static void main(String[] args) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        DemoApplication da = new DemoApplication();

        System.out.println("Start MinIO");
        SpringApplication.run(DemoApplication.class, args);

        String bucketName="asiatrip";
        MinioProperties mp = new MinioProperties();
        MinioClient mc = mp.minioClient();
        mc.traceOn(System.out);
        mc.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());


        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            builder.append(
                    "Sphinx of black quartz, judge my vow: Used by Adobe InDesign to display font samples. ");
            builder.append("(29 letters)\n");
            builder.append(
                    "Jackdaws love my big sphinx of quartz: Similarly, used by Windows XP for some fonts. ");
            builder.append("(31 letters)\n");
            builder.append(
                    "Pack my box with five dozen liquor jugs: According to Wikipedia, this one is used on ");
            builder.append("NASAs Space Shuttle. (32 letters)\n");
            builder.append(
                    "The quick onyx goblin jumps over the lazy dwarf: Flavor text from an Unhinged Magic Card. ");
            builder.append("(39 letters)\n");
            builder.append(
                    "How razorback-jumping frogs can level six piqued gymnasts!: Not going to win any brevity ");
            builder.append("awards at 49 letters long, but old-time Mac users may recognize it.\n");
            builder.append(
                    "Cozy lummox gives smart squid who asks for job pen: A 41-letter tester sentence for Mac ");
            builder.append("computers after System 7.\n");
            builder.append(
                    "A few others we like: Amazingly few discotheques provide jukeboxes; Now fax quiz Jack! my ");
            builder.append("brave ghost pled; Watch Jeopardy!, Alex Trebeks fun TV quiz game.\n");
            builder.append("---\n");
        }

        {
            // Create a InputStream for object upload.
            ByteArrayInputStream bais = new ByteArrayInputStream(builder.toString().getBytes("UTF-8"));

            // Create object 'my-objectname' in 'my-bucketname' with content from the input stream.
            mc.putObject(
                    PutObjectArgs.builder().bucket(bucketName).object("my-objectname").stream(
                                    bais, bais.available(), -1)
                            .build());
            bais.close();
            System.out.println("my-objectname is uploaded successfully");
        }

        // SpringApplication.run(MinioProperties.class, args);

       /* System.out.println("Process Annotation");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MinioProperties.class);
        ctx.refresh();*/

        System.out.println("Process Annotation Done");

     /*   MinioClient minioClient = da.minioClient();
        // Make 'asiatrip' bucket if not exist.
        boolean found =
                minioClient.bucketExists(BucketExistsArgs.builder().bucket("asiatrip").build());
        if (!found) {
            // Make a new bucket called 'asiatrip'.
            minioClient.makeBucket(MakeBucketArgs.builder().bucket("asiatrip").build());
        } else {
            System.out.println("Bucket 'asiatrip' already exists.");
        }*/

    }

}
