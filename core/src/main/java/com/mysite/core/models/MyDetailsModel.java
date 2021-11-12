package com.mysite.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

@Model(adaptables = Resource.class)
public class MyDetailsModel {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Inject
    private String fname;

    @Inject
    private String lname;

    @Inject
    private String dob;

    @Inject
    private  String gender;

    @Inject
    private String maritalstatus;

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public String getFullName()
    {
        return fname + " "+ lname;
    }

    public int getAge() throws ParseException {

        LOGGER.info("Calculating date...");

        String dob=getDob();
        LocalDate Dob=LocalDate.parse(dob);

        LocalDate currentDate=LocalDate.now();
        int age= Period.between(Dob,currentDate).getYears();

        LOGGER.info("Calculated date is {}", age);

        return age;

    }

    public String getHonorific()
    {
        String gender=getGender();
        String maritalStatus=getMaritalstatus();

        if(gender.equals("male"))
        {
            return "Mr";
        }
        else if(gender.equals("female") && maritalStatus.equals("single"))
        {
            return "Ms";
        }
        else
        {
            return "Mrs";
        }
    }
}














