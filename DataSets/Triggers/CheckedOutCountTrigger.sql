DELIMITER $
CREATE TRIGGER `checkout_count_trigger` AFTER INSERT ON `Transactions`
FOR EACH ROW
BEGIN

SET @count = (SELECT checkedOut FROM group09.Inventory WHERE NEW.bookId = bookId);

UPDATE Inventory i SET i.checkedOut = count + 1 WHERE i.bookId = NEW.bookId;


END$ DELIMITER ;