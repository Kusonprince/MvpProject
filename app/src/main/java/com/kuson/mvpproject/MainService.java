package com.kuson.mvpproject;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by kuson on 17/9/15.
 */

public interface MainService {

    @POST()
    Observable<String> getUserInfo(@Body String info);

}
