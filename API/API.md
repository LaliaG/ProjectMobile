1. Authentication Microservice
Base URL: /api/auth

Endpoints:
POST /login: Authenticate user with email and password, return JWT token.
POST /register: Register a new user (this can be part of the User Management service).
POST /refresh-token: Refresh the JWT token.

Example:
POST /api/auth/login
{
    "email": "john@example.com",
    "password": "Password123"
}




2. # User Management Microservice
Base URL: /api/users

Endpoints:
POST /register: Register a new user.
POST /login: Login a user and return a JWT token.
GET /profile: Get logged-in user's profile (requires authentication).
PUT /profile: Update user profile (authenticated user).
PUT /change-password: Change user's password (authenticated user).
GET /all: Get all users (Admin only).
DELETE /delete/{id}: Delete a user by ID (Admin only).

For example:
POST /api/users/register
{
    "name": "John Doe",
    "email": "john@example.com",
    "password": "Password123"
}

3. # Order Management Microservice
Base URL: /api/orders

Endpoints:
POST /create: Create a new order (authenticated user).
GET /my-orders: Get orders for logged-in user (authenticated user).
GET /list: Get all orders (Admin only).
GET /get/{id}: Get order details by order ID.
PUT /update/{id}: Update order details (Admin or order owner).
DELETE /cancel/{id}: Cancel an order (Admin or order owner).

Example:
POST /api/orders/create
{
    "products": [
        {"id": "product1-uuid", "quantity": 2},
        {"id": "product2-uuid", "quantity": 1}
    ],
    "totalAmount": 150.50
}

4. # Product Management Microservice
Base URL: /api/products

Endpoints:
POST /create: Create a new product (Admin only).
GET /list: List all products.
GET /get/{id}: Get product details by product ID.
PUT /update/{id}: Update product details (Admin only).
DELETE /delete/{id}: Delete a product (Admin only).

Example:
POST /api/products/create
{
    "name": "Product Name",
    "description": "Product Description",
    "price": 20.99,
    "stock": 50,
    "subCategory": "subcategory-uuid"
}

5. # Delivery Management Microservice
Base URL: /api/deliveries

Endpoints:
POST /create: Create a delivery record for an order (Admin only).
GET /list: Get all deliveries (Admin only).
GET /get/{id}: Get delivery details by delivery ID.
PUT /update/{id}: Update delivery status (Admin only).
DELETE /delete/{id}: Delete a delivery record (Admin only).

Example:
POST /api/deliveries/create
{
    "order": "order-uuid",
    "deliveryType": "express"
}

6. # Stock Management Microservice
Base URL: /api/stock

Endpoints:
POST /restock: Restock a product (Admin only).
POST /decrease: Decrease stock for a product (Admin only).
GET /get/{productId}: Get stock details by product ID.

Example:
POST /api/stock/restock
{
    "product": "product-uuid",
    "quantity": 100
}


7. # Category Management Microservice
Base URL: /api/categories

Endpoints:
POST /create: Create a new category (Admin only).
GET /list: List all categories.
GET /get/{id}: Get category details by category ID.
PUT /update/{id}: Update category details (Admin only).
DELETE /delete/{id}: Delete a category (Admin only).

Example:
POST /api/categories/create
{
    "name": "Electronics"
}

8. # SubCategory Management Microservice
Base URL: /api/subcategories

Endpoints:
POST /create: Create a new subcategory (Admin only).
GET /list: List all subcategories.
GET /get/{id}: Get subcategory details by subcategory ID.
PUT /update/{id}: Update subcategory details (Admin only).
DELETE /delete/{id}: Delete a subcategory (Admin only).

Example:
POST /api/subcategories/create
{
    "name": "Smartphones",
    "category": "category-uuid"
}

Mais je vais me limiter à ça dans un premier temps

# Authentification :
/api/auth/register : Inscription d'un utilisateur.
/api/auth/login : Connexion et génération de token JWT.

# Gestion des utilisateurs :
/api/users : CRUD pour les utilisateurs (GET, POST, PUT, DELETE).

# Gestion des commandes :
/api/orders : CRUD pour les commandes.

# Gestion des livraisons :
/api/deliveries : Gestion du statut et du type des livraisons.

# Gestion des produits et stocks :
/api/products : Gestion des produits (GET, POST, PUT, DELETE).
/api/stock : Gestion du stock (restockage, réduction du stock après livraison).


