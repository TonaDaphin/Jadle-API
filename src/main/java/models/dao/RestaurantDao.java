package models.dao;

import models.Foodtype;
import models.Restaurant;
import java.util.List;

public interface RestaurantDao {



    //read
    List<Restaurant> getAll();
    Restaurant findById(int id);
     List<Foodtype> getAllFoodtypesByRestaurant(int restaurantId);

    //update
    void update(int id, String name, String address, String zipcode, String phone, String website, String email);

    //delete
    void deleteById(int id);
    void clearAll();

//create

    void add (Restaurant restaurant);
    void addRestaurantToFoodtype(Restaurant testRestaurant, Foodtype testFoodtype);
}