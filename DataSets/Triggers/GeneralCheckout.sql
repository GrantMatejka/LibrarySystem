use group09;
drop trigger general_checkout_trigger;
DELIMITER $
CREATE TRIGGER `general_checkout_trigger` BEFORE INSERT ON `Transactions`
FOR EACH ROW
BEGIN

SET @stock = (SELECT totalQuantity - checkedOut FROM group09.Inventory i WHERE i.bookId = NEW.bookId);
SET @reserved = (SELECT COUNT(fullFilled) FROM group09.Reservations r WHERE r.bookId = NEW.bookId AND fullFilled = 0);

IF @stock < 1 OR (@stock = @reserved)
THEN
	SIGNAL SQLSTATE '41900'
	SET MESSAGE_TEXT = 'No copies of book can be checked out, none available';
END IF;

END$ DELIMITER ;