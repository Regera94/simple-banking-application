CREATE TABLE IF NOT EXISTS `accounts` (
                                          `account_id` INT AUTO_INCREMENT PRIMARY KEY,
                                          `account_number` VARCHAR(100) NOT NULL UNIQUE,
    `account_type` VARCHAR(100) NOT NULL,
    `branch_address` VARCHAR(200) NOT NULL,
    `created_at` DATE NOT NULL,
    `created_by` VARCHAR(20) NOT NULL,
    `updated_at` DATE DEFAULT NULL,
    `updated_by` VARCHAR(20) DEFAULT NULL,
    `customer_id` INT NOT NULL,
    CONSTRAINT fk_accounts_customers FOREIGN KEY (`customer_id`)
    REFERENCES `customer`(`customer_id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
    );
