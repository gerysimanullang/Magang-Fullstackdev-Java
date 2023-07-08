-- Membuat tabel Categories
CREATE TABLE IF NOT EXISTS Categories (
    category_id SERIAL PRIMARY KEY,
    name TEXT
);

-- Membuat tabel Products
CREATE TABLE IF NOT EXISTS Products (
    product_id SERIAL PRIMARY KEY,
    name TEXT,
    description TEXT,
    price NUMERIC,
    category_id INTEGER,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

-- Membuat tabel Customers
CREATE TABLE IF NOT EXISTS Customers (
    customer_id SERIAL PRIMARY KEY,
    name TEXT,
    email TEXT,
    address TEXT,
    phone TEXT
);

-- Membuat tabel Cart
CREATE TABLE IF NOT EXISTS Cart (
    cart_id SERIAL PRIMARY KEY,
    customer_id INTEGER,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

-- Membuat tabel CartItems
CREATE TABLE IF NOT EXISTS CartItems (
    cart_item_id SERIAL PRIMARY KEY,
    cart_id INTEGER,
    product_id INTEGER,
    quantity INTEGER,
    FOREIGN KEY (cart_id) REFERENCES Cart(cart_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

-- Membuat tabel Transactions
CREATE TABLE IF NOT EXISTS Transactions (
    transaction_id SERIAL PRIMARY KEY,
    customer_id INTEGER,
    transaction_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

-- Membuat	 tabel TransactionItems
CREATE TABLE IF NOT EXISTS TransactionItems (
    transaction_item_id SERIAL PRIMARY KEY,
    transaction_id INTEGER,
    product_id INTEGER,
    quantity INTEGER,
    FOREIGN KEY (transaction_id) REFERENCES Transactions(transaction_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);
