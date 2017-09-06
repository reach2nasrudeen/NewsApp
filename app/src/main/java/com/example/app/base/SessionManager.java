package com.example.app.base;


import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private SharedPreferences pref, preferenceAdvance;
    private SharedPreferences.Editor editor, editorAdvance;

    Context _context;

    private int PRIVATE_MODE = 0;

    private static final String PREFERENCE_NURVV = "nurvPreferences";
    private static final String PREFERENCE_ADVANCE_RUN = "advance_run_preference";

    private static final String KEY_OTP_NO_OF_TRIES = "NO_OF_TRIES";
    private static final String KEY_DEVICE_TOKEN = "DEVICE_TOKEN";
    private static final String KEY_ATHLETE_ID = "ATHLETE_ID";
    private static final String KEY_ATHLETE_MOBILE_NO = "ATHLETE_MOBILE_NO";

    private static final String KEY_ATHLETE_EMAIL = "ATHLETE_EMAIL";
    private static final String KEY_ATHLETE_HEIGHT = "ATHLETE_HEIGHT";
    private static final String KEY_ATHLETE_HEIGHT_TYPE = "ATHLETE_HEIGHT_TYPE";
    private static final String KEY_ATHLETE_WEIGHT_TYPE = "ATHELETE_WEIGHT_TYPE";
    private static final String KEY_ATHLETE_WEIGHT = "ATHLETE_WEIGHT";

    private static final String KEY_ATHLETE_AUTH_TOKEN = "ATHLETE_AUTH_TOKEN";
    private static final String KEY_ATHLETE_AUTH_HEADER_TOKEN = "ATHLETE_AUTH_HEADER_TOKEN";
    private static final String KEY_PREFERENCE_VALUE = "preference_Value_for_reference";
    private static final String KEY_USER_LOGGED = "user_logged_in_for";
    private static final String KEY_ACCESS_TOKEN = "access_token_for_the_user";
    private static final String USER_CURRENT_LOCATION = "save_user_current_location";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String DETECT_USER_LOCATION = "variable_to_identify_that_current_location_has_received";

    private static final String DISTANCE_RUN = "distance_run_value";
    private static final String TIME_RUN_HOURS = "time_run_hour_value";
    private static final String TIME_RUN_MINUTES = "time_run_minutes_value";
    private static final String TIME_RUN_SECONDS = "time_run_seconds_value";
    private static final String MIN_HEART_RATE_RUN = "min_heart_rate_run_value";
    private static final String MAX_HEART_RATE_RUN = "max_heart_rate_run_value";
    private static final String IS_HR_RANGE = "is_hr_range_selected";
    private static final String IS_PUCK_CONNECTED = "is_puck connected";
    private static final String IS_PUCK_DISCONNECTED = "is_puck disconnected";
    private static final String LAST_PAIRED_DEVICE_ADDRESS  = "null";
    private static final String LAST_PAIRED_DEVICE_NAME  = "";
    // For advance run setup.
    private static final String IS_ADVANCED_RUN = "is_advanced_run_setup";
    private static final String ADVANCE_RUN_ROUTE_ID = "advanced_run_selected_route_id";
    private static final String ADVANCED_RUN_TAG = "advanced_run_selected_route_tag";
    private static final String SELECTED_RUN_TAG = "selected_run_tag";
    private static final String ADVANCED_RUN_ROUTE_NAME = "advanced_run_selected_route_name";

    private boolean userLoggedIn;

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREFERENCE_NURVV, PRIVATE_MODE);
        preferenceAdvance = _context.getSharedPreferences(PREFERENCE_ADVANCE_RUN, PRIVATE_MODE);
        editor = pref.edit();
        editorAdvance = preferenceAdvance.edit();
    }

    public void setAdvancedRunRouteID(String routeID){
        editorAdvance.putString(ADVANCE_RUN_ROUTE_ID, routeID);
        editorAdvance.commit();
    }

    public String getAdvancedRunRouteID(){
        return preferenceAdvance.getString(ADVANCE_RUN_ROUTE_ID, "");
    }

    public void setAdvancedRunTag(String tag){
        editorAdvance.putString(ADVANCED_RUN_TAG, tag);
        editorAdvance.commit();
    }

    public String getAdvancedRunTag(){
        return preferenceAdvance.getString(ADVANCED_RUN_TAG, "");
    }

    public String getAdvancedRunRouteName(){
        return preferenceAdvance.getString(ADVANCED_RUN_ROUTE_NAME, "");
    }

    public void setAdvancedRunRouteName(String name){
        editorAdvance.putString(ADVANCED_RUN_ROUTE_NAME, name);
        editorAdvance.commit();
    }

    public void set_Last_Paired_Device(String device_address) {
        editor.putString(LAST_PAIRED_DEVICE_ADDRESS, device_address);
        editor.commit();
    }

    public String get_Last_Paired_device() {
        return pref.getString(LAST_PAIRED_DEVICE_ADDRESS, "");

    }
    public void set_Last_Paired_Device_Name(String device_name) {
        editor.putString(LAST_PAIRED_DEVICE_NAME, device_name);
        editor.commit();
    }

    public String get_Last_Paired_device_Name() {
        return pref.getString(LAST_PAIRED_DEVICE_NAME, "");
    }

    public void setNoOfTries(String noOfTries) {
        editor.putString(KEY_OTP_NO_OF_TRIES, noOfTries);
        editor.commit();
    }

    public String getNoOfTries() {
        return pref.getString(KEY_OTP_NO_OF_TRIES, "");
    }

    public void setDeviceToken(String deviceToken) {
        editor.putString(KEY_DEVICE_TOKEN, deviceToken);
        editor.commit();
    }

    public String getDeviceToken() {
        return pref.getString(KEY_DEVICE_TOKEN, "");
    }

    public void setAthleteId(String athleteId) {
        editor.putString(KEY_ATHLETE_ID, athleteId);
        editor.commit();
    }

    public String getAthleteId() {
        return pref.getString(KEY_ATHLETE_ID, "");
    }

    public void setAthleteWeightType(String height) {
        editor.putString(KEY_ATHLETE_WEIGHT_TYPE, height);
        editor.commit();
    }

    public void setAthleteEmail(String athleteEmail) {
        editor.putString(KEY_ATHLETE_EMAIL, athleteEmail);
        editor.commit();
    }

    public String getAthleteEmail() {
        return pref.getString(KEY_ATHLETE_EMAIL, "");
    }

    public void setAthleteMobNo(String mobNo) {
        editor.putString(KEY_ATHLETE_MOBILE_NO, mobNo);
        editor.commit();
    }

    public String getAthleteMobNo() {
        return pref.getString(KEY_ATHLETE_MOBILE_NO, "");
    }


    public void setAthleteHeight(String height) {
        editor.putString(KEY_ATHLETE_HEIGHT, height);
        editor.commit();
    }

    public String getAthleteHeight() {
        return pref.getString(KEY_ATHLETE_HEIGHT, "");
    }


    public void setAthleteHeightType(String height) {
        editor.putString(KEY_ATHLETE_HEIGHT_TYPE, height);
        editor.commit();
    }

    public String getAthleteHeightType() {
        return pref.getString(KEY_ATHLETE_HEIGHT_TYPE, "");
    }


    public String getAthleteWeight() {
        return pref.getString(KEY_ATHLETE_WEIGHT, "");
    }

    public void setAthleteWeight(String weight) {
        editor.putString(KEY_ATHLETE_WEIGHT, weight);
        editor.commit();
    }

    public void setAthleteAuthToken(String authToken) {
        editor.putString(KEY_ATHLETE_AUTH_TOKEN, authToken);
        editor.commit();
    }

    public String getAthleteAuthToken() {
        return pref.getString(KEY_ATHLETE_AUTH_TOKEN, "");
    }

    public void setAthleteAuthHeaderToken(String authToken) {
        editor.putString(KEY_ATHLETE_AUTH_HEADER_TOKEN, authToken);
        editor.commit();
    }

    public String getAthleteAuthHeaderToken() {
        return pref.getString(KEY_ATHLETE_AUTH_HEADER_TOKEN, "");
    }

    public void setPreferenceValue(String value) {
        editor.putString(KEY_PREFERENCE_VALUE, value);
        editor.commit();
    }

    public String getPreferenceValue() {
        return pref.getString(KEY_PREFERENCE_VALUE, "");
    }

    public boolean isUserLoggedIn() {
        return pref.getBoolean(KEY_USER_LOGGED, false);
    }

    public void setUserLoggedIn(boolean isLogged) {  // TODO SET USER LOGGED IN TRUE WHEN THE USER LOGS INTO THE APP.
        editor.putBoolean(KEY_USER_LOGGED, isLogged);
        editor.commit();
    }

    public String getAccessToken() {
        return pref.getString(KEY_ACCESS_TOKEN, "");
    }

    public void setAccessToken(String accessToken) {   // TODO SET ACCESS TOKEN WHEN THE USER GETS AUTHORIZATION.
        editor.putString(KEY_ACCESS_TOKEN, accessToken);
        editor.commit();
    }

    public String getCurrentLocation() {
        return pref.getString(USER_CURRENT_LOCATION, "");
    }

    public void setCurrentLocation(String location) {
        editor.putString(USER_CURRENT_LOCATION, location);
        editor.commit();
    }

    public float getDistanceRunValue() {
        return pref.getFloat(DISTANCE_RUN, 0.0f);
    }

    public void setDistanceRunValue(float distanceValue) {
        editor.putFloat(DISTANCE_RUN, distanceValue);
        editor.commit();
    }

    public String getTimeRunHours() {
        return pref.getString(TIME_RUN_HOURS, "00");
    }

    public void setTimeRunHours(String timeValue) {
        editor.putString(TIME_RUN_HOURS, timeValue);
        editor.commit();
    }

    public String getTimeRunMinutes() {
        return pref.getString(TIME_RUN_MINUTES, "00");
    }

    public void setTimeRunMinutes(String timeValue) {
        editor.putString(TIME_RUN_MINUTES, timeValue);
        editor.commit();
    }

    public String getTimeRunSeconds() {
        return pref.getString(TIME_RUN_SECONDS, "00");
    }

    public void setTimeRunSeconds(String timeValue) {
        editor.putString(TIME_RUN_SECONDS, timeValue);
        editor.commit();
    }

    public String getMinHeartRateRunValue() {
        return pref.getString(MIN_HEART_RATE_RUN, "0 bpm");
    }

    public void setMinHeartRateRunValue(String timeValue) {
        editor.putString(MIN_HEART_RATE_RUN, timeValue);
        editor.commit();
    }
    public String getMaxHeartRateRunValue() {
        return pref.getString(MAX_HEART_RATE_RUN, "200 bpm");
    }

    public void setMaxHeartRateRunValue(String timeValue) {
        editor.putString(MAX_HEART_RATE_RUN, timeValue);
        editor.commit();
    }

    public boolean isHRseleced() {
//        return pref.getString(IS_HR_RANGE, "false");
        return pref.getBoolean(IS_HR_RANGE, false);
    }

    /**
     *
     * @param selected - true - target range selected.
     *                 - false - single target selected.
     */
    public void setHRselected(boolean selected) {
        editor.putBoolean(IS_HR_RANGE, selected);
        editor.commit();
    }

    public boolean isAdvancedRunSelected(){
        return pref.getBoolean(IS_ADVANCED_RUN, false);
    }

    public void setAdvancedRunSelected(boolean selected){
        editor.putBoolean(IS_ADVANCED_RUN, selected);
        editor.commit();
    }

    public boolean isPuckConnected() {
        return pref.getBoolean(IS_PUCK_CONNECTED, false);
    }

    public void setIsPuckConnected(boolean connectStatus) {
        editor.putBoolean(IS_PUCK_CONNECTED, connectStatus);
        editor.commit();
    }

    public boolean isPuckDisconnected() {
        return pref.getBoolean(IS_PUCK_DISCONNECTED, false);
    }

    public void setIsPuckDisconnected(boolean connectStatus) {
        editor.putBoolean(IS_PUCK_DISCONNECTED, connectStatus);
        editor.commit();
    }

    // delete all values saved under advanced run preference.
    public void clearAdvancedRunPreference(){
        editorAdvance.clear();
        editorAdvance.commit();
    }

    // delete all values saved under the application.
    public void clearPreference(){
        editor.clear();
        editor.commit();
    }

    public void setSelectedRunTag(String tag){
        editorAdvance.putString(SELECTED_RUN_TAG, tag);
        editorAdvance.commit();
    }

    public String getSelectedRunTag(){
        return preferenceAdvance.getString(SELECTED_RUN_TAG, "");
    }
}
