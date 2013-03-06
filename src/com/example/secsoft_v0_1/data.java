package com.example.secsoft_v0_1;

import android.*;
import android.R;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: cybrix
 * Date: 04/03/13
 * Time: 14:18
 * This sets up the sqlite database. It includes all tables and fields.
 * It also saves data like login passwords.
 */



          //TODO check sqldatabase def

public class data extends SQLiteOpenHelper {


    public String venuePassword;
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_COMMENTS = "comments";
    private static final String DATABASE_NAME = "data.db";
    private static final String Venue_Table =
            "CREATE TABLE Venue (ID TEXT, Name TEXT, Address TEXT, " +
                    "Tell_No TEXT, General_Manager TEXT, Security_Manager TEXT, Capacity NUMERIC);";
    private static final String User_Table =
            "CREATE TABLE Users (ID TEXT, ForeName TEXT, SireName TEXT, " +
                    "Account_Type TEXT, Badge_No TEXT, Badge_Expiry BLOB, Tell_No TEXT, Password TEXT);";
    private static final String Capacity_Table =
             "CREATE TABLE CapacityCheck (TotalInside NUMERIC, PeopleOut NUMERIC," +
                     " PeopleIn NUMERIC, TimeNow Time, OpeningDate Date);";
    private static final String Venue_Check =
            "CREATE TABLE VenueCheck (TodayDate Date, TimeNow Time, StaffID TEXT, " +
                    "CheckType TEXT, Location TEXT, Details TEXT);";
    private static final String Check_Type =
            "CREATE TABLE CheckType (TypeOfCheck TEXT);";
    private static final String Refusals =
            "CREATE TABLE Refusals (TodaysDate Date, Time_Period TEXT, Reason TEXT, IC_Code NUMERIC, Sex TEXT);";
    private static final String RefusalsReasons =
            "CREATE TABLE RefusalReasons (Reason TEXT);";
    private static final String IncidentReport =
            "CREATE TABLE IncidentReport (TodaysDate Date, TimeOfIncident Time, TypeOfIncident TEXT, VictimName TEXT, " +
                    "VictimDOB Date, VictimAddress TEXT, VictimTell TEXT, Injury TEXT, Location TEXT, FirstAid TEXT, " +
                    "FirstAider TEXT, EmergencyServicesRef TEXT, Description TEXT, StaffInvolved TEXT);";
    private static final String Incident_Reasons =
             "CREATE TABLE IncidentReason (TypeOfIncident TEXT);";
    private static final String IC_Codes =
            "CREATE TABLE ICCodes (ICCode NUMERIC, Description TEXT);";



     public data(Context context)
        {
             super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

     @Override
     public void onCreate(SQLiteDatabase database)
        {
            database.execSQL(Venue_Table);
            database.execSQL(User_Table);
            database.execSQL(Capacity_Table);
            database.execSQL(Venue_Check);
            database.execSQL(Check_Type);
            database.execSQL(Refusals);
            database.execSQL(RefusalsReasons);
            database.execSQL(IncidentReport);
            database.execSQL(Incident_Reasons);
            database.execSQL(IC_Codes);
        }

     @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
     {
         Log.w(data.class.getName(),
                 "Upgrading database from version " + oldVersion + " to "
                         + newVersion + ", which will destroy all old data");
         db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
         onCreate(db);
     }

 }
