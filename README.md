
# Pos System 

## Overview
The POS System is a robust and well-structured online Point of Sale application built on a layered architecture. It leverages Spring Web MVC for handling web requests, Spring Data JPA and Hibernate for data persistence, and MySQL for the database. The system efficiently manages customer, inventory, and order data using AJAX (or similar mechanisms like fetch) for dynamic, real-time data handling, offering a seamless user experience. Designed for small to medium-sized businesses, the system ensures smooth transaction processing, inventory control, and
- Customer management
- Item Management
- Order Management
- Order Details Management

while maintaining scalability and flexibility.


## Features

### Customer Management:
- **Save Customer:** Add new entries effortlessly.
- **Get Customer:** Quickly search for customer details.
- **Update Customer:** Update existing customer information.
- **Delete Customer:** Delete customer records as needed.

### Item Management:
- **Save Item:** Add fresh items to the inventory.
- **Get Item:** Search and retrieve item details.
- **Update Item:** Update information for existing items.
- **Delete Item:** Remove items from the inventory with ease.

### Order Management:
- **Save Orders:** Create and process new orders.
- **Get All Orders:** Review and manage all existing orders. 

## Technologies Used ( Layererd Architecture)


**Handling Web Request:** Spring Web MVC

**Data Persistence:** Spring Data JPA, Hibernate

**Database:** MySQL

**Manages customer, inventory, and order data:** AJAX

## Controllers & End Points

### Customer Controller
- #### Save Customer: `POST /customer` - Add a new customer.
- #### Search Customer: `GET /customer/{id}` - Retrieve customer details by ID.
- #### Update Customer: `PUT /customer` - Update an existing customer's details.
- #### Delete Customer: `DELETE /customer/{id}` - Delete a customer by ID.
- #### GetAll Customers: `GET /customer` - Get a list of all customers.
### Item Controller
- #### Save Item: `POST /item` - Add a new item to the inventory.
- #### Get Item By ID : `GET /item/{id}` - Retrieve item details by ID.
- #### Update Item: `PUT /item` - Update information for an existing item.
- #### Delete Item: `DELETE /item/{id}` - Delete an item by ID.
- #### Get All Items: `GET /item` - Get a list of all items.
### Order Controller
- #### Create Order: `POST /order` - Initiate a new order.
- #### List Orders: `GET /order` - Retrieve a list of all orders.
## Getting Started

1. Clone the Repository: Run `git clone https://github.com/rashiniashinsana/AAD-Pos-Syastem-Backend-Assignment.git` to get the source code.
2. Set Up the Database: Configure your database settings in the `WebAppRootConfig` file.
3. Build and Run: Deploy the WAR file to Tomcat and start the application.
   
## API Documentation

For comprehensive API endpoints and usage instructions, please check out the [Postman Documentation](https://documenter.getpostman.com/view/36642476/2sAXxV5pbb).
## License

This project is licensed under the MIT License. For more information, view the LICENSE file.
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://github.com/rashiniashinsana/AAD-Pos-System-Backend-Assignment/blob/30148ed1290500d98e2a584d486eed81fd928505/LICENSE)
