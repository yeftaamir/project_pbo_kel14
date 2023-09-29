/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Report;
import models.User;
import utils.ConstUtil;
import utils.DatabaseUtil;

/**
 *
 * @author USER
 */
public class ReportController {
    
    private DatabaseUtil koneksi;
    private ResultSet rs;
    private PreparedStatement pre;
    
    public ReportController(){
        koneksi = new DatabaseUtil();
    }
    
    public ArrayList<Report> getToMember(){
        ArrayList<Report> result = new ArrayList<Report>();
        rs = koneksi.executeSelect("SELECT * FROM reports WHERE status IN (0, 1) ORDER BY created_at DESC");
        if(rs != null){
            try{
                while(rs.next()){
           
                    Report re = new Report(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                           rs.getTimestamp(6).toLocalDateTime()
                        );
                    result.add(re);
                }
            } catch (Exception ex){
                
            }
        }
        return result;
    }
    
    public ArrayList<Report> getMy(){
        ArrayList<Report> result = new ArrayList<Report>();
        rs = koneksi.executeSelect("SELECT * FROM reports WHERE user_id = " + ConstUtil.auth.getId() + " ORDER BY created_at DESC");
        if(rs != null){
            try{
                while(rs.next()){
           
                    Report re = new Report(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                           rs.getTimestamp(6).toLocalDateTime()
                        );
                    result.add(re);
                }
            } catch (Exception ex){
                
            }
        }
        return result;
    }
    
    public ArrayList<Report> getAll(){
        ArrayList<Report> result = new ArrayList<Report>();
        rs = koneksi.executeSelect("SELECT * FROM reports ORDER BY STATUS, created_at DESC");
        if(rs != null){
            try{
                while(rs.next()){
           
                    Report re = new Report(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                           rs.getTimestamp(6).toLocalDateTime()
                        );
                    result.add(re);
                }
            } catch (Exception ex){
                
            }
        }
        return result;
    }
    
    public Boolean insert(Report report){
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(ConstUtil.auth.getId()));
        data.add(report.getTitle());
        data.add(report.getDescription());
        
         if (koneksi.execute("INSERT INTO reports (user_id, title, description) VALUES (?, ?, ?)", data)){
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean updateStatus(int id, int status){
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(status));
        data.add(String.valueOf(id));
        
         if (koneksi.execute("UPDATE reports SET status = ? WHERE id = ?", data)){
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean delete(int id){
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(id));
        
         if (koneksi.execute("DELETE FROM reports WHERE id = ?", data)){
            return true;
        } else {
            return false;
        }
    }
    
}
