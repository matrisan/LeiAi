package com.matrixboot.leiai.infrastructure.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matrixboot.leiai.domain.entity.PeriodicalEntity;
import com.matrixboot.leiai.domain.repository.IPeriodicalRepository;
import lombok.SneakyThrows;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * create in 2021/10/21 4:37 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Repository
public class PeriodicalOkHttpRepositoryImpl implements IPeriodicalRepository {

    private static final OkHttpClient CLIENT = new OkHttpClient().newBuilder().build();

    @SneakyThrows
    @Override
    public List<PeriodicalEntity> findAllByName(String name) {
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("action", "org")
                .addFormDataPart("type", "2")
                .addFormDataPart("orgName", name)
                .build();
        Request request = new Request.Builder()
                .url("http://www.nppa.gov.cn/ydyycx/WeiXin/action.aspx")
                .method("POST", body)
                .addHeader("Cookie", "__jsluid_h=35f837480aa546a2c79f4171694c9e88")
                .build();
        Response response = CLIENT.newCall(request).execute();
        ResponseBody responseBody = response.body();
        return Objects.isNull(responseBody) ? Collections.emptyList() : convert(responseBody.string());
    }

    @Resource
    private ObjectMapper objectMapper;

    private static final TypeReference<List<PeriodicalEntity>> TYPE_REFERENCE = new TypeReference<>() {
    };

    @SneakyThrows
    private List<PeriodicalEntity> convert(String data) {
        return objectMapper.readValue(data, TYPE_REFERENCE);
    }


}





