DELIMITER $
CREATE TRIGGER `checked_in_trigger` AFTER UPDATE ON `Transactions`
FOR EACH ROW
BEGIN

SET @count = (SELECT checkedOut FROM group09.Inventory WHERE old.bookId = bookId);

IF old.checkedIn <> new.checkedIn
THEN 
	UPDATE Inventory i SET i.checkedOut = count - 1 WHERE i.bookId = old.bookId;
END IF;

END$ 
DELIMITER ;