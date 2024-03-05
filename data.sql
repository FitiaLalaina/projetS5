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
INSERT INTO action (name) VALUES
('Plantation'),
('Arrosage'),
('Insecticide');

-- Insertion des données dans la table "simulation"
INSERT INTO simulation (id_plot, id_culture, date_simulation) VALUES
(1, 1, '2024-01-01 10:00:00'),
(2, 2, '2024-01-10 12:30:00'),
(1, 1, '2024-01-21 10:00:00'),
(2, 2, '2024-02-02 12:30:00'),
(1, 1, '2024-02-04 10:00:00'),
(2, 2, '2024-02-11 12:30:00'),
(1, 1, '2024-02-17 10:00:00'),
(2, 2, '2024-03-28 12:30:00'),
(3, 1, '2024-04-03 15:45:00');

-- Insertion des données dans la table "simulation"
INSERT INTO simulation (id_plot, id_culture, date_simulation) VALUES
(1, 1, '2024-01-01 10:00:00'),
(2, 2, '2024-02-02 12:30:00'),
(3, 1, '2024-03-03 15:45:00'),
(4, 3, '2024-04-04 18:00:00');

-- Insertion des données dans la table "simulation_details"
INSERT INTO simulation_details (id_simulation, id_action, quantity, price) VALUES
(1, 1, 100, 50.0),
(2, 2, 1, 10.0),
(3, 3, 80, 100.0),
(4, 1, 120, 60.0),
(5, 2, 2, 20.0),
(6, 3, 70, 90.0),
(7, 1, 90, 45.0),
(8, 2, 3, 30.0),
(9, 3, 60, 80.0);

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

-- Insertion des données dans la table "yield"
INSERT INTO yield (id_simulation, date_yield, quantity) VALUES
(1, '2024-01-15 14:30:00', 150),
(2, '2024-02-20 16:45:00', 130),
(3, '2024-03-25 20:00:00', 180),
(4, '2024-04-30 22:15:00', 160);
