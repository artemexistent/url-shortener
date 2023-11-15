CREATE TABLE url_mapping
(
    id           SERIAL PRIMARY KEY,
    short_url    VARCHAR(255)  NOT NULL,
    original_url VARCHAR(2048) NOT NULL,
    created_at   TIMESTAMP     NOT NULL,
    updated_at   TIMESTAMP,
    password     VARCHAR(255)
);

CREATE TABLE click
(
    id              SERIAL PRIMARY KEY,
    url_mapping_id  INTEGER   NOT NULL,
    count           INTEGER   NOT NULL,
    last_clicked_at TIMESTAMP NOT NULL,
    FOREIGN KEY (url_mapping_id) REFERENCES url_mapping (id)
);

CREATE INDEX idx_short_url ON url_mapping (shortUrl);