CREATE TABLE Books (
    asin VARCHAR(15),
    copyNum INT AUTO_INCREMENT,
    filename VARCHAR(20),
    imageUrl VARCHAR(100),
    title VARCHAR(200),
    author VARCHAR(50),
    categoryId INT,
    category VARCHAR(20),
    KEY(copyNum),
    PRIMARY KEY(asin, copyNum)
);

CREATE TABLE Inventory (
    bookId VARCHAR(15) REFERENCES Books(asin),
    totalQuantity INT,
    checkedOut INT,
    PRIMARY KEY(bookId)
);

CREATE TABLE Permissions (
    permissionLevel VARCHAR(15),
    checkoutPeriod INT,
    PRIMARY KEY(permissionLevel)
);

CREATE TABLE Users (
    id INT AUTO_INCREMENT,
    username VARCHAR(30),
    name VARCHAR(30),
    permissionLevel VARCHAR(15) REFERENCES Permissions(permissionLevel),
    PRIMARY KEY(id)
);

CREATE TABLE Transactions (
    id INT AUTO_INCREMENT,
    bookId VARCHAR(15) REFERENCES Books(asin),
    copyNum INT REFERENCES Books(copyNum),
    userId INT REFERENCES Users(id),
    checkOutDate DATE,
    expectedCheckInDate DATE,
    extend BOOLEAN,
    PRIMARY KEY(id)
);

CREATE TABLE Reservations (
    id INT AUTO_INCREMENT,
    dateReserved DATE,
    userId INT REFERENCES Users(id),
    bookId VARCHAR(15) REFERENCES Books(asin),
    fullFilled BOOLEAN,
    PRIMARY KEY(id)
);
