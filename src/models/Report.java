/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;


public class Report {
    
    private int user_id;
    private int id;
    private String title;
    private String description;
    private int status;
    private LocalDateTime created_at;

    public Report() {
    }

    public Report(int user_id, int id, String title, String description, int status, LocalDateTime created_at) {
        this.user_id = user_id;
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.created_at = created_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }
    
    public static String getStatusName(int cStatus){
        switch(cStatus){
            case 0: return "Pending";
            case 1: return "Progress";
            case 2: return "Cancel";
            case 3: return "Done";
            case 4: return "Rejected";
            default:  return "";
        }
    }
    
    public static int getStatusFromName(String statusName){
        switch(statusName){
            case "Pending": return 0;
            case "Progress": return 1;
            case "Cancel": return 2;
            case "Done": return 3;
            case "Rejected": return 4;
            default:  return -1;
        }
    }
    
    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
    
    
    
    
}
