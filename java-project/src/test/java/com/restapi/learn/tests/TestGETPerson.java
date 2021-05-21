package com.restapi.learn.tests;

import com.restapi.learn.helpers.PersonalServiceHelper;
import com.restapi.learn.models.Person;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestGETPerson {

    private PersonalServiceHelper personalServiceHelper;

    @BeforeClass
    public void init(){
        personalServiceHelper = new PersonalServiceHelper();
    }

    @Test
    public void testGetAllPerson(){

        List<Person> personList = personalServiceHelper.getAllPerson();
        Assert.assertNotNull(personList, "Person list is not empty");
        Assert.assertFalse(personList.isEmpty(), "Person list is not empty");
    }
}
