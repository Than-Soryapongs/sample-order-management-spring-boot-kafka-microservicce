CREATE TABLE IF NOT EXISTS inventory (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id  VARCHAR(100) NOT NULL UNIQUE,
    quantity    INT          NOT NULL DEFAULT 0,
    updated_at  DATETIME     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_product_id (product_id)
);

-- Seed some initial stock
INSERT INTO inventory (product_id, quantity) VALUES ('PROD-001', 100);
INSERT INTO inventory (product_id, quantity) VALUES ('PROD-002', 50);
INSERT INTO inventory (product_id, quantity) VALUES ('PROD-003', 200);