package com.example.ntex_user.testoh.model;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;

import static com.example.ntex_user.testoh.Validatable.isNotEmpty;

/**
 * Created by NTex-User on 3/14/2017.
 */

public class OneObject {
    @SerializedName("task_id")
    private int task;
    @SerializedName("type")
    private int type;
    @SerializedName("location_id")
    private String location_id;
    @SerializedName("reporter")
    private int reporter;
    @SerializedName("assignee")
    private int assignee;
    @SerializedName("timeBegin")
    private String timeBegin;
    @SerializedName("timeExpired")
    private String timeExpired;
    @SerializedName("dateCreate")
    private String dataCreate;
    @SerializedName("description")
    private String description;
    @SerializedName("status")
    private int status;
    @SerializedName("state")
    private int state;

    public static OneObject fromJson(String json) {
        if (isNotEmpty(json)) {
            try {
                return new Gson().fromJson(json, OneObject.class);
            } catch (JsonSyntaxException e) {

            }
        }
        return null;
    }

    public OneObject(int task, int type, String location_id, int reporter, int assignee, String timeBegin, String timeExpired, String dataCreate, String description, int status, int state) {
        this.task = task;
        this.type = type;
        this.location_id = location_id;
        this.reporter = reporter;
        this.assignee = assignee;
        this.timeBegin = timeBegin;
        this.timeExpired = timeExpired;
        this.dataCreate = dataCreate;
        this.description = description;
        this.status = status;
        this.state = state;
    }

    public int getTask() {
        return task;
    }

    public int getType() {
        return type;
    }

    public String getLocation_id() {
        return location_id;
    }

    public int getReporter() {
        return reporter;
    }

    public int getAssignee() {
        return assignee;
    }

    public String getTimeBegin() {
        return timeBegin;
    }

    public String getTimeExpired() {
        return timeExpired;
    }

    public String getDataCreate() {
        return dataCreate;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }

    public int getState() {
        return state;
    }
}
