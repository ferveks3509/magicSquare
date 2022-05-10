CREATE TABLE magic_square (
    id INT IDENTITY PRIMARY KEY,
    input VARCHAR(9),
    result VARCHAR(9)
);
CREATE TABLE str_model (
    id INT IDENTITY PRIMARY KEY,
    input_str VARCHAR(100),
    compare_str VARCHAR(100),
    result_str VARCHAR(100)
);