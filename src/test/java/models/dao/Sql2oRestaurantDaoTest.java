package models.dao;

import models.Foodtype;
import models.Restaurant;
import models.dao.Sql2oFoodtypeDao;
import models.dao.Sql2oRestaurantDao;
import models.dao.Sql2oReviewDao;
import org.junit.*;

import static org.junit.Assert.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Arrays;

public class Sql2oRestaurantDaoTest {
    private static Connection conn; //these variables are now static.
    private static Sql2oRestaurantDao restaurantDao; //these variables are now static.
    private static Sql2oFoodtypeDao foodtypeDao; //these variables are now static.
    private static Sql2oReviewDao reviewDao; //these variables are now static.

    @BeforeClass //changed to @BeforeClass (run once before running any tests in this file)
    public static void setUp() throws Exception { //changed to static
        String connectionString = "jdbc:postgresql://localhost:5432/jadle_test"; //connect to postgres test database
        Sql2o sql2o = new Sql2o(connectionString, null, null); //changed user and pass to null for mac users...Linux & windows need strings
        restaurantDao = new Sql2oRestaurantDao(sql2o);
        foodtypeDao = new Sql2oFoodtypeDao(sql2o);
        reviewDao = new Sql2oReviewDao(sql2o);
        conn = sql2o.open(); //open connection once before this test file is run
    }

    @After //run after every test
    public void tearDown() throws Exception {  //I have changed
        System.out.println("clearing database");
        restaurantDao.clearAll(); //clear all restaurants after every test
        foodtypeDao.clearAll(); //clear all restaurants after every test
        reviewDao.clearAll(); //clear all restaurants after every test
    }

    @AfterClass //changed to @AfterClass (run once after all tests in this file completed)
    public static void shutDown() throws Exception{ //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }
}