CREATE OR REPLACE FUNCTION update_customer(
    in_id BIGINT,
    in_code VARCHAR,
    in_name VARCHAR,
    in_phone VARCHAR,
    in_iban VARCHAR,
    in_surname VARCHAR,
    in_address VARCHAR
) RETURNS VOID AS $$
BEGIN
    UPDATE customer
    SET code = in_code, name = in_name, phone = in_phone, iban = in_iban, surname = in_surname, address = in_address
    WHERE id = in_id;
END;
$$ LANGUAGE plpgsql;

