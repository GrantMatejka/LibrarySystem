DELIMITER $
CREATE TRIGGER `check_extend_trigger` BEFORE UPDATE ON `Transactions`
FOR EACH ROW
BEGIN

IF new.extend = 1 AND old.extend = 0
THEN 
    
	SET @reserved = (SELECT * FROM Reservations WHERE NEW.bookId = bookId AND fullFilled = 0);
    IF reserved.fullFilled = 0 AND reserved IS NOT NULL
    THEN 
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Book reserved by someone else';
    END IF;
END IF;

END$ 
DELIMITER ;