CREATE TABLE IF NOT EXISTS orders (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id  VARCHAR(100) NOT NULL,
    quantity    INT          NOT NULL,
    status      VARCHAR(50)  NOT NULL,
    created_at  DATETIME     DEFAULT CURRENT_TIMESTAMP,

    INDEX idx_product_id (product_id),
    INDEX idx_status     (status),
    INDEX idx_created_at (created_at)
);