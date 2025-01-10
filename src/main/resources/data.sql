INSERT INTO Users (name, email, phone_number)
VALUES
('John Doe', 'john@example.com', '1234567890'),
('Jane Smith', 'jane@example.com', '9876543210'),
('Mike Johnson', 'mike@example.com', '5551234567'),
('Emily Brown', 'emily@example.com', '2223334445'),
('David Lee', 'david@example.com', '6667778889'),
('Sarah Taylor', 'sarah@example.com', '3334445556'),
('Kevin White', 'kevin@example.com', '9990001111'),
('Lisa Miller', 'lisa@example.com', '2223334445'),
('Tom Harris', 'tom@example.com', '6667778889'),
('Amy Wilson', 'amy@example.com', '3334445556');


INSERT INTO Branches (name, address, phone)
VALUES
('Branch 1', 'Address 1', '1234567890'),
('Branch 2', 'Address 2', '0987654321'),
('Branch 3', 'Address 3', '2468135790'),
('Branch 4', 'Address 4', '1357924680'),
('Branch 5', 'Address 5', '3579249638'),
('Branch 6', 'Address 6', '4687531923'),
('Branch 7', 'Address 7', '5790348267'),
('Branch 8', 'Address 8', '6903457238'),
('Branch 9', 'Address 9', '7916340587'),
('Branch 10', 'Address 10', '9235678349');

INSERT INTO Employees (name, phone_number, title, availability)
VALUES
('John Doe', '1234567890', 'Manager', TRUE),
('Jane Smith', '0987654321', 'HR Specialist', FALSE),
('Mike Johnson', '2468135790', 'IT Support', TRUE),
('Emily Brown', '1357924688', 'Accountant', TRUE),
('David Lee', '3579249635', 'Sales Representative', FALSE),
('Sarah Taylor', '4687531923', 'Marketing Manager', TRUE),
('Kevin White', '5790348267', 'Customer Service', FALSE),
('Lisa Nguyen', '6903457238', 'Graphic Designer', TRUE),
('Tom Harris', '7916340587', 'Software Developer', TRUE),
('Amy Martin', '9235678349', 'Project Coordinator', FALSE);

INSERT INTO Requests (employee_id, user_id, description, status, data_create, close_date)
VALUES
(1, 1, 'Request for IT support', 'Open', '2023-10-01 09:00:00', NULL),
(2, 2, 'HR inquiry', 'In Progress', '2023-10-02 14:30:00', NULL),
(3, 3, 'Accounting issue', 'Closed', '2023-09-15 08:45:00', '2023-09-16 17:00:00'),
(4, 4, 'Sales report request', 'Pending', '2023-10-03 10:15:00', NULL),
(5, 5, 'Marketing material approval', 'In Review', '2023-09-25 11:00:00', NULL),
(6, 6, 'Technical problem', 'Open', '2023-10-04 13:45:00', NULL),
(7, 7, 'Customer service feedback', 'Closed', '2023-08-01 09:30:00', '2023-08-02 15:45:00'),
(8, 8, 'New project proposal', 'Pending', '2023-10-05 09:00:00', NULL),
(9, 9, 'System update request', 'In Progress', '2023-09-28 10:30:00', NULL),
(10, 10, 'Performance review', 'Completed', '2023-09-12 14:00:00', '2023-09-13 17:00:00');

INSERT INTO Answers (employee_id, description, data_of_response)
VALUES
(1, 'IT support issue resolved.', '2023-10-01 09:00:00'),
(2, 'HR inquiry addressed.', '2023-10-02 14:30:00'),
(3, 'Accounting issue fixed.', '2023-09-15 08:45:00'),
(4, 'Sales report prepared.', '2023-09-16 17:00:00'),
(5, 'Marketing materials approved.', '2023-09-16 17:00:00'),
(6, 'Technical problem resolved.', '2023-10-03 10:15:00'),
(7, 'Customer feedback noted.', '2023-09-25 11:00:00'),
(8, 'New project proposal received.', '2023-10-04 13:45:00'),
(9, 'System update completed.', '2023-09-28 10:30:00'),
(10, 'Performance review conducted.', '2023-09-12 14:00:00');

