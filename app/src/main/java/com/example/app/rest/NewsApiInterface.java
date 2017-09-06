package com.example.app.rest;


import com.example.app.base.WebServiceURL;
import com.example.app.model.ArticleModel;
import com.example.app.model.SourceModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface NewsApiInterface {

    @GET(WebServiceURL.AVAILABLE_SOURCE)
    Call<SourceModel> getAvailableSources();


    @GET(WebServiceURL.ARTICLES)
    Call<ArticleModel> getArticlesBySource(@QueryMap Map<String, String> params);
  /*  // GET

    @Headers(ParamHelper.PARAM_AUTHORIZATION + ": " + ParamHelper.PARAM_VALUE_AUTH_BASIC)
    @GET(WebServiceURL.DOES_EXIST_URL)
    Call<AthleteResponse> signUpMobile(@QueryMap Map<String, String> params);

    @Headers(ParamHelper.PARAM_AUTHORIZATION + ": " + ParamHelper.PARAM_VALUE_AUTH_BASIC)
    @GET(WebServiceURL.DOES_EXIST_URL)
    Call<AthleteResponse> checkSecondDevice(@QueryMap Map<String, String> params);

    @Headers(ParamHelper.PARAM_AUTHORIZATION + ": " + ParamHelper.PARAM_VALUE_AUTH_BASIC)
    @GET(WebServiceURL.DOES_EXIST_URL)
    Call<AthleteResponse> verifyUserData(@QueryMap Map<String, String> params);

    @GET(WebServiceURL.GET_ATHLETE)
    Call<Athlete> getAthleteDetails(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("athleteId") String athleteId);

    @Headers(ParamHelper.PARAM_AUTHORIZATION + ": " + ParamHelper.PARAM_VALUE_AUTH_BASIC)
    @GET(WebServiceURL.OTP_VERIFY)
    Call<OtpResponse> verifyOTP(@Path("athleteId") String athleteId, @Path("deviceToken") String deviceToken, @Path("verifyCode") String verifyCode, @Path("authToken") String authToken, @Path("deviceId") String deviceId);

    @GET(WebServiceURL.GET_SESSION)
    Call<Session> getSessionDetails(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("sessionId") String sessionId);

    @GET(WebServiceURL.GET_NOTIFICATION)
    Call<Vector<NotificationModel>> getNotification(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization);

    @GET(WebServiceURL.GET_AUDIOCUE)
    Call<AudioCuesModel> getAudioCue();

    *//**
     * @param url    - because, if you add this in @GET, it will refer the base url of the app
     *               and not the under-armour api url.
     * @param params - required fields for the near by routes
     * @return
     *//*
    @Headers({
            ParamHelper.PARAM_AUTHORIZATION + ": " + ParamHelper.UNDER_ARMOUR_AUTHORIZATION_HEADER,
            ParamHelper.PARAM_API_KEY + ":" + ParamHelper.UNDER_ARMOUR_API_KEY
    })
    @GET()
    Call<NearByRoutes> getNearByRoutes(@Url String url, @QueryMap Map<String, Object> params);


    *//**
     * @param url    - because, if you add this in @GET, it will refer the base url of the app
     *               and not the under-armour api url.
     * @param params - required field types for the route's id.
     * @return
     *//*
    @Headers({
            ParamHelper.PARAM_AUTHORIZATION + ": " + ParamHelper.UNDER_ARMOUR_AUTHORIZATION_HEADER,
            ParamHelper.PARAM_API_KEY + ":" + ParamHelper.UNDER_ARMOUR_API_KEY
    })
    @GET()
    @Streaming
    Call<Routes> getRouteByID(@Url String url, @QueryMap Map<String, String> params);


    @GET(WebServiceURL.GET_MY_ROUTES)
    Call<ResponseBody> getCustomRoutesList(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("athleteId") String athleteId, @Query("page") int page);

    *//**
     * @param url - because, if you add this in @GET, it will refer the base url of the app
     *            and not the under-armour api url.
     * @return
     *//*
    @Headers(ParamHelper.PARAM_AUTHORIZATION + ": " + ParamHelper.PARAM_VALUE_AUTH_BASIC)
    @GET()
    Call<AudioCueList> getAudioCuesList(@Url String url);

    // PUT

    @PUT(WebServiceURL.RESET_PASSCODE)
    Call<Athlete> resetPasscode(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Body ResetPasscodeRequest resetPasscode);

    @PUT(WebServiceURL.PUT_ATHLETE)
    Call<Athlete> sendAthleteDetails(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Body Athlete athlete);

    @PUT(WebServiceURL.PUT_SESSION)
    Call<ResponseBody> putSessionDetails(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("sessionId") String athleteId, @Body RequestBody sessionDetails);

    @PUT(WebServiceURL.PUT_ROUTES)
    Call<ResponseBody> putRoutes(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("routeId") String routeId, @Body Route route);


    // POST
    // ToDo: Need to change athleteOldSignIn to athleteSignIn
    @Headers(ParamHelper.PARAM_AUTHORIZATION + ": " + ParamHelper.PARAM_VALUE_AUTH_BASIC)
    @POST(WebServiceURL.ATHLETE_SIGN_IN)
    Call<ResponseBody> athleteOldSignIn(@Body SignIn athleteSignIn);

    @Headers(ParamHelper.PARAM_AUTHORIZATION + ": " + ParamHelper.PARAM_VALUE_AUTH_BASIC)
    @POST(WebServiceURL.ATHLETE_SIGN_IN)
    Call<SigninResponse> athleteSignIn(@Body SignIn athleteSignIn);

    @Headers(ParamHelper.PARAM_AUTHORIZATION + ": " + ParamHelper.PARAM_VALUE_AUTH_BASIC)
    @POST(WebServiceURL.SIGNUP)
    Call<Athlete> signUpUser(@Body SignUpRequest userRequest);

    @Headers(ParamHelper.PARAM_AUTHORIZATION + ": " + ParamHelper.PARAM_VALUE_AUTH_BASIC)
    @POST(WebServiceURL.INIT_OTP_URL)
    Call<OtpResponse> sendOTP(@Body OtpRequest otpData);

    @POST(WebServiceURL.POST_SESSION)
    Call<SessionPostResponse> postSessionDetails(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Body Session session);

    *//*   MY ROUTES   *//*
    @Headers(ParamHelper.PARAM_AUTHORIZATION + ": " + ParamHelper.PARAM_VALUE_AUTH_BASIC)
    @POST(WebServiceURL.REFRESH_TOKEN)
    Call<TokenResponse> refreshToken(@Body RefreshToken refreshToken);

    @GET(WebServiceURL.GET_MY_ROUTES)
    Call<MyRoutesResponse> getMyRoutes(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("athleteId") String athleteId*//*, @Query("page") int page, @Query("size") int size*//*);

    @GET(WebServiceURL.GET_ROUTES)
    Call<Route> getRouteById(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("routeId") String routeId);

    @POST(WebServiceURL.POST_CUSTOM_ROUTE)
    Call<ResponseBody> postCustomRoute(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Body Route customRoute);

    @HTTP(method = "DELETE", path = WebServiceURL.DELETE_ROUTES, hasBody = true)
    Call<ResponseBody> deleteRoutes(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Body RouteIds routeIds);

    @Headers(ParamHelper.PARAM_AUTHORIZATION + ": " + ParamHelper.PARAM_VALUE_AUTH_BASIC)
    @GET(WebServiceURL.GET_REFERENCE_DATA)
    Call<List<RefData>> getReferenceData();

    *//* INJURY REPORTS *//*
    @GET(WebServiceURL.GET_INJURY_REPORTS)
    Call<InjuryReports> getInjuryReports(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("athleteId") String routeId);

    @POST(WebServiceURL.POST_INJURY_REPORTS)
    Call<InjuryItem> postInjuryReports(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Body InjuryItem injuryList);

    @DELETE(WebServiceURL.DELETE_INJURY_REPORT)
    Call<ResponseBody> deleteInjuryReports(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("injuryId") String injuryId);

    @PUT(WebServiceURL.PUT_INJURY_REPORTS)
    Call<InjuryItem> updateInjuryReports(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("injuryId") String routeId, @Body InjuryItem injuryList);

    *//* WEEKLY PLANNER *//*
    @GET(WebServiceURL.GET_WEEKLY_PLANNER)
    Call<WeeklyLoad> getWeeklyPlanner(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("givenDate") String date);

    @POST(WebServiceURL.POST_WEEKLY_PLANNER)
    Call<ResponseBody> postWeeklyPlanner(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Body WeeklyLoad weeklyLoad);

    @PUT(WebServiceURL.PUT_WEEKLY_PLANNER)
    Call<WeeklyLoad> putWeeklyPlanner(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("weeklyloadId") String weeklyloadId, @Body Load load);

    *//* SESSION DETAILS *//*
    @GET(WebServiceURL.GET_ATHLETE_SESSION_DETAILS)
    Call<AthleteSessionDetails> getAthleteSessionDetails(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("athleteId") String athleteId, @Query("page") int page, @Query("size") int size);

    *//* GOALS *//*
    @GET(WebServiceURL.GET_GOAL)
    Call<Goal> getGoalDetails(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Path("givenDate") String givenDate, @Path("activityTag") String activityTag, @Query("routeId") String routeId);

    // PUT service will acts as POST service if there is no goal already present.
    @PUT(WebServiceURL.PUT_GOAL)
    Call<Goal> putGoalDetails(@Header(ParamHelper.PARAM_AUTHORIZATION) String authorization, @Body Goal goal);*/
}