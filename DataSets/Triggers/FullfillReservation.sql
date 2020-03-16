DELIMITER $
CREATE TRIGGER `fullfill_reservation` AFTER INSERT ON `Transactions`
FOR EACH ROW
BEGIN

UPDATE Reservations r SET r.fullfilled = 1 WHERE r.userId = NEW.userId AND r.bookId = NEW.bookId;

END$ 
DELIMITER ;