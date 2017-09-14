package erfangc.awsaccess;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.stream.Collectors.joining;
/**
I am a Chris
**/
@RestController
public class Controller {
    private AmazonS3 amazonS3;

    public Controller(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    @GetMapping("/")
    public String root() {
        return "Hello Jenkins!";
    }

    @GetMapping("s3")
    public String get(@RequestParam(defaultValue = "20172466E2-cloudformation.yaml") String key) throws IOException {
        GetObjectRequest req = new GetObjectRequest("cf-templates-19t957lyn96vi-us-east-1", key);
        S3Object result = this.amazonS3.getObject(req);
        BufferedReader reader = new BufferedReader(new InputStreamReader(result.getObjectContent()));
        String content = reader.lines().collect(joining("\n"));
        reader.close();
        return content;
    }

}
