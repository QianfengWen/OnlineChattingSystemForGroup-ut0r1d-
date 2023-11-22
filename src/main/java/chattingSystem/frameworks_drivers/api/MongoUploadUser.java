package chattingSystem.frameworks_drivers.api;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;
import okhttp3.*;

import java.io.IOException;

public class MongoUploadUser {
    public void uploadUsers(String username, String userid, String password, String creationtime) throws IOException {
        HttpResponse<String> response = Unirest.post("https://us-east-2.aws.data.mongodb-api.com/app/data-ybzsr/endpoint/data/v1/action/insertOne")
                .header("Content-Type", "application/json")
                .header("Access-Control-Request-Headers", "*")
                .header("api-key", "AbgMkEbqaQgltaqv4Z7ui1Jd6XVJ2rQzj5Hw8P3IMDeVdND2CGCICNTid0JvpQwm")
                .body("{\n      \"dataSource\": \"OnlineChatting\",\n      \"database\": \"ChatSystem\",\n      \"collection\": \"users\",\n      \"document\": {\n        \"username\": \""+username+"\",\n        \"userid\": \""+userid+"\",\n        \"password\": \""+password+"\",\n        \"creation_time\":\""+creationtime+"\"\n      }\n  }")
                .asString();


    }
}
