package com.restapi.learn.tests;

import com.restapi.learn.helpers.PersonalServiceHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPATCHPerson {

    private PersonalServiceHelper personalServiceHelper;

    @BeforeClass
    public void init(){
        personalServiceHelper = new PersonalServiceHelper();
    }

    @Test
    public void testPATCHPerson(){
        String id = personalServiceHelper.updatePerson(3).jsonPath().getString("id");
        Assert.assertNotNull(id, "not updated");
    }
}
