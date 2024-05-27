package com.ecommerce.library.DataInitializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class CategoryData implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();

            // Array of category names
            String[] categories = {
                    "Arts & Crafts",
                    "Automotive",
                    "Baby",
                    "Beauty & Personal Care",
                    "Books",
                    "Boys' Fashion",
                    "Computers",
                    "Deals",
                    "Digital Music",
                    "Electronics",
                    "Girls' Fashion",
                    "Health & Household",
                    "Home & Kitchen",
                    "Industrial & Scientific",
                    "Kindle Store",
                    "Luggage",
                    "Men's Fashion",
                    "Movies & TV",
                    "Music, CDs & Vinyl",
                    "Pet Supplies",
                    "Prime Video",
                    "Software",
                    "Sports & Outdoors",
                    "Tools & Home Improvement",
                    "Toys & Games",
                    "Video Games",
                    "Women's Fashion"
            };

            // Inserting data for each category
            for (String category : categories) {
                // Escape single quotes in category name
                String escapedCategory = category.replace("'", "''");

                // Check if the category already exists
                String checkQuery = String.format("SELECT COUNT(*) AS count FROM categories WHERE name = '%s'", escapedCategory);
                ResultSet resultSet = statement.executeQuery(checkQuery);
                resultSet.next();
                int count = resultSet.getInt("count");

                if (count == 0) {
                    // If the category does not exist, insert it
                    String insertQuery = String.format("INSERT INTO categories (is_activated, is_deleted, name) VALUES (1, 0, '%s')", escapedCategory);
                    statement.executeUpdate(insertQuery);
                    System.out.println("Inserted category: " + category);
                } else {
                    // System.out.println("Category already exists: " + category);
                }
            }

            System.out.println("Data initialization completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
