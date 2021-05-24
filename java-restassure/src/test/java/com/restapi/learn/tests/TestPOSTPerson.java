package com.restapi.learn.tests;

import com.restapi.learn.helpers.PersonalServiceHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPOSTPerson {

    private PersonalServiceHelper personalServiceHelper;

    @BeforeClass
    public void init(){
        personalServiceHelper = new PersonalServiceHelper();
    }

    @Test
    public void testPOSTCretePerson(){
        String id = personalServiceHelper.createPerson().jsonPath().getString("id");
        Assert.assertNotNull(id, "Person id is null");

    }


}
