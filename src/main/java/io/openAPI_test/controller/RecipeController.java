package io.openAPI_test.controller;

import io.openAPI_test.domain.Manual;
import io.openAPI_test.domain.Recipe;
import io.openAPI_test.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
    @Value("${openApi.key}")
    private String key;
    @Value("${openApi.URL}")
    private String url;
    @Value("${openApi.serviceId}")
    private String serviceId;
    @Value("${openApi.dataType}")
    private String dataType;

    @GetMapping("/recipe")
    public ResponseEntity<List<Recipe>> callRecipeApi(@RequestParam(value = "startIdx") Integer startIdx,
                                                     @RequestParam(value = "endIdx") Integer endIdx) {
        HttpURLConnection urlConnection = null; // JAVA <-> URL 간의 연결에 대한 API를 제공
        InputStream stream = null;
        String recipeWithString = null;
        List<Recipe> recipeList = null;

        String urlStr = url +
                "/" + key +
                "/" + serviceId +
                "/" + dataType +
                "/" + startIdx.toString() +
                "/" + endIdx.toString();

        try {
            URL url = new URL(urlStr);

            urlConnection = (HttpURLConnection) url.openConnection();
            stream = getNetworkConnection(urlConnection);
            recipeWithString = readStreamToString(stream);
            recipeList = recipeService.convertStringToRecipe(recipeWithString);

            if (stream != null) stream.close();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return new ResponseEntity<>(recipeList, HttpStatus.OK);
    }

    @GetMapping("/manual")
    public ResponseEntity<List<Manual>> callManualApi(@RequestParam(value = "startIdx") Integer startIdx,
                                                      @RequestParam(value = "endIdx") Integer endIdx) {
        HttpURLConnection urlConnection = null; // JAVA <-> URL 간의 연결에 대한 API를 제공
        InputStream stream = null;
        String recipeWithString = null;
        List<Manual> manualList = null;

        String urlStr = url +
                "/" + key +
                "/" + serviceId +
                "/" + dataType +
                "/" + startIdx.toString() +
                "/" + endIdx.toString();

        try {
            URL url = new URL(urlStr);

            urlConnection = (HttpURLConnection) url.openConnection();
            stream = getNetworkConnection(urlConnection);
            recipeWithString = readStreamToString(stream);
            manualList = recipeService.convertStringToManual(recipeWithString);

            if (stream != null) stream.close();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return new ResponseEntity<>(manualList, HttpStatus.OK);
    }

    /* URLConnection 을 전달받아 연결정보 설정 후 연결, 연결 후 수신한 InputStream 반환 */
    private InputStream getNetworkConnection(HttpURLConnection urlConnection) throws IOException {
        urlConnection.setConnectTimeout(3000);  // 연결이 설정되기 전에 제한 시간이 만료되면 java.net.SocketTimeoutException 발생
        urlConnection.setReadTimeout(3000);     // 제한 시간이 만료되고, 연결의 Input 스트림에서 읽을 수 있는 데이터가 없으면 SocketTimeoutException 발생
        urlConnection.setRequestMethod("GET");  // default: GET
        urlConnection.setDoInput(true);         // URLConnection을 서버에서 콘텐츠를 읽는데 사용할 수 있는지에 대한 여부

        if(urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code : " + urlConnection.getResponseCode());
        }

        return urlConnection.getInputStream();
    }

    // InputStream을 전달 받아 문자열로 변환
    private String readStreamToString(InputStream stream) throws IOException{
        StringBuilder recipeWithString = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

        String readLine;
        while((readLine = br.readLine()) != null) {
            recipeWithString.append(readLine + "\n");
        }

        br.close();

        return recipeWithString.toString();
    }
}
