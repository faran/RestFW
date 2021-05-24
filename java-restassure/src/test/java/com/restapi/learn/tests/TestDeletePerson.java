package com.restapi.learn.tests;

import com.restapi.learn.helpers.PersonalServiceHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDeletePerson {
    private PersonalServiceHelper personalServiceHelper;

    @BeforeClass
    public void init(){
        personalServiceHelper = new PersonalServiceHelper();
    }

    @Test
    public void testDeletePerson(){
        String id = personalServiceHelper.deletePerson(3).jsonPath().getString("id");
        Assert.assertNull(id, "Person id is not null");

    }
}
