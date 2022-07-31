INSERT INTO users (fullname, username, email, password, is_active, created_at, updated_at) 
VALUES ( 'John Admin', 'admin', 'admin@john.com', 'password', true, NOW(), NOW() ),
( 'John Doe', 'jdoe', 'john@doe.com', 'password', true, NOW(), NOW() );

INSERT INTO roles (name)
VALUES ('admin'), ('user');
