CREATE TABLE orders
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(255)                                                                                         NOT NULL,
    `order`   ENUM ( 'Chickenjoy', 'Jolly Spaghetti', 'Burger Steak', 'Yumburger', 'Chicken Sandwhich', 'Palabok') NOT NULL,
    quantity  INT UNSIGNED                                                                                         NOT NULL,
    price     DOUBLE UNSIGNED                                                                                      NOT NULL,
    isPending BOOLEAN                                                                                              NOT NULL
);

INSERT INTO orders
VALUES (1, 'Ryan Caezar Itang', 'Jolly Spaghetti', 1, 60, 0),
       (2, 'Mitch Andaya', 'Chickenjoy', 2, 164, 0),
       (3, 'Ryan', 'Palabok', 2, 276, 0),
       (4, 'Bennett', 'Chicken Sandwhich', 3, 447, 0),
       (5, 'sitiom', 'Chicken Sandwhich', 1, 149, 1);
