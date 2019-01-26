-- ADD admin
INSERT INTO admin(name, password) VALUES('allen', '123456');

-- Add a default blog category 'Other', it means no category.
INSERT INTO category(created_time, updated_time, name, status, remark)
    VALUES(now(), now(), 'Other', '1', 'default category');