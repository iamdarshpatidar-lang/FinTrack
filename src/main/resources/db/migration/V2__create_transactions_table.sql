
CREATE TABLE transactions (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,

                              user_id BIGINT NOT NULL,

                              type VARCHAR(10) NOT NULL,

                              amount DECIMAL(12,2) NOT NULL,

                              category VARCHAR(50) NOT NULL,

                              description VARCHAR(255),

                              transaction_date DATE NOT NULL,

                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                              CONSTRAINT fk_transactions_user
                                  FOREIGN KEY (user_id)
                                      REFERENCES users(id)
);
