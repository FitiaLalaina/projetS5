-- Insertion des données dans la table "owner"
INSERT INTO owner (name, email, pwd) VALUES
('John Doe', 'john@example.com', 'password123'),
('Jane Smith', 'jane@example.com', 'password456'),
('Robert Johnson', 'robert@example.com', 'password789');

-- Insertion des données dans la table "ground_type"
INSERT INTO ground_type (name) VALUES
('Type A'),
('Type B'),
('Type C');

-- Insertion des données dans la table "field"
INSERT INTO field (latitude, longitude, id_owner) VALUES
(40.7128, -74.0060, 1),
(34.0522, -118.2437, 2),
(41.8781, -87.6298, 3);

-- Insertion des données dans la table "plot"
INSERT INTO plot (id_field, area, id_ground_type) VALUES
(1, 10.5, 1),
(1, 8.2, 2),
(2, 15.2, 1),
(3, 12.0, 3);

-- Insertion des données dans la table "action"
INSERT INTO action (name, cons) VALUES
('Plantation', 0 ),
('Arrosage', 50 ),
('Insecticide', 10 ),
('Recolte',	0 ),
('Ajout Engrais', 20 );

-- Insertion des données dans la table "field"
INSERT INTO field (latitude, longitude, id_owner) VALUES
(40.7128, -74.0060, 1),
(34.0522, -118.2437, 2),
(41.8781, -87.6298, 3);

-- Insertion des données dans la table "culture"
INSERT INTO culture (name, seed_quantity, yield_quantity, unit, seed_price, yield_price, id_ground_type) VALUES
('Culture A', 10.0, 200.0, 1, 5.0, 100.0, 1),
('Culture B', 8.0, 180.0, 2, 4.0, 90.0, 2),
('Culture C', 12.0, 220.0, 1, 6.0, 110.0, 3);

-- Insertion des données dans la table "plot"
INSERT INTO plot (id_field, area, id_ground_type) VALUES
(1, 10.5, 1),
(1, 8.2, 2),
(2, 15.2, 1),
(3, 12.0, 3);

INSERT INTO Ressource (name, price_per_unit, id_action, pros) VALUES
('human ressource',	0, 1, 0),
('water', 200, 2, 5),
('Insecticide 1', 500, 3, 5),
('Insecticide 2', 1000, 3, 10),
('Insecticide 3',2000, 3, 15),
('human ressource', 0, 4, 0),
('Engrais 1', 1200, 5, 10),
('Engrais 2', 2000, 5, 20),
('Engrais 3', 3000, 5, 30);
